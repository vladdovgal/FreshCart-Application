package com.jsp.freshcartshop.viewmodel

import androidx.lifecycle.ViewModel
import com.jsp.freshcartshop.data.repository.FreshCartRepositoryImpl
import org.koin.java.KoinJavaComponent.inject

class MainViewModel : ViewModel() {

    private val freshCartRepository by inject(FreshCartRepositoryImpl::class.java)
    val products by lazy { freshCartRepository.getAllProducts() }

}