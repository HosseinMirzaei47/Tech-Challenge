package com.example.app.android.viewmodel

import androidx.lifecycle.*
import com.example.app.shared.resource.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.reflect.KProperty1

abstract class BaseViewModel<S>(initialState: S) : ViewModel() {

    private val _stateLiveData = MutableLiveData(initialState)
    val stateLiveData: LiveData<S>
        get() = _stateLiveData

    fun setState(block: S.() -> S) {
        _stateLiveData.value = _stateLiveData.value?.block()
    }

    protected open fun <T : Any?> (suspend () -> T).execute(
        dispatcher: CoroutineDispatcher? = null,
        reducer: S.(Resource<T>) -> S,
    ): Job {
        setState { reducer(Resource.Loading) }

        return viewModelScope.launch(dispatcher ?: EmptyCoroutineContext) {
            try {
                val result = invoke()
                setState { reducer(Resource.Success(result)) }
            } catch (error: Exception) {
                setState { reducer(Resource.Error(error)) }
            }
        }
    }

    protected open fun <T : Any?> (suspend () -> T).execute(
        onSuccess: (suspend (T) -> Unit)? = null,
        onFailure: (suspend (Throwable) -> Unit)? = null,
        dispatcher: CoroutineDispatcher? = null
    ): Job {
        assert(onSuccess != null || onFailure != null) { "onSuccess and onFail both cannot be null" }
        return viewModelScope.launch(dispatcher ?: EmptyCoroutineContext) {
            try {
                val result = invoke()
                onSuccess?.invoke(result)
            } catch (error: Throwable) {
                onFailure?.invoke(error)
            }
        }
    }

    protected open fun <T> Flow<T>.execute(
        dispatcher: CoroutineDispatcher? = null,
        reducer: S.(Resource<T>) -> S,
    ): Job {
        setState { reducer(Resource.Loading) }

        return catch { error ->
            setState { reducer(Resource.Error(Exception(error))) }
        }
            .onEach { value -> setState { reducer(Resource.Success(value)) } }
            .launchIn(viewModelScope + (dispatcher ?: EmptyCoroutineContext))
    }
}