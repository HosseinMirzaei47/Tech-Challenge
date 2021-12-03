package com.example.app.home

import android.media.MediaPlayer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class MediaPlayerModule {

    @Provides
    @Singleton
    fun provideMediaPlayer() = MediaPlayer()

}