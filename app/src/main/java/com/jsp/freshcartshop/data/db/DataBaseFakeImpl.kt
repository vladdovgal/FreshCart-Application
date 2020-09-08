package com.jsp.freshcartshop.data.db

import com.jsp.freshcartshop.data.db.dao.ProductDao
import com.jsp.freshcartshop.data.db.dao.impl.ProductDaoFakeImpl

class DataBaseFakeImpl : Database {
    override val productDao: ProductDao = ProductDaoFakeImpl()
}