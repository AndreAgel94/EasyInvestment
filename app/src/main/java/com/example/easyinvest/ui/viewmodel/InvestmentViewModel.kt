package com.example.easyinvest.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.easyinvest.data.model.InvestDetails
import com.example.easyinvest.data.repository.InvestmentRepository

class InvestmentViewModel (
    private val repository: InvestmentRepository
) : ViewModel(){

    fun buscaIvestment() : LiveData<InvestDetails>{
        return repository.buscaInvestment()
    }
}