package com.jsp.freshcartshop.data.repository

import com.jsp.freshcartshop.data.db.LoginDao

class LoginRepositoryImpl(private var loginDao: LoginDao) : LoginRepository {
    override fun isValidAccount(login : String, password : String) : Boolean {
        val userAccount = loginDao.getAccount(login)
        return userAccount.loginData.password.equals(password)
    }

    override fun insertUser(fullName : String, username: String, login: Login) {
        val account = UserAccount(fullName, username, login)
        loginDao.insert(account)
    }

}