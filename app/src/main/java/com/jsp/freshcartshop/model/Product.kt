package com.jsp.freshcartshop.model

// todo Expand product fields with : Reviews count, rating, description & remaining units
data class Product(
    val id: Int,
    val name: String,
    val price: Int,
    val oldPrice: Int,
    val images: List<String>)
