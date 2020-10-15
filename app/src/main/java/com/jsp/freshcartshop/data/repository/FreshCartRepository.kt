package com.jsp.freshcartshop.data.repository

import com.jsp.freshcartshop.model.Category
import com.jsp.freshcartshop.model.Login
import com.jsp.freshcartshop.model.Product
import com.jsp.freshcartshop.model.Promotion

interface FreshCartRepository {

    suspend fun loginUser(login : String, password : String) : Boolean

    suspend fun insertUser(fullName : String, login: Login)

    suspend fun getProductById(id : Long) : Product

    suspend fun getProducts(): List<Product>?

    suspend fun findProducts(productName: String): List<Product>?

    suspend fun getCategories(): List<Category>?

    suspend fun getMainPromotions(): List<Promotion>?

    suspend fun getSearchPromotions(): List<Promotion>?
}