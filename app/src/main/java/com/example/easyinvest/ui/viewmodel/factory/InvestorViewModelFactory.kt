package com.example.easyinvest.ui.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.easyinvest.data.repository.InvestmentRepository
import com.example.easyinvest.ui.viewmodel.InvestorViewModel

class InvestorViewModelFactory (
    private val repository: InvestmentRepository
): ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return InvestorViewModel(repository) as T
    }
}