package com.jsp.freshcartshop.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jsp.freshcartshop.data.repository.FreshCartRepositoryImpl
import com.jsp.freshcartshop.model.Product
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject
import java.lang.Exception

class MainViewModel : ViewModel() {

    private val freshCartRepository by inject(FreshCartRepositoryImpl::class.java)
    val isLoading = MutableLiveData<Boolean>()
    val isLoaded = MutableLiveData<Boolean>()
    val productList = MutableLiveData<List<Product>>()
    val errorMessageData = MutableLiveData<String>()

    fun loadProducts() {
        viewModelScope.launch {
            try {
                isLoading.postValue(true)
                val response = freshCartRepository.getProducts()
                productList.value = response
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