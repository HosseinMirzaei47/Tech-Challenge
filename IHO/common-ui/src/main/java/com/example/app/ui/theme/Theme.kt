package com.example.app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.intl.Locale

private val LightThemeColors = lightColors(
    primary = LightColors.PrimaryIndigo50,
    primaryVariant = LightColors.PrimaryIndigo50,
    onPrimary = Color.Black,
    secondary = LightColors.Secondary50,
    onSecondary = LightColors.Background,
    background = LightColors.Background
)

private val DarkThemeColors = darkColors(
    primary = DarkColors.PrimaryIndigo50,
    primaryVariant = DarkColors.PrimaryIndigo50,
    onPrimary = Color.Black,
    secondary = DarkColors.Secondary50,
    onSecondary = DarkColors.Background,
    background = DarkColors.Background
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colors = if (darkTheme) DarkThemeColors else LightThemeColors,
        typography = if (Locale.current == Locale("fa")) PersianTypography else EnglishTypography,
        shapes = Shapes,
        content = content
    )
}