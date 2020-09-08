package com.jsp.freshcartshop.data.db

import com.jsp.freshcartshop.data.db.dao.ProductDao

interface Database {
    val productDao: ProductDao
}