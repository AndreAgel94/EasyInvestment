package com.example.easyinvest.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.easyinvest.data.api.ApiService
import com.example.easyinvest.data.api.RetrofitBuilder
import com.example.easyinvest.data.model.InvestDetails
import com.example.easyinvest.data.response.InvestmentBodyResponse
import retrofit2.Call
import retrofit2.Response
import java.util.*
import javax.security.auth.callback.Callback

class InvestmentRepository {

     val investmentLiveData : MutableLiveData<InvestDetails?> = MutableLiveData()

    fun buscaInvestment(): LiveData<InvestDetails?> {
        RetrofitBuilder.service.getInvestment().enqueue(object : retrofit2.Callback<InvestmentBodyResponse>{
            override fun onResponse(
                call: Call<InvestmentBodyResponse>,
                response: Response<InvestmentBodyResponse>
            ) {
                var investment : InvestDetails
                if(response.isSuccessful){
                    response.body()?.let {
                    investmentLiveData.value = InvestDetails(
                            it.valorLiquidoLucro, it.investmentParameter.valorAplicado , it.valorBrutoInvestido , it.valorLiquidoLucro ,
                            it.valorLiquidoInvestimento , it.irSobreInvestimento , it.investmentParameter.dataResgate ,
                            it.investmentParameter.diasCorridos , it.rendimentoMensal , it.investmentParameter.percentualCDI,
                            it.rentabilidadeAnual, it.rentabilidadeNoPeriodo
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
}