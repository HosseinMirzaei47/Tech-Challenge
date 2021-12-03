package com.example.app.data.di.cards

import com.example.app.data.api.CardsApiService
import com.example.app.data.datesources.cards.CardsRemoteDataSource
import com.example.app.data.datesources.cards.CardsRemoteDataSourceImpl
import com.example.app.data.repositories.task.CardRepositoryImpl
import com.example.app.domain.repositories.CardRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
abstract class CardsModule {

    @Binds
    abstract fun bindsCardsDataSource(impl: CardsRemoteDataSourceImpl): CardsRemoteDataSource

    @Binds
    abstract fun bindCardsRepository(impl: CardRepositoryImpl): CardRepository

    companion object {
        @Provides
        fun provideCardsApiService(retrofit: Retrofit): CardsApiService {
            return retrofit.create(CardsApiService::class.java)
        }
    }
}