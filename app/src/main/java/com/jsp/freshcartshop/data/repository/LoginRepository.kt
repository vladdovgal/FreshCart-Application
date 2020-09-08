package com.jsp.freshcartshop.data.repository

interface LoginRepository {
    fun isValidAccount(login : String, password : String) : Boolean

    fun insertUser(fullName : String, username: String, login: Login) : Unit
}