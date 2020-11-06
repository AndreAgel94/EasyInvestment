package com.example.easyinvest.data.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

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
@Parcelize
data class InvestmentBodyResponse (
    val investmentParameter : InvestimentParameterResponse,

    val netAmountProfit : Double,

    val grossAmount : Double,

    val taxesAmount : Double,

    val netAmount : Double,

    val monthlyGrossRateProfit : Double,

    val annualNetRateProfit : Double,

    val annualGrossRateProfit : Double,
) : Parcelable