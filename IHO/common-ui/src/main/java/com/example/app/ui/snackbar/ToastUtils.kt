package com.example.app.ui.snackbar

import android.content.Context
import android.graphics.Typeface
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.FontRes
import androidx.annotation.StringRes
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.example.app.ui.R

fun Context.toast(message: String, isLong: Boolean = false) {
    val duration: Int = if (isLong) Toast.LENGTH_LONG else Toast.LENGTH_SHORT
    val toast = Toast.makeText(this, message, duration)

    (toast.view as? LinearLayout)?.let { layout ->
        (layout.getChildAt(0) as? TextView?)?.let { tv ->
            tv.typeface = font(R.font.english_font_regular)
        }
    }

    toast.show()
}

fun Fragment.toast(message: String, isLong: Boolean = false) =
    requireView().toast(message, isLong)

fun Fragment.toast(@StringRes message: Int, isLong: Boolean = false) {
    requireView().toast(getString(message), isLong)
}

fun View.toast(message: String, isLong: Boolean = false) =
    context.toast(message, isLong)

fun Context.font(@FontRes resId: Int): Typeface? {
    return ResourcesCompat.getFont(this, resId)
}