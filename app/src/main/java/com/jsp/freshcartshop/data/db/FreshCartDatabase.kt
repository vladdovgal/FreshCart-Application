package com.jsp.freshcartshop.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jsp.freshcartshop.data.repository.UserAccount

@Database(
    entities = [UserAccount::class],
    version = 1
)
abstract class FreshCartDatabase : RoomDatabase() {

    companion object{
        @Volatile private var instance: FreshCartDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                FreshCartDatabase::class.java, "freshkart.db")
                .build()
    }
}