package com.jsp.freshcartshop.data.repository

interface FreshCartRepository {
    fun loginUser(login : String, password : String) : Boolean

    fun insertUser(fullName : String, username: String, login: Login) : Unit
}