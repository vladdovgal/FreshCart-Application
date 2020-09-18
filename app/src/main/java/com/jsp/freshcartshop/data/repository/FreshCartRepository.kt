package com.jsp.freshcartshop.data.repository

import com.jsp.freshcartshop.model.Product

interface FreshCartRepository {

    fun loginUser(login : String, password : String) : Boolean

    fun insertUser(fullName : String, username: String, login: Login)

    suspend fun getProductById(id : Long) : Product?

    suspend fun getProducts(): List<Product>?
}