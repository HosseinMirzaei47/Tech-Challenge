package com.example.app.datamodel.network

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

@Serializable
data class CardNetwork(
    @JsonNames("cards")
    val cardNetworkItems: List<CardNetworkItem>
)