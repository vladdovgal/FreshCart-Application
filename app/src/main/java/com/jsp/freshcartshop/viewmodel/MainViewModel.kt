package com.jsp.freshcartshop.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jsp.freshcartshop.data.repository.FreshCartRepositoryImpl
import com.jsp.freshcartshop.model.Product
import kotlinx.coroutines.Job
import org.koin.java.KoinJavaComponent.inject

class MainViewModel : ViewModel() {

    private val freshCartRepository by inject(FreshCartRepositoryImpl::class.java)
    private lateinit var job: Job

    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>>
        get() = _products

    private val _product = MutableLiveData<Product>()
    val product: LiveData<Product>
        get() = _product

    fun getProducts() {
//        job = Coroutines.ioThenMain(
//            { freshCartRepository.getAllProducts()},
//            {_products.value = it?.value}
//        )
    }

    fun getProductById(id : Long) {
//        job = Coroutines.ioThenMain(
//            {freshCartRepository.getProductById(id)},
//            {_product.value = it?.value}
//        )
    }

    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }
}