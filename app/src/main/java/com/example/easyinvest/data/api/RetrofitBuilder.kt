package com.example.easyinvest.data.api

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitBuilder{
    private fun initRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://api-simulator-calc.easynvest.com.br/calculator/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    val service : ApiService = initRetrofit().create(ApiService::class.java)
}