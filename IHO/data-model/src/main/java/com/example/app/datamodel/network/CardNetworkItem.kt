package com.example.app.datamodel.network

import kotlinx.serialization.Serializable

@Serializable
data class CardNetworkItem(
    val code: Int,
    val description: String,
    val image: String? = null,
    val sound: String? = null,
    val tag: String,
    val title: String
)