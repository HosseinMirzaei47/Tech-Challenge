package com.example.app.ui.extenstions

import SnackbarManager
import androidx.compose.material.ScaffoldState
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.launch

@Composable
fun SnackbarManager.ObserveErrors(scaffoldState: ScaffoldState) {
    val errorMessages by errors.collectAsState(initial = null)
    errorMessages?.let { error ->
        val context = LocalContext.current
        val coroutineScope = rememberCoroutineScope()

        SideEffect {
            coroutineScope.launch {
                val snackbarResult = scaffoldState.snackbarHostState.showSnackbar(
                    message = error.message ?: context.getString(error.messageId!!),
                    actionLabel = error.actionId?.let { context.getString(it) },
                    duration = SnackbarDuration.values()[error.duration]
                )
                if (snackbarResult == SnackbarResult.ActionPerformed) {
                    removeCurrentError()
                    error.actionCallback?.invoke()
                }
            }
        }
    }
}