package com.bs.bs_test.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bs.bs_test.repository.DataRepository
import com.bs.bs_test.repository.SingleOwnerRepository

class SingleOwnerViewModelFactory (private val repository: SingleOwnerRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SingleOwnerViewModel(repository) as T
    }
}