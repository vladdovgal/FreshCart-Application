package com.jsp.freshcartshop.data.repository

import com.jsp.freshcartshop.data.db.dao.FreshCartDao
import com.jsp.freshcartshop.data.db.dao.UserCallback
import com.jsp.freshcartshop.data.db.dao.UserFirebaseDao
import com.jsp.freshcartshop.model.Category
import com.jsp.freshcartshop.model.Product
import com.jsp.freshcartshop.model.Promotion
import kotlinx.coroutines.delay
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class FreshCartRepositoryImpl(private val applicationDao: FreshCartDao,
                              private val userFirebaseDao: UserFirebaseDao) : FreshCartRepository {

    override suspend fun loginUser(login : String, password : String) : Boolean {
        return suspendCoroutine { continuation ->
            userFirebaseDao.getUser(login, password, object : UserCallback {
                override fun isUserExist(exist: Boolean) {
                    if (exist) {
                        continuation.resume(true)
                    } else {
                        continuation.resume(false)
                    }
                }
            })
        }
    }

    override suspend fun insertUser(fullName : String, username: String, login: Login) {
        return suspendCoroutine { continuation ->
            val response = userFirebaseDao.insertUser(fullName, username, login)
            if (response != null) {
                continuation.resume(response)
            } else {
                continuation.resumeWithException(Exception("Can't insert user"))
            }
        }
    }

    override suspend fun getProductById(id: Long): Product {
        return suspendCoroutine { continuation ->
            val response = applicationDao.getProduct(id)
            if (response != null) {
                continuation.resume(response)
            } else {
                continuation.resumeWithException(Exception("Can't load product"))
            }
        }
    }

    override suspend fun getProducts(): List<Product>? {
        // todo simulation of data loading
        delay(500)
        return suspendCoroutine { continuation ->
            val response = applicationDao.getAllProducts()
            if (response != null) {
                continuation.resume(response)
            } else {
                continuation.resumeWithException(Exception("Can't load products"))
            }
        }
    }

    override suspend fun findProducts(productName: String): List<Product>? {
        return suspendCoroutine { continuation ->
            val response = applicationDao.findProducts(productName)
            if (response != null) {
                continuation.resume(response)
            } else {
                continuation.resumeWithException(Exception("Can't load products"))
            }
        }
    }

    override suspend fun getCategories(): List<Category>? {
        return suspendCoroutine { continuation ->
            val response = applicationDao.getCategories()
            if (response != null) {
                continuation.resume(response)
            } else {
                continuation.resumeWithException(Exception("Can't load categories"))
            }
        }
    }

    override suspend fun getMainPromotions(): List<Promotion>? {
        return suspendCoroutine { continuation ->
            val response = applicationDao.getMainPromotions()
            if (response != null) {
                continuation.resume(response)
            } else {
                continuation.resumeWithException(Exception("Can't load main promotions"))
            }
        }
    }

    override suspend fun getSearchPromotions(): List<Promotion>? {
        return suspendCoroutine { continuation ->
            val response = applicationDao.getSearchPromotions()
            if (response != null) {
                continuation.resume(response)
            } else {
                continuation.resumeWithException(Exception("Can't load search promotions"))
            }
        }
    }
}