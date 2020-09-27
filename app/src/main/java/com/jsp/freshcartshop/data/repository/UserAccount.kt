package com.jsp.freshcartshop.data.repository

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserAccount(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val fullName: String,
    val username: String,
    @Embedded
    val loginData: Login)