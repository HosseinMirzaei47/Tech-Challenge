import com.example.app.ui.extenstions.delayFlow
import com.example.app.ui.snackbar.SnackbarMessage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.merge
import javax.inject.Inject

class SnackbarManager(private val delayAmount: Long) {

    @Inject
    constructor() : this(6000)

    // We want a maximum of 2 errors queued
    private val pendingErrors = MutableSharedFlow<SnackbarMessage>(extraBufferCapacity = 2)
    private val removeErrorSignal = MutableSharedFlow<Unit>(extraBufferCapacity = 1)

    /**
     * A flow of [SnackbarMessage]s to display in the UI, usually as snackbars. The flow will immediately
     * emit `null`, and will then emit errors sent via [sendError]. Once 6 seconds has elapsed,
     * or [removeCurrentError] is called (if before that) `null` will be emitted to remove
     * the current error.
     */
    val errors: Flow<SnackbarMessage?> = flow {
        emit(null)

        pendingErrors.collect {
            emit(it)

            // if is not indefinite Wait for either timeout, or a remove signal (whichever comes first) else just remove signal
            if (it.duration != 2) {
                merge(
                    delayFlow(delayAmount, Unit),
                    removeErrorSignal,
                ).firstOrNull()
            } else {
                removeErrorSignal.firstOrNull()
            }
            // Remove the error
            emit(null)
        }
    }

    /**
     * Add [error] to the queue of errors to display.
     */
    suspend fun sendError(error: SnackbarMessage) {
        pendingErrors.emit(error)
    }

    /**
     * Remove the current error from being displayed.
     */
    suspend fun removeCurrentError() {
        removeErrorSignal.emit(Unit)
    }
}
