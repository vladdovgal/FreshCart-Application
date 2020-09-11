package com.jsp.freshcartshop.data.repository

import com.jsp.freshcartshop.data.db.FreshCartDao

class FreshCartRepositoryImpl(private val applicationDao: FreshCartDao) : FreshCartRepository {
    override fun loginUser(login : String, password : String) : Boolean {
        val userAccount = applicationDao.getAccount(login)
        return userAccount.loginData.password == password
    }

    override fun insertUser(fullName : String, username: String, login: Login) {
        val account = UserAccount(fullName, username, login)
        applicationDao.insert(account)
    }

}