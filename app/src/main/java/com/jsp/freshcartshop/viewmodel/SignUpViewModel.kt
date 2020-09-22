package com.jsp.freshcartshop.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jsp.freshcartshop.data.repository.FreshCartRepositoryImpl
import com.jsp.freshcartshop.data.repository.Login
import com.jsp.freshcartshop.data.repository.UserAccount
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent

class SignUpViewModel : BaseViewModel() {

    private val freshCartRepository by KoinJavaComponent.inject(FreshCartRepositoryImpl::class.java)

    val fullName = MutableLiveData<String>()
    val username = MutableLiveData<String>()
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()


    fun registerUser() {
        viewModelScope.launch {
            try {
                freshCartRepository.insertUser(fullName.value!!, username.value!!, Login(email.value!!, password.value!!))
                isLoaded.postValue(true)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
             //   isLoaded.postValue(false)
            }
        }
    }
}