package com.example.easyinvest.data.model

import java.util.*

//"netAmountProfit": 329.93
//
//"investedAmount": 1000.0,
//"grossAmount": 1388.15,
//"rateProfit": 7.1302,
//"taxesAmount": 58.22,
//"netAmount": 1329.93
//
//"maturityDate": "2025-06-18T00:00:00",
//"maturityTotalDays": 1688,
//"monthlyGrossRateProfit": 0.58,
//"rate": 100.0
//"annualNetRateProfit": 32.99
//"annualGrossRateProfit": 38.82,


data class InvestDetails (
        val valorLiquidoLucro : Double,

        val valorInvestido : Double,
        val valorBrutoInvestimento : Double,
        val valorDoRendimento : Double,
        val valorLiquidoInvestimento: Double,
        val irSobreInvestimento : Double,
        val dataResgate: Date,
        val diasCorridos : Int,
        val rendimendoMensal: Double,
        val percentualCDI : Int,
        val rentabilidadeAnual: Double,
        val rentabilidadeNoPeriodo : Double,
)