package com.jsp.freshcartshop.data.repository

import com.jsp.freshcartshop.model.Product

interface FreshCartRepository {
    fun loginUser(login : String, password : String) : Boolean

    fun insertUser(fullName : String, username: String, login: Login) : Unit

    suspend fun getAllProducts(): List<Product>?

    suspend fun getProductById(id : Long) : Product?
}