package com.jsp.freshcartshop.repository.impl

import androidx.lifecycle.LiveData
import com.jsp.freshcartshop.data.db.dao.ProductDao
import com.jsp.freshcartshop.model.Product
import com.jsp.freshcartshop.repository.ProductRepository

class ProductRepositoryImpl(private val productDao: ProductDao) : ProductRepository {

    override fun getAll(): LiveData<List<Product>> {
        return productDao.getAll()
    }
}