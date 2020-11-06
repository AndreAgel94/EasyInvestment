package com.example.easyinvest.ui.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.easyinvest.R
import com.example.easyinvest.data.model.InvestDetails
import com.example.easyinvest.data.repository.InvestmentRepository
import com.example.easyinvest.ui.viewmodel.InvestmentViewModel
import com.example.easyinvest.ui.viewmodel.factory.InvestmentViewModelFactory
import kotlinx.android.synthetic.main.activity_investor.*
import kotlinx.android.synthetic.main.activity_main.*

class InvestimentActivity : AppCompatActivity() {

    private val viewModel by lazy{
        val repository = InvestmentRepository()
        val factory = InvestmentViewModelFactory(repository)
        ViewModelProviders.of(this,factory).get(InvestmentViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val valorAplicado = intent.getDoubleExtra(EXTRA_VALOR_APLICADO,0.0)
        val cdi = intent.getIntExtra(EXTRA_CDI,0)
        val dataEncerramento = intent.getStringExtra(EXTRA_DATA)

        buttonSimularNovamente.setOnClickListener {
            val intent = InvestorActivity.getStartIntent(this)
            this.startActivity(intent)
        }
        fetchInvestmentCoroutines(valorAplicado,dataEncerramento,cdi)
    }


    private fun fetchInvestmentCoroutines(valorAplicado: Double, dataEncerramento: String, cdi: Int) {

        viewModel.buscaInvestmentCoroutines3(valorAplicado,dataEncerramento,cdi)
                .observe(this, Observer {
                    fetchView(it)
                })

    }

    private fun fetchView(investment : InvestDetails) {
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
        textFinalResult.text = investment.valorLiquidoInvestimento.toString()
        textLucroLiquido.text = investment.valorLiquidoLucro.toString()
        textValorAplicadoResultado.text = investment.valorInvestido.toString()
        textValorBrutoResultado.text = investment.valorBrutoInvestimento.toString()
        textValorRendimentoResultado.text = investment.valorDoRendimento.toString()
        textIRresultado.text = investment.irSobreInvestimento.toString()
        textValorLiquidoResultado.text = investment.valorLiquidoInvestimento.toString()

        textDataDeResgateResultado.text = investment.dataResgate
        textDiasCorridosResultado.text = investment.diasCorridos.toString()
        textRendimentoMensalResultado.text = investment.rendimendoMensal.toString()
        textCDIResultado.text = investment.percentualCDI.toString()
        textRentabilidadeAnualResultado.text = investment.rentabilidadeAnual.toString()
        textRentabilidadePeriodoResultado.text = investment.rentabilidadeNoPeriodo.toString()

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