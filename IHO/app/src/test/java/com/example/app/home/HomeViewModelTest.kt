package com.example.app.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.app.androidtest.rules.CoroutineRule
import com.example.app.domain.usecases.cards.GetCardsUseCase
import com.example.app.model.models.Card
import com.example.app.shared.resource.Resource
import com.google.common.truth.Truth.assertThat
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeViewModelTest {

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    @Rule
    @JvmField
    @ExperimentalCoroutinesApi
    val coroutineRule = CoroutineRule()

    @RelaxedMockK
    lateinit var getCardsUseCase: GetCardsUseCase

    private val fakeCards = listOf(
        Card.VibratorCard(
            id = 0L,
            code = 0,
            title = "",
            description = "",
            tag = "",
        ),
        Card.VibratorCard(
            id = 1L,
            code = 0,
            title = "",
            description = "",
            tag = "",
        ),
        Card.VibratorCard(
            id = 2L,
            code = 0,
            title = "",
            description = "",
            tag = "",
        ),
    )

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    @ExperimentalCoroutinesApi
    fun onInitialization_loadAllCards() {
        coEvery { getCardsUseCase(Unit) } returns Resource.Success(fakeCards)

        val viewModel = createHomeViewModel()

        assertThat(viewModel.allCards.value).isNotEmpty()
        assertThat(viewModel.card.value).isEqualTo(fakeCards.first())
    }

    @Test
    @ExperimentalCoroutinesApi
    fun doesNotEmitRepetitiveCard() {
        coEvery { getCardsUseCase(Unit) } returns Resource.Success(fakeCards)

        val viewModel = createHomeViewModel()

        viewModel.onNextClicked(fakeCards.first().id)

        assertThat(viewModel.card).isNotEqualTo(fakeCards.first())
    }

    @Test
    @ExperimentalCoroutinesApi
    fun showAllCards_clearShownCardList() {
        coEvery { getCardsUseCase(Unit) } returns Resource.Success(fakeCards)

        val viewModel = createHomeViewModel()

        viewModel.onNextClicked(fakeCards[0].id)
        viewModel.onNextClicked(fakeCards[1].id)
        viewModel.onNextClicked(fakeCards[2].id)

        assertThat(viewModel.shownCards.value).isEmpty()
    }

    private fun createHomeViewModel() = HomeViewModel(getCardsUseCase)

}