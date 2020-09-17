package com.jsp.freshcartshop.model

data class Product(
    val id: Int,
    val name: String,
    val price: Int,
    val oldPrice: Int,
    val images: List<Int>)