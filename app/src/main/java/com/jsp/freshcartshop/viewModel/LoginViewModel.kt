package com.jsp.freshcartshop.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jsp.freshcartshop.model.LoginUser


class LoginViewModel : ViewModel() {
    var emailAddress = MutableLiveData<String>()
    var password = MutableLiveData<String>()
    private lateinit var userMutableLiveData : MutableLiveData<LoginUser>

    fun getUser() : MutableLiveData<LoginUser> = userMutableLiveData

    fun onClick() {
        if (emailAddress.value != null && password.value!= null) {
            val loginUser = LoginUser(
                emailAddress.value ?: "",
                password.value ?:"");
            userMutableLiveData.value = loginUser;
        }
    }
}