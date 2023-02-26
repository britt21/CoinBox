package com.example.domain

import com.example.data.Coins
import retrofit2.Response

interface  CoinRepository {

    suspend fun getCoins(): Response<Coins>
}