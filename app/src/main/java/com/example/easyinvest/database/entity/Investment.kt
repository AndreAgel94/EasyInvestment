package com.example.easyinvest.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Investment (

    @PrimaryKey(autoGenerate = true)
    val id : Int,

    @ColumnInfo(name ="lucro_liquido")
    val valorLiquidoLucro : Double,

    @ColumnInfo(name ="valor_investido")
    val valorInvestido : Double,

    @ColumnInfo(name ="valor_bruto_investimento")
    val valorBrutoInvestimento : Double,

    @ColumnInfo(name ="valor_rendimento")
    val valorDoRendimento : Double,

    @ColumnInfo(name ="valor_liquido_investimento")
    val valorLiquidoInvestimento: Double,

    @ColumnInfo(name ="ir_sobre_investimento")
    val irSobreInvestimento : Double,

    @ColumnInfo(name ="data_resgate")
    val dataResgate: String,

    @ColumnInfo(name ="dias_corridos")
    val diasCorridos : Int,

    @ColumnInfo(name ="rendimento_mensal")
    val rendimendoMensal: Double,

    @ColumnInfo(name ="percentual_cdi")
    val percentualCDI : Int,

    @ColumnInfo(name ="rentabilidade_anual")
    val rentabilidadeAnual: Double,

    @ColumnInfo(name ="rentabilidade_periodo")
    val rentabilidadeNoPeriodo : Double,
)