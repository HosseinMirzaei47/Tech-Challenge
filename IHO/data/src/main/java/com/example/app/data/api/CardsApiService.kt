package com.example.app.data.api

import com.example.app.datamodel.network.CardNetwork
import retrofit2.Response
import retrofit2.http.GET

interface CardsApiService {
    @GET("AmirrezaRotamian/Tech-Challenge/master/tempelate.json")
    suspend fun getCards(): Response<CardNetwork>
}