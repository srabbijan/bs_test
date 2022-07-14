package com.bs.bs_test.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bs.bs_test.api.API
import com.bs.bs_test.api.APIHelper
import com.bs.bs_test.model.DataModels
import com.bs.bs_test.model.SingleOwner
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    private var liveData: MutableLiveData<DataModels> = MutableLiveData()
    private var singleOwner: MutableLiveData<SingleOwner> = MutableLiveData()
    fun getListObserver():MutableLiveData<DataModels>{
        return liveData
    }
    fun getSingleOwnerObserver():MutableLiveData<SingleOwner>{
        return singleOwner
    }
    fun makeApiCall(q:String,sort:String){
        viewModelScope.launch (Dispatchers.IO){
            val apiInstance = APIHelper.getInstance().create(API::class.java)
            val response = apiInstance.getApiCall(q,sort)
            liveData.postValue(response)
        }
    }
    fun makeSingleOwnerApiCall(q:String){
        viewModelScope.launch (Dispatchers.IO){
            val apiInstance = APIHelper.getInstance().create(API::class.java)
            val response = apiInstance.getOwnerInfo(q)
            singleOwner.postValue(response)
        }
    }

}