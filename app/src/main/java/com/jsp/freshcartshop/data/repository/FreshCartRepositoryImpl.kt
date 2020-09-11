package com.jsp.freshcartshop.data.repository

import androidx.lifecycle.LiveData
import com.jsp.freshcartshop.data.db.dao.FreshCartDao
import com.jsp.freshcartshop.model.Product

class FreshCartRepositoryImpl(private val freshCartDao: FreshCartDao) : FreshCartRepository {

    override fun getAllProducts(): LiveData<List<Product>> {
        return freshCartDao.getAllProducts()
    }
}