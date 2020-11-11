package com.example.easyinvest.ui.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.easyinvest.R
import com.example.easyinvest.data.repository.InvestmentRepository
import com.example.easyinvest.ui.viewmodel.InvestmentViewModel
import com.example.easyinvest.ui.viewmodel.InvestorViewModel
import com.example.easyinvest.ui.viewmodel.factory.InvestmentViewModelFactory
import com.example.easyinvest.ui.viewmodel.factory.InvestorViewModelFactory
import kotlinx.android.synthetic.main.activity_investor.*

class InvestorActivity : AppCompatActivity() {

    private val viewModel by lazy{
        val repository = InvestmentRepository()
        val factory = InvestorViewModelFactory(repository)
        ViewModelProviders.of(this,factory).get(InvestorViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_investor)

        buttonSimular.setOnClickListener(View.OnClickListener {
            val intent = InvestimentActivity.getStartIntent(this, editTextValorAplicado.text.toString().toDouble(),
                editTextCDI.text.toString().toInt(), editTextData.text.toString())
                this.startActivity(intent)
        })
    }

    private fun fetchInvestment(valorAplicado: Double, dataEncerramento: String, cdi: Int) {
        viewModel.buscaInvestmentAPI(valorAplicado,dataEncerramento,cdi).observe(this, Observer {
            Log.d("confere" , it.toString())
        })
    }


    companion object {
        fun getStartIntent(context: Context): Intent {
            return Intent(context, InvestorActivity::class.java)
        }
    }

}