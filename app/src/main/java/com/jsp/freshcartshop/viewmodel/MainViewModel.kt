package com.jsp.freshcartshop.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jsp.freshcartshop.Coroutines
import com.jsp.freshcartshop.data.repository.FreshCartRepository
import com.jsp.freshcartshop.model.Product
import kotlinx.coroutines.Job

class MainViewModel(private val freshCartRepository: FreshCartRepository) : ViewModel() {

    private lateinit var job: Job

    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>>
        get() = _products

    fun getProducts() {
        job = Coroutines.ioThenMain(
            { freshCartRepository.getAllProducts()},
            {_products.value = it?.value}
        )
    }

    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }
}