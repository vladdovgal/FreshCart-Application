package com.jsp.freshcartshop.repository

import androidx.lifecycle.LiveData
import com.jsp.freshcartshop.model.Product

interface ProductRepository {

    fun getAll(): LiveData<List<Product>>
}