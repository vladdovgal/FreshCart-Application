package com.jsp.freshcartshop.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.jsp.freshcartshop.data.repository.FreshCartRepositoryImpl
import com.jsp.freshcartshop.model.Login
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent

class SignUpViewModel : BaseViewModel() {

    private val freshCartRepository by KoinJavaComponent.inject(FreshCartRepositoryImpl::class.java)

    val fullName = MutableLiveData<String>()
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val isLoaded = MutableLiveData<Boolean>()

    fun registerUser() {
        viewModelScope.launch {
            try {
                isLoading.postValue(true)
                freshCartRepository.insertUser(fullName.value!!, Login(email.value!!, password.value!!))
                isLoaded.postValue(true)
            } catch (e: Exception) {
                e.printStackTrace()
                errorMessageData.postValue(e.message)
            } finally {
                isLoading.postValue(false)
            }
        }
    }
}