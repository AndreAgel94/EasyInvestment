package com.example.easyinvest.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.easyinvest.data.api.ApiService
import com.example.easyinvest.data.model.InvestDetails

class InvestmentRepository {

     val investment = MutableLiveData<InvestDetails>()
     val _investment : LiveData<InvestDetails> = investment

    fun buscaInvestment(): LiveData<InvestDetails> {



        return _investment
    }
}