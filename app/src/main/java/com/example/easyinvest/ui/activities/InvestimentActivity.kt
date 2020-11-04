package com.example.easyinvest.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.easyinvest.R
import com.example.easyinvest.data.model.InvestDetails
import com.example.easyinvest.data.repository.InvestmentRepository
import com.example.easyinvest.ui.viewmodel.InvestmentViewModel
import com.example.easyinvest.ui.viewmodel.factory.InvestmentViewModelFactory

class InvestimentActivity : AppCompatActivity() {

    private val viewModel by lazy{
        val repository = InvestmentRepository()
        val factory = InvestmentViewModelFactory(repository)
        ViewModelProviders.of(this,factory).get(InvestmentViewModel::class.java)
    }

    private lateinit var investment : InvestDetails

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}