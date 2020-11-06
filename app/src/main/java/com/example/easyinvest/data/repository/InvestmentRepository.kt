package com.example.easyinvest.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.easyinvest.data.api.RetrofitBuilder
import com.example.easyinvest.data.model.InvestDetails
import com.example.easyinvest.data.response.InvestmentBodyResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Response

class InvestmentRepository {

     val investmentLiveData : MutableLiveData<InvestDetails> = MutableLiveData()

    fun buscaInvestment(
            investedAmount : Double,
            maturityDate : String,
            rate: Int,
    ): LiveData<InvestDetails> {
        RetrofitBuilder.service.getInvestment(
                investedAmount,
                "CDI",
                rate,
                false
                ,maturityDate)
                .enqueue(object : retrofit2.Callback<InvestmentBodyResponse>{
            override fun onResponse(
                call: Call<InvestmentBodyResponse>,
                response: Response<InvestmentBodyResponse>
            ) {
                var investment : InvestDetails
                if(response.isSuccessful){
                    response.body()?.let {
                    investmentLiveData.value = InvestDetails(
                            it.netAmountProfit, it.investmentParameter.investedAmount , it.grossAmount , it.netAmountProfit ,
                            it.netAmount , it.taxesAmount , it.investmentParameter.maturityDate ,
                            it.investmentParameter.maturityTotalDays , it.monthlyGrossRateProfit , it.investmentParameter.rate,
                            it.annualNetRateProfit, it.annualGrossRateProfit
                        )

                    }
                }
            }

            override fun onFailure(call: Call<InvestmentBodyResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

        return investmentLiveData
    }


   suspend fun buscaInvestmentCoroutines(
            investedAmount : Double,
            maturityDate : String,
            rate: Int,
    ): LiveData<InvestDetails> {
       withContext(Dispatchers.Default){
           RetrofitBuilder.service.getInvestment(
                   investedAmount,
                   "CDI",
                   rate,
                   false
                   ,maturityDate)
                   .enqueue(object : retrofit2.Callback<InvestmentBodyResponse>{
                       override fun onResponse(
                               call: Call<InvestmentBodyResponse>,
                               response: Response<InvestmentBodyResponse>
                       ) {
                           var investment : InvestDetails
                           if(response.isSuccessful){
                               response.body()?.let {
                                   investmentLiveData.value = InvestDetails(
                                           it.netAmountProfit, it.investmentParameter.investedAmount , it.grossAmount , it.netAmountProfit ,
                                           it.netAmount , it.taxesAmount , it.investmentParameter.maturityDate ,
                                           it.investmentParameter.maturityTotalDays , it.monthlyGrossRateProfit , it.investmentParameter.rate,
                                           it.annualNetRateProfit, it.annualGrossRateProfit
                                   )

                               }
                           }
                       }

                       override fun onFailure(call: Call<InvestmentBodyResponse>, t: Throwable) {
                           TODO("Not yet implemented")
                       }

                   })
       }
        return investmentLiveData
    }
}