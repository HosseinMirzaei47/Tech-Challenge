package com.example.app.data.datesources.cards

import com.example.app.datamodel.network.CardNetworkItem

interface CardsRemoteDataSource {
    suspend fun getCards(): List<CardNetworkItem>
}