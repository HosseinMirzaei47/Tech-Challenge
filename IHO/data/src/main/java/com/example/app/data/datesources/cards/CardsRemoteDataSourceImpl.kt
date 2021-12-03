package com.example.app.data.datesources.cards

import com.example.app.android.extentions.bodyOrThrow
import com.example.app.data.api.CardsApiService
import com.example.app.datamodel.network.CardNetworkItem
import javax.inject.Inject

class CardsRemoteDataSourceImpl @Inject constructor(
    private val cardsApiService: CardsApiService
) : CardsRemoteDataSource {
    override suspend fun getCards(): List<CardNetworkItem> =
        cardsApiService.getCards().bodyOrThrow().cardNetworkItems
}