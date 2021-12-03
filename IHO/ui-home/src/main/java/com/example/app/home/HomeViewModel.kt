package com.example.app.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.domain.usecases.cards.GetCardsUseCase
import com.example.app.model.models.Card
import com.example.app.shared.resource.onSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor(
    getCardsUseCase: GetCardsUseCase,
) : ViewModel() {

    private val _card: MutableState<Card?> = mutableStateOf(null)
    val card: State<Card?> get() = _card

    val allCards = MutableStateFlow(listOf<Card>())

    val shownCards = MutableStateFlow(mutableSetOf<Long>())

    init {
        viewModelScope.launch {
            getCardsUseCase(Unit).onSuccess {
                allCards.value = it
                onNextClicked(it.first().id)
            }
        }
    }

    fun onNextClicked(currentCardId: Long) {
        shownCards.value.add(currentCardId)
        val showedAllCards = shownCards.value.size >= allCards.value.size
        if (showedAllCards) shownCards.value.clear()

        val nextCard = allCards.value.shuffled().first { shownCards.value.contains(it.id).not() }
        _card.value = nextCard
    }

}