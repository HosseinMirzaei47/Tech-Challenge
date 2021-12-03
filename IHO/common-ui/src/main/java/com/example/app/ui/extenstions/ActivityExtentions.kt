package com.example.app.ui.extenstions

import android.app.Activity
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.content.pm.ShortcutInfo
import android.graphics.drawable.Icon
import android.os.Build
import androidx.annotation.DrawableRes
import androidx.annotation.RequiresApi
import androidx.annotation.StringRes
import androidx.core.net.toUri

@RequiresApi(Build.VERSION_CODES.N_MR1)
fun Activity.generateAppShortcutInfo(
    data: String,
    id: String,
    @StringRes shortLabel: Int,
    @StringRes longLabel: Int,
    @DrawableRes icon: Int,
): ShortcutInfo {
    val shortcutIntent = Intent(this, this.javaClass)
    shortcutIntent.flags += FLAG_ACTIVITY_CLEAR_TASK or FLAG_ACTIVITY_NEW_TASK
    shortcutIntent.action = Intent.ACTION_VIEW
    shortcutIntent.data = data.toUri()

    return ShortcutInfo.Builder(this, id)
        .setShortLabel(getString(shortLabel))
        .setLongLabel(getString(longLabel))
        .setIcon(Icon.createWithResource(this, icon))
        .setIntent(shortcutIntent)
        .build()
}