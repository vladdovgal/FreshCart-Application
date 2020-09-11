package com.jsp.freshcartshop.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jsp.freshcartshop.data.repository.FreshCartRepositoryImpl
import com.jsp.freshcartshop.utils.ValidationUtils
import org.koin.java.KoinJavaComponent.inject


class LoginViewModel : ViewModel() {
    // Application Repository
    private val appRepository by inject(FreshCartRepositoryImpl::class.java)

    // Login data
    var login = MutableLiveData<String>()
    var password = MutableLiveData<String>()

    // Warnings data
    var errorPass = MutableLiveData<String>()
    var errorEmail = MutableLiveData<String>()

    // Call repository to check if such user exists
    fun validateInput(): Boolean {
        return appRepository.loginUser(login.value.toString(),
            password.value.toString())
    }


    // Validate input using ValidationUtils
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