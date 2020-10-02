package com.jsp.freshcartshop.data.db.dao

import com.jsp.freshcartshop.data.repository.Login
import com.jsp.freshcartshop.data.repository.UserAccount
import com.jsp.freshcartshop.model.Product
import java.util.*

class FreshCartDao {

    private val productList = mutableListOf<Product>()
    private val accountsList = mutableListOf<UserAccount>()

    init {
        fillProducts()
        accountsList.add(UserAccount(UUID.randomUUID().toString(),"John Root", "root",
            Login("root@a.a", "root")
        ))
    }

    fun getAllProducts() = productList

    private fun fillProducts() {
        productList.add(Product(1, "Water Lemon", 15, 20, listOf("https://previews.123rf.com/images/kovalevaka/kovalevaka1409/kovalevaka140900003/31404789-watermelon-and-slices-isolated-on-white-background-as-package-design-element.jpg", "https://images.unsplash.com/photo-1581074817932-af423ba4566e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2000&q=80.jpg")))
        productList.add(Product(2, "Coconut", 20, 25, listOf("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTUT7A21bB7_X7cQ23sLf-E9K056cQ_n8IKyQXeh3GCQyugv0xBGxTKKzkRunJ4zyeAwcGhJUzqDrMWyQXkNIajTLrd1pjC1n6AoQ&usqp=CAU&ec=45702845", "https://images.unsplash.com/photo-1588413335367-e49d32c5b50b?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80.jpg")))
        productList.add(Product(3, "Pear", 20, 22, listOf("https://previews.123rf.com/images/photomaru/photomaru1610/photomaru161000008/65097111-isolated-pears-one-and-a-half-green-pear-fruit-isolated-on-white-background.jpg")))
        productList.add(Product(4, "Guava", 15, 17, listOf("https://www.fructo.com.ua/image/cache/catalog/fruct/guav-1400x1400.png")))
        productList.add(Product(5, "Apple", 15, 20, listOf("https://5.imimg.com/data5/LM/DU/MY-22954806/apple-fruit-500x500.jpg")))
        productList.add(Product(6, "Bitter Melon", 18, 22, listOf("https://fruitshop.7uptheme.net/wp-content/uploads/2017/04/fruit_20.jpg")))
        productList.add(Product(7, "Brinjal", 14, 18, listOf("https://qph.fs.quoracdn.net/main-qimg-ecd53c201e40d8e834b7f67a3619e532")))
    }

    fun getAccount(login: String): UserAccount {
        // todo getAccount data from database
        return accountsList.find { it.loginData.email == login || it.username == login }
            ?: UserAccount(UUID.randomUUID().toString(), "","", Login("", ""))
    }

    fun insert(account: UserAccount): UserAccount {
        accountsList.add(account)
        return account
    }

    fun getProduct(id: Long): Product? {
        // todo get product by id from database
        return productList.find { it.id == id }
    }
}