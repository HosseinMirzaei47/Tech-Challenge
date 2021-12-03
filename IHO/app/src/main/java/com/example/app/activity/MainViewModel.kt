package com.example.app.activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    savedState: SavedStateHandle,
) : ViewModel() {

    private var _currentScreenRoute = MutableLiveData<String?>()
    val currentScreenRoute: LiveData<String?> get() = _currentScreenRoute

    fun updateCurrentNavRoute(route: String?) {
        _currentScreenRoute.value = route
    }
}