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
import com.bs.bs_test.repository.SingleOwnerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SingleOwnerViewModel(private val repository: SingleOwnerRepository): ViewModel() {
    private var singleOwner: MutableLiveData<SingleOwner> = MutableLiveData()
    fun getSingleOwnerObserver(): MutableLiveData<SingleOwner> {
        return singleOwner
    }
    fun makeSingleOwnerApiCall(q: String) {
        viewModelScope.launch (Dispatchers.IO){
            repository.getSingleOwnerData(q)
        }
    }
    val ownerInfo : LiveData<SingleOwner>
        get() = repository.SingleOwnerliveData
}