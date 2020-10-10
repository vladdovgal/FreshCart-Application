package com.jsp.freshcartshop.data.db.dao

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.jsp.freshcartshop.data.repository.Login

class UserFirebaseDao {
    private var mDatabase = FirebaseDatabase.getInstance()
    private var mDatabaseReference = mDatabase.reference.child("Users")
    private var mAuth : FirebaseAuth = FirebaseAuth.getInstance()

    fun getUser(login: String, password: String, userCallback: UserCallback){
        mAuth.signInWithEmailAndPassword(login, password)
            .addOnCompleteListener{ task ->
                if (task.isSuccessful) {
                    userCallback.isUserExist(true)
                } else {
                    userCallback.isUserExist(false)
                }
            }
    }

    fun insertUser(fullName : String, username: String, login: Login) {
        mAuth.createUserWithEmailAndPassword(login.email, login.password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d("myLogs", "createUserWithEmail:success")
                    val userId = mAuth.currentUser?.uid
                    val currentUserDb = userId?.let { mDatabaseReference.child(it) }
                    currentUserDb?.child("fullName")?.setValue(fullName)
                    currentUserDb?.child("username")?.setValue(username)
                } else {
                    Log.w("myLogs", "createUserWithEmail:failure", task.exception)
                }
            }
    }
}

interface UserCallback {
    fun isUserExist(exist: Boolean)
}