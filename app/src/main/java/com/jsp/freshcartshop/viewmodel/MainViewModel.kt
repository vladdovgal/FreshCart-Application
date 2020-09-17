package com.jsp.freshcartshop.viewmodel


import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jsp.freshcartshop.data.repository.FreshCartRepositoryImpl
import com.jsp.freshcartshop.model.Product
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject


class MainViewModel : ViewModel() {

    private val freshCartRepository by inject(FreshCartRepositoryImpl::class.java)

    val isLoading = MutableLiveData<Boolean>()
    val isLoaded = MutableLiveData<Boolean>()
    val productList = MutableLiveData<List<Product>>()
    val errorMessageData = MutableLiveData<String>()
    val product = MutableLiveData<Product>()

    init {
        Log.d("myLogs", "ViewModel created : product : ${product.value.toString()}")
    }

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

    fun loadProduct(id : Int) {
        viewModelScope.launch {
            try {
                val response = freshCartRepository.getProductById(id)
                Log.d("myLogs", "Response: ${response.toString()}")
                product.value = response
                Log.d("myLogs", "Product in ViewModel: ${product.value.toString()}")
            } catch (e: Exception) {
                e.printStackTrace()
                errorMessageData.postValue(e.message)
            }
        }
    }
}