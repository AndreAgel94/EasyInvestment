package com.example.easyinvest.data.api

import com.example.easyinvest.data.response.InvestmentBodyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

 //   https://api-simulator-calc.easynvest.com.br/calculator/simulate?
    // investedAmount=32323.0
    // &index=CDI
    // &rate=123
    // &isTaxFree=false
    // &maturityDate=2023-03-03

    @GET("simulate")
    fun getInvestment(
        @Query("investedAmount") investedAmount : Double,
        @Query("index") index : String,
        @Query("rate") rate : Int,
        @Query("isTaxFree") isTaxFree : Boolean,
        @Query("maturityDate") maturityDate : String
    ) : Call<InvestmentBodyResponse>
}