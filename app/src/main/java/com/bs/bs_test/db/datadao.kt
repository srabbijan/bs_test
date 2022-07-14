package com.bs.bs_test.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.bs.bs_test.model.DataModels
import com.bs.bs_test.model.Item
import com.bs.bs_test.model.SingleOwner
import retrofit2.Call

@Dao
interface datadao {
    @Insert
    suspend fun addData(data: SingleOwner)
    @Query("SELECT * FROM singleowner WHERE login==:usr")
    suspend fun getData(usr: String): SingleOwner
}