package com.example.app.domain.baseusecases

import com.example.app.shared.resource.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn

/**
 * Executes business logic in its execute method and keep posting updates to the Resource as
 * [Resource<R>].
 * Handling an exception (emit [Resource.Error] to the Resource) is the subclasses's responsibility.
 */
abstract class FlowUseCase<in P, R>(private val coroutineDispatcher: CoroutineDispatcher) {

    protected abstract fun execute(parameter: P): Flow<Resource<R>>
    operator fun invoke(parameter: P): Flow<Resource<R>> = execute(parameter)
        .catch { e ->
            e.printStackTrace()
            emit(Resource.Error(e as Exception))
        }
        .flowOn(coroutineDispatcher)
}