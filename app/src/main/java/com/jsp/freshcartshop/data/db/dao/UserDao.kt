package com.jsp.freshcartshop.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jsp.freshcartshop.data.repository.UserAccount

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: UserAccount)

    @Query("SELECT * FROM USERACCOUNT WHERE email = :username OR username = :username LIMIT 1")
    suspend fun getUserByUsernameOrEmail(username: String): UserAccount

    @Query("SELECT * FROM USERACCOUNT")
    suspend fun getUsers(): List<UserAccount>
}