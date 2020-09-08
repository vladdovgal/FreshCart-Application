package com.jsp.freshcartshop.data.db.dao

import androidx.lifecycle.LiveData
import com.jsp.freshcartshop.model.Product

interface ProductDao {
    fun getAll(): LiveData<List<Product>>
}