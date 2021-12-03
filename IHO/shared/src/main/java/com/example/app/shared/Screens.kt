package com.example.app.shared

sealed class Screens(val route: String) {
    object Home : Screens("home")
}
