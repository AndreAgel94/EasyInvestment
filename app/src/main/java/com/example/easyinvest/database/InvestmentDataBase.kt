package com.example.easyinvest.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.easyinvest.database.dao.InvestmentDAO
import com.example.easyinvest.database.entity.Investment

@Database(entities = arrayOf(Investment::class) , version = 1, exportSchema = false)
abstract class InvestmentDataBase : RoomDatabase() {

    fun getInstance(context: Context) : InvestmentDataBase{
        return Room
            .databaseBuilder(
                context,
                InvestmentDataBase::class.java,
                "investment.db")
            .build()

    }

    abstract fun getInvestmentDAO() : InvestmentDAO
}