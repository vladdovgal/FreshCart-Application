package com.jsp.freshcartshop.data.repository

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class UserAccount(
    @PrimaryKey
    val id: String,
    val fullName: String,
    val username: String,
    @Embedded
    val loginData: Login) {

    constructor(fullName: String, username: String, loginData: Login) : this(UUID.randomUUID().toString(), fullName, username, loginData)
}