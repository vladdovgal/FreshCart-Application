package com.jsp.freshcartshop.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jsp.freshcartshop.model.LoginUser


class LoginViewModel : ViewModel() {
    var emailAddress = MutableLiveData<String>()
    var password = MutableLiveData<String>()
    private var userMutableLiveData : MutableLiveData<LoginUser>? = null

    fun getUser() : MutableLiveData<LoginUser> = userMutableLiveData ?: MutableLiveData()

    fun onClick() {
            val loginUser = LoginUser(
                emailAddress.value ?: "",
                password.value ?:"");
            userMutableLiveData?.value  = loginUser;
        Log.d("myLogs", "Email : ${emailAddress.value} Pass: ${password.value}")
    }
}