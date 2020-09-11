package com.jsp.freshcartshop.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jsp.freshcartshop.data.db.LoginDaoFakeImpl
import com.jsp.freshcartshop.data.repository.LoginRepositoryImpl
import com.jsp.freshcartshop.utils.ValidationUtils


class LoginViewModel(private val loginRepository: LoginRepositoryImpl =
                         LoginRepositoryImpl(LoginDaoFakeImpl())) : ViewModel() {
    var login = MutableLiveData<String>()
    var password = MutableLiveData<String>()
    var errorPass = MutableLiveData<String>()
    var errorEmail = MutableLiveData<String>()

    // call repository to check if such user exists
    fun validateInput(): Boolean {
        return loginRepository.isValidAccount(login.value.toString(),
            password.value.toString())
    }


    // validate input using ValidationUtils
    fun validatePassword(password: String) {
        val error = ValidationUtils.isPasswordValid(password)
        if (error != "") {
            errorPass.value = error
        } else errorPass.value = ""
    }

    fun validateEmail(email : String) {
        val error = ValidationUtils.isEmailValid(email)
        if (error != "") {
            errorEmail.value = error
        } else errorEmail.value = ""
    }
}