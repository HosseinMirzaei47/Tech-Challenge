package com.example.app.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.app.ui.R

private val PersianFontFamily = FontFamily(
    Font(R.font.persian_font_sans_black, FontWeight.Black),
    Font(R.font.persian_font_sans_bold, FontWeight.Bold),
    Font(R.font.persian_font_sans_extra_bold, FontWeight.ExtraBold),
    Font(R.font.persian_font_sans_extra_light, FontWeight.ExtraLight),
    Font(R.font.persian_font_sans_light, FontWeight.Light),
    Font(R.font.persian_font_sans_medium, FontWeight.Medium),
    Font(R.font.persian_font_sans_regular, FontWeight.Normal),
    Font(R.font.persian_font_sans_semi_bold, FontWeight.SemiBold),
    Font(R.font.persian_font_sans_thin, FontWeight.Thin),
)

private val EnglishFontFamily = FontFamily(
    Font(R.font.english_font_black, FontWeight.Black),
    Font(R.font.english_font_bold, FontWeight.Bold),
    Font(R.font.english_font_bold_italic, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.english_font_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.english_font_extra_bold, FontWeight.ExtraBold),
    Font(R.font.english_font_extra_light, FontWeight.ExtraLight),
    Font(R.font.english_font_light, FontWeight.Light),
    Font(R.font.english_font_regular, FontWeight.Normal),
    Font(R.font.english_font_semi_bold, FontWeight.SemiBold),
)

val PersianTypography = Typography(
    defaultFontFamily = PersianFontFamily,
    h1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp,
    ),
    h2 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
    ),
    h3 = TextStyle(
        fontWeight = FontWeight.Light,
        fontSize = 20.sp,
    ),
    h4 = TextStyle(
        fontWeight = FontWeight.ExtraLight,
        fontSize = 18.sp,
    ),
    h5 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
    ),
    h6 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
    ),
    subtitle1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
    ),
    body1 = TextStyle(
        fontWeight = FontWeight.Light,
        fontSize = 16.sp,
    ),
    caption = TextStyle(
        fontWeight = FontWeight.Light,
        fontSize = 12.sp,
    ),
)

val EnglishTypography = Typography(
    defaultFontFamily = EnglishFontFamily,
    h1 = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 36.sp,
    ),
    h2 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
    ),
    h3 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
    ),
    h4 = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
    ),
    h5 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
    ),
    h6 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
    ),
    subtitle1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
    ),
    body1 = TextStyle(
        fontWeight = FontWeight.Light,
        fontSize = 16.sp,
    ),
    caption = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
    ),
)

inline val Typography.bodyTwo: TextStyle
    get() = body1.copy(fontWeight = FontWeight.Normal, fontSize = 14.sp)

inline val Typography.captionTwo: TextStyle
    get() = caption.copy(fontWeight = FontWeight.Normal, fontSize = 12.sp)

inline val Typography.buttonOne: TextStyle
    get() = body2.copy(fontWeight = FontWeight.Bold, fontSize = 16.sp)

inline val Typography.buttonTwo: TextStyle
    get() = buttonOne.copy(fontWeight = FontWeight.SemiBold, fontSize = 14.sp)

inline val Typography.persian: TextStyle
    get() = body1.copy(fontWeight = FontWeight.Light, fontSize = 14.sp)