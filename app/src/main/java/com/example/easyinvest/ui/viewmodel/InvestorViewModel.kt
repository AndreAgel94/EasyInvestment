package com.example.easyinvest.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.easyinvest.data.model.InvestDetails
import com.example.easyinvest.data.repository.InvestmentRepository
import kotlinx.coroutines.runBlocking

class InvestorViewModel(
    private val repository: InvestmentRepository
) : ViewModel() {
    fun buscaInvestmentAPI(
        investedAmount : Double,
        maturityDate : String,
        rate: Int
    ) : LiveData<InvestDetails> = runBlocking { repository.buscaInvestmentCoroutines(investedAmount,maturityDate,rate) }
}