package com.example.app

import android.media.MediaPlayer
import com.example.app.ui.extenstions.isNotNull
import com.example.app.ui.extenstions.isNull

/*
Singleton design pattern in Kotlin
* */
class AppMediaPlayer private constructor() {
    var mediaPlayer: MediaPlayer? = null

    private object Holder {
        val INSTANCE = AppMediaPlayer()
    }

    fun startPlayer(url: String) {
        if (mediaPlayer.isNull()) mediaPlayer = MediaPlayer()
        mediaPlayer?.setDataSource(url)
        mediaPlayer?.prepare()
        mediaPlayer?.start()
    }

    fun stopPlayer() {
        if (mediaPlayer.isNotNull()) {
            mediaPlayer?.release()
            mediaPlayer = null
        }
    }

    companion object {
        val INSTANCE: AppMediaPlayer by lazy { Holder.INSTANCE }
    }
}