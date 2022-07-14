package com.bs.bs_test.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bs.bs_test.api.API
//import com.bs.bs_test.db.LocalDatabase
import com.bs.bs_test.model.DataModels
import com.bs.bs_test.model.SingleOwner
import com.bs.bs_test.utils.networkUtils

class DataRepository(
    private val api: API,
//    private val localDatabase: LocalDatabase,
    private val applicationContext: Context) {
    private val liveDataModel = MutableLiveData<DataModels>()
    val liveData: LiveData<DataModels>
        get() = liveDataModel
    suspend fun getData(q: String, sort: String) {
        if (networkUtils.isInternetAvailable(applicationContext)) {
            val result = api.getApiCall(q, sort)
            if (result != null) {
//                localDatabase.datadao().addData(result)
                liveDataModel.postValue(result)
            }
        } else {
//            val quotes = localDatabase.datadao().getData()
//            val quoteList = DataModels(quotes)
//            liveDataModel.postValue(quotes)
            Log.d("local","localDatabase")
        }
    }
}