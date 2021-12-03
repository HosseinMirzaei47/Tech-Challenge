package com.example.app.model.models

import com.example.app.model.models.CardCode.PICTURE
import com.example.app.model.models.CardCode.SOUND
import com.example.app.model.models.CardCode.VIBRATOR

sealed class Card(
    open val id: Long,
    open val code: Long,
    open val title: String,
    open val description: String,
    open val tag: String
) {

    data class PictureCard(
        override val id: Long,
        override val code: Long = PICTURE,
        override val title: String,
        override val description: String,
        override val tag: String,
        val image: String
    ) : Card(id, code, title, description, tag)

    data class VibratorCard(
        override val id: Long,
        override val code: Long = VIBRATOR,
        override val title: String,
        override val description: String,
        override val tag: String
    ) : Card(id, code, title, description, tag)

    data class SoundCard(
        override val id: Long,
        override val code: Long = SOUND,
        override val title: String,
        override val description: String,
        override val tag: String,
        val sound: String
    ) : Card(id, code, title, description, tag)

}