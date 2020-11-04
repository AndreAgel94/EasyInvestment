package com.example.easyinvest.data.api

import com.example.easyinvest.data.response.InvestmentBodyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface ApiService {

 //   https://api-simulator-calc.easynvest.com.br/calculator/simulate?
    // investedAmount=32323.0
    // &index=CDI
    // &rate=123
    // &isTaxFree=false
    // &maturityDate=2023-03-03

    @GET("simulate")
    fun getInvestment(
        @Query("investedAmount") investedAmount : Double = 1000.0,
        @Query("index") index : String = "CDI",
        @Query("rate") rate : Int = 123,
        @Query("isTaxFree") isTaxFree : Boolean = false,
        @Query("maturityDate") maturityDate : String = "2023-03-03"
    ) : Call<InvestmentBodyResponse>
}