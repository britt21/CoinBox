package com.example.domain

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideService(retrofit: Retrofit): CoinServce{
        return  retrofit.create(CoinServce::class.java)
    }

    @Singleton
    @Provides
    fun provideRepository(coinRepository: CoinServce): CoinRepository{
        return  RepositoryImpl(coinRepository)
    }


    @Singleton
    @Provides
    fun provideRetrofit(
    ) : Retrofit{
        return  Retrofit.Builder()
            .baseUrl("https://api.coinpaprika.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }



}