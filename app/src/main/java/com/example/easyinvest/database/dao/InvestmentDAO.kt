package com.example.easyinvest.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.easyinvest.database.entity.Investment

@Dao
interface InvestmentDAO {

    @Query("SELECT * FROM investment")
    fun getAll() : List<Investment>

    @Insert
    fun salva(investment: Investment)

    @Delete
    fun delete(investment: Investment)
}