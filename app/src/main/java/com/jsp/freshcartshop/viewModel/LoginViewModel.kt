package com.jsp.freshcartshop.viewModel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jsp.freshcartshop.model.LoginUser

class LoginViewModel : ViewModel() {
    var EmailAddress = MutableLiveData<String>()
        get() = field
    var Password = MutableLiveData<String>()

    private var userMutableLiveData : MutableLiveData<LoginUser>? = null;

    fun getUser() : MutableLiveData<LoginUser> = userMutableLiveData ?: MutableLiveData()

    fun onClick(view : View) {
        val loginUser = LoginUser(EmailAddress.value!!, Password.value!!);
        userMutableLiveData?.value = loginUser;
    }
}