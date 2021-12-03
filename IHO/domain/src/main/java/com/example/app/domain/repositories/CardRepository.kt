package com.example.app.domain.repositories

import com.example.app.model.models.Card
import kotlinx.coroutines.flow.Flow

interface CardRepository {
    suspend fun getCards(): List<Card>
}