package com.example.app.ui.extenstions

import android.annotation.SuppressLint
import android.view.MotionEvent
import android.view.View
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.MutableLiveData
import com.example.app.android.viewmodel.BaseViewModel
import com.example.app.ui.snackbar.SnackbarMessage
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

@Composable
fun <VM : BaseViewModel<S>, S> VM.observeAsState(): State<S> {
    return stateLiveData.observeAsState(initial = stateLiveData.value!!)
}

fun Exception.getSnackBarMessage(): SnackbarMessage {
    return SnackbarMessage(
        messageId = message.hashCode(),
        message = message
    )
}

@SuppressLint("ClickableViewAccessibility")
fun View.disallowParentTouchEvents() {
    setOnTouchListener { v, event ->
        v.parent.requestDisallowInterceptTouchEvent(true)
        when (event.action and MotionEvent.ACTION_MASK) {
            MotionEvent.ACTION_UP ->
                v.parent.requestDisallowInterceptTouchEvent(false)
        }
        false
    }
}

fun <T> MutableLiveData<T>.notifyChange() {
    value = value
}

fun <T> T.isNull(): Boolean = this == null

fun <T> T.isNotNull(): Boolean = this != null

fun <T> delayFlow(timeout: Long, value: T): Flow<T> = flow {
    delay(timeout)
    emit(value)
}