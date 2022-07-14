package com.bs.bs_test.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bs.bs_test.api.API
import com.bs.bs_test.api.APIHelper
import com.bs.bs_test.model.DataModels
import com.bs.bs_test.model.SingleOwner
import com.bs.bs_test.repository.DataRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModel (private val repository: DataRepository) : ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO){
            repository.getData("Android","stargazers")
        }
    }
    fun makeApiCall(q:String,sort:String){
        viewModelScope.launch (Dispatchers.IO){
            repository.getData(q,sort)
        }
    }
    val quotes : LiveData<DataModels>
        get() = repository.liveData
}