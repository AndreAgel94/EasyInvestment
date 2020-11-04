package com.example.easyinvest.ui.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.easyinvest.R
import com.example.easyinvest.data.model.InvestDetails
import com.example.easyinvest.data.repository.InvestmentRepository
import com.example.easyinvest.ui.viewmodel.InvestmentViewModel
import com.example.easyinvest.ui.viewmodel.factory.InvestmentViewModelFactory
import java.util.*

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

        val valorAplicado = intent.getStringExtra(EXTRA_VALOR_APLICADO)
        val cdi = intent.getStringExtra(EXTRA_CDI)
        val dataEncerramento = intent.getStringExtra(EXTRA_DATA)
        fetchInvestment()
    }

    private fun fetchInvestment() {

//        val valorLiquidoLucro : Double,
//
//        val valorInvestido : Double,
//        val valorBrutoInvestimento : Double,
//        val valorDoRendimento : Double,
//        val valorLiquidoInvestimento: Double,
//        val irSobreInvestimento : Double,
//        val dataResgate: Date,
//        val diasCorridos : Int,
//        val rendimendoMensal: Double,
//        val percentualCDI : Int,
//        val rentabilidadeAnual: Double,
//        val rentabilidadeNoPeriodo : Double,

         viewModel.buscaIvestment().observe(this, Observer {
             Log.d("investimento",it.toString())
        })
    }
    companion object {
        private const val EXTRA_VALOR_APLICADO = "EXTRA_VALOR_APLICADO"
        private const val EXTRA_CDI = "EXTRA_CDI"
        private const val EXTRA_DATA = "EXTRA_DATA"

        fun getStartIntent(context: Context, valorAplicado: Double, cdi: Int, dataEncerramento: String): Intent {
            return Intent(context, InvestimentActivity::class.java).apply {
                putExtra(EXTRA_VALOR_APLICADO, valorAplicado)
                putExtra(EXTRA_CDI, cdi)
                putExtra(EXTRA_DATA, dataEncerramento)
            }
        }
    }
}