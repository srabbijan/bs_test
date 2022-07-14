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

class SingleOwnerRepository(
    private val api: API,
//    private val localDatabase: LocalDatabase,
    private val applicationContext: Context) {
    private val SingleOwnerDataModel = MutableLiveData<SingleOwner>()
    val SingleOwnerliveData: LiveData<SingleOwner>
        get() = SingleOwnerDataModel

    suspend fun getSingleOwnerData(q: String) {
        if (networkUtils.isInternetAvailable(applicationContext)) {
            val result = api.getOwnerInfo(q)
            if (result != null) {
//                localDatabase.datadao().addData(result)
                SingleOwnerDataModel.postValue(result)
            }
        } else {
//            val quotes = localDatabase.datadao().getData()
//            val quoteList = DataModels(quotes)
//            liveDataModel.postValue(quotes)
            Log.d("local","localDatabase")
        }
    }
}