package com.jsp.freshcartshop.data.db

import com.jsp.freshcartshop.data.repository.UserAccount

interface LoginDao {
    fun getAccount(login: String): UserAccount

    fun insert(account: UserAccount)
}
