package com.example.app.domain.usecases.cards

import com.example.app.domain.baseusecases.UseCase
import com.example.app.domain.coroutineUtils.IoDispatcher
import com.example.app.domain.repositories.CardRepository
import com.example.app.model.models.Card
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher

class GetCardsUseCase @Inject constructor(
    private val cardRepository: CardRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher,
) : UseCase<Unit, List<Card>>(ioDispatcher) {
    override suspend fun execute(parameters: Unit): List<Card> = cardRepository.getCards()
}