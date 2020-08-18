package com.jsp.freshcartshop.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jsp.freshcartshop.model.LoginUser


class LoginViewModel : ViewModel() {
    var emailAddress = MutableLiveData<String>()
    var password = MutableLiveData<String>()
    var userMutableLiveData : MutableLiveData<LoginUser> = MutableLiveData()

    fun onClick() {
            val loginUser = LoginUser(
                emailAddress.value ?: "",
                password.value ?:"");
            userMutableLiveData.value = loginUser;
        Log.d("myLogs", "Email : ${emailAddress.value} Pass: ${password.value}")
    }
}