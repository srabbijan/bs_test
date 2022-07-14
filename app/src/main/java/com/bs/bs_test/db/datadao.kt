package com.bs.bs_test.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.bs.bs_test.model.DataModels
import com.bs.bs_test.model.Item
import retrofit2.Call

//@Dao
//interface datadao {
//    @Insert
//    suspend fun addData(data: DataModels)

//    @Query("SELECT * FROM homepage")
//    suspend fun getData(): Item
//}