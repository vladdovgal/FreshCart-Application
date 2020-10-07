package com.jsp.freshcartshop.data.repository

import com.jsp.freshcartshop.model.Product

interface FreshCartRepository {

    suspend fun loginUser(login : String, password : String) : Boolean

    suspend fun insertUser(fullName : String, username: String, login: Login)

    suspend fun getProductById(id : Long) : Product

    suspend fun getProducts(): List<Product>?

    suspend fun findProducts(productName: String): List<Product>?
}