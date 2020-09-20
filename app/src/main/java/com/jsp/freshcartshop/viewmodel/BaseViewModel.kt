package com.jsp.freshcartshop.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {
    val isLoading = MutableLiveData<Boolean>()
    val isLoaded = MutableLiveData<Boolean>()
    val errorMessageData = MutableLiveData<String>()
}