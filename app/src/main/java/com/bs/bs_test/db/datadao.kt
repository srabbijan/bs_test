package com.bs.bs_test.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.bs.bs_test.model.Item
import retrofit2.Call

@Dao
interface datadao {
//    @Insert
//    suspend fun addData(data: Call<List<Item>>)
//    @Query("SELECT * FROM datatable")
//    suspend fun getData():List<Call<List<Item>>>
}