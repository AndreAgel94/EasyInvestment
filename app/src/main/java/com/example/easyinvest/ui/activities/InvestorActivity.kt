package com.example.easyinvest.ui.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.easyinvest.R
import kotlinx.android.synthetic.main.activity_investor.*

class InvestorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_investor)

        buttonSimular.setOnClickListener(View.OnClickListener {
            val intent = InvestimentActivity.getStartIntent(this, editTextValorAplicado.text.toString().toDouble(),
                editTextCDI.text.toString().toInt(), editTextData.text.toString())
                this.startActivity(intent)
        })
    }

    companion object {
        fun getStartIntent(context: Context): Intent {
            return Intent(context, InvestorActivity::class.java)
        }
    }

}