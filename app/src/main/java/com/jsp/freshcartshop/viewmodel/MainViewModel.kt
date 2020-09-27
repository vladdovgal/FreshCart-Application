package com.jsp.freshcartshop.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.jsp.freshcartshop.data.repository.FreshCartRepositoryImpl
import com.jsp.freshcartshop.model.Product
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject

class MainViewModel : BaseViewModel() {

    private val freshCartRepository by inject(FreshCartRepositoryImpl::class.java)

    val productList = MutableLiveData<List<Product>>()
    val product = MutableLiveData<Product>()
    val isLoaded = MutableLiveData<Boolean>()

    fun loadProducts() {
        viewModelScope.launch {
            try {
                isLoading.postValue(true)
                val response = freshCartRepository.getProducts()
                productList.value = response
                isLoaded.postValue(true)
                errorMessageData.postValue(null)
            } catch (e: Exception) {
                e.printStackTrace()
                errorMessageData.postValue(e.message)
            } finally {
                isLoading.postValue(false)
            }
        }
    }

    fun loadProduct(id : Long) {
        viewModelScope.launch {
            try {
                val response = freshCartRepository.getProductById(id)
                product.value = response
            } catch (e: Exception) {
                e.printStackTrace()
                errorMessageData.postValue(e.message)
            }
        }
    }
}