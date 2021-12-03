package com.example.app.android.constants

import androidx.datastore.preferences.core.intPreferencesKey

object DataStoreConstants {
    val THEME_KEY = intPreferencesKey("THEME")
    val LANGUAGE_KEY = intPreferencesKey("LANGUAGE")
    val THEME_DATA_STORE_NAME = "THEME_DATA_STORE"
    val LANGUAGE_DATA_STORE_NAME = "LANGUAGE_DATA_STORE"
}