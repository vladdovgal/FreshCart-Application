package com.jsp.freshcartshop.data.repository

import androidx.lifecycle.LiveData
import com.jsp.freshcartshop.model.Product

interface FreshCartRepository {

    fun getAllProducts(): LiveData<List<Product>>
}