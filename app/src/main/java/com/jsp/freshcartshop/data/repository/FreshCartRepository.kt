package com.jsp.freshcartshop.data.repository

import androidx.lifecycle.LiveData
import com.jsp.freshcartshop.model.Product

interface FreshCartRepository {
    fun loginUser(login : String, password : String) : Boolean

    fun insertUser(fullName : String, username: String, login: Login) : Unit

    fun getAllProducts(): LiveData<List<Product>>

    fun getProductById(id : Long) : LiveData<Product>
}