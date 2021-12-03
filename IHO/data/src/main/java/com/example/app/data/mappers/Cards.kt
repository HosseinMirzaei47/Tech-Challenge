package com.example.app.data.mappers

import com.example.app.datamodel.network.CardNetworkItem
import com.example.app.model.models.Card
import com.example.app.model.models.CardCode.PICTURE
import com.example.app.model.models.CardCode.VIBRATOR

fun List<CardNetworkItem>.toCards() = mapIndexed { id, item ->
    when (item.code.toLong()) {
        PICTURE -> item.toPictureCard(id.toLong())
        VIBRATOR -> item.toVibratorCard(id.toLong())
        else -> item.toSoundCard(id.toLong())
    }
}

fun CardNetworkItem.toVibratorCard(id: Long) = Card.VibratorCard(
    id = id,
    code = code.toLong(),
    title = title,
    description = description,
    tag = tag,
)

fun CardNetworkItem.toPictureCard(id: Long) = Card.PictureCard(
    id = id,
    code = code.toLong(),
    title = title,
    description = description,
    image = image!!,
    tag = tag,
)

fun CardNetworkItem.toSoundCard(id: Long) = Card.SoundCard(
    id = id,
    code = code.toLong(),
    title = title,
    description = description,
    sound = sound!!,
    tag = tag,
)