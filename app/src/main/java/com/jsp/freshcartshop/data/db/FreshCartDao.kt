package com.jsp.freshcartshop.data.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jsp.freshcartshop.R
import com.jsp.freshcartshop.data.repository.Login
import com.jsp.freshcartshop.data.repository.UserAccount
import com.jsp.freshcartshop.model.Product

class FreshCartDao {

    private val productList = mutableListOf<Product>()
    private val products = MutableLiveData<List<Product>>()
    private val accountsList = mutableListOf<UserAccount>()

    init {
        accountsList.add(UserAccount("John Root", "root",
            Login("root@a.a", "root")))
    }

    fun getAllProducts() = products
        private fun fillProducts() {
            productList.add(Product(2, "Coconut", 20, 25, R.drawable.coconut))
    }

    fun getAccount(login: String): UserAccount {
        // todo getAccount data from database
        return accountsList.find { it.loginData.email == login || it.username == login }
            ?: UserAccount("","", Login("", ""))
    }

    fun insert(account: UserAccount) {Int
        // todo insert user intInto database
    }

    fun getProduct(id: Long): LiveData<Product> {
        val product = products.value?.find { it.id == id }
        return MutableLiveData<Product>(product)
    }
}