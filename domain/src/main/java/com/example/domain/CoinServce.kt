package com.example.domain

import com.example.data.Coins
import retrofit2.Response
import retrofit2.http.GET

interface CoinServce {

    @GET("v1/coins")
    suspend fun getCoins() : Response<Coins>

}