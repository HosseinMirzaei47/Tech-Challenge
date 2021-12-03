package com.example.app.data.repositories.task

import com.example.app.data.datesources.cards.CardsRemoteDataSource
import com.example.app.data.mappers.toCards
import com.example.app.domain.repositories.CardRepository
import com.example.app.model.models.Card
import javax.inject.Inject

class CardRepositoryImpl @Inject constructor(
    private val cardsRemoteDataSource: CardsRemoteDataSource,
) : CardRepository {

    override suspend fun getCards(): List<Card> = cardsRemoteDataSource.getCards().toCards()

}