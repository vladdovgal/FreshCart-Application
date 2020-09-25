package com.jsp.freshcartshop.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.jsp.freshcartshop.data.repository.FreshCartRepositoryImpl
import com.jsp.freshcartshop.utils.ValidationUtils
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject


class LoginViewModel : BaseViewModel() {
    // Application Repository
    private val appRepository by inject(FreshCartRepositoryImpl::class.java)

    // Login data
    var login = MutableLiveData<String>()
    var password = MutableLiveData<String>()

    // Warnings data
    var errorPass = MutableLiveData<String>()
    var errorEmail = MutableLiveData<String>()

    // If user exists
    var userExists = MutableLiveData<Boolean>()

    // Call repository to check if such user exists
    fun checkIfUserExists() {
        viewModelScope.launch {
            try {
                isLoading.postValue(true)
                userExists.value = appRepository.loginUser(login.value.toString(),
                        password.value.toString())
                isLoaded.postValue(true)
                errorMessageData.postValue(null)
            } catch (e : Exception) {
                e.printStackTrace()
            } finally {
                isLoading.postValue(false)
            }
        }
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