package com.jsp.freshcartshop.data.db

import com.jsp.freshcartshop.data.repository.Login
import com.jsp.freshcartshop.data.repository.UserAccount

class FreshCartDao {

    private val accountsList = mutableListOf<UserAccount>()

    init {
        accountsList.add(UserAccount("John Root", "root",
            Login("root@a.a", "root")))
    }

    fun getAccount(login: String): UserAccount {
        // todo getAccount data from database
        return accountsList.find { it.loginData.email == login || it.username == login }
            ?: UserAccount("","", Login("", ""))
    }

    fun insert(account: UserAccount) {
        // todo insert user into database
    }
}