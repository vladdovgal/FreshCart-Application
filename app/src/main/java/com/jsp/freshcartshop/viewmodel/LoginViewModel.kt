package com.jsp.freshcartshop.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class LoginViewModel() : ViewModel() {
    var login = MutableLiveData<String>()
    var password = MutableLiveData<String>()
    var errorPass = MutableLiveData<String>()
    var errorEmail = MutableLiveData<String>()
}