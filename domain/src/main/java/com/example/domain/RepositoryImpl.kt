package com.example.domain

import com.example.data.Coins
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private  var coinApi : CoinServce) : CoinRepository{
    override suspend fun getCoins(): Response<Coins> {
        return  coinApi.getCoins()
    }

}