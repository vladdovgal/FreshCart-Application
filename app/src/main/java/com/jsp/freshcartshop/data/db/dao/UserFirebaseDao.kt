package com.jsp.freshcartshop.data.db.dao

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.jsp.freshcartshop.model.Login

class UserFirebaseDao {
    private var mDatabase = FirebaseDatabase.getInstance()
    private var mDatabaseReference = mDatabase.reference.child("Users")
    private var mAuth : FirebaseAuth = FirebaseAuth.getInstance()

    fun getUser(email: String, password: String, userCallback: UserCallback){
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener{ task ->
                if (task.isSuccessful) {
                    userCallback.isUserExist(true)
                } else {
                    userCallback.isUserExist(false)
                }
            }
    }

    fun insertUser(fullName: String, login: Login) {
        mAuth.createUserWithEmailAndPassword(login.email, login.password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    registerUser(fullName, login)
                } else {
                    Log.w("myLogs", "createUserWithEmail:failure", task.exception)
                }
            }
    }

    private fun registerUser(fullName: String, login: Login) {
        Log.d("myLogs", "createUserWithEmail:success")
        val userId = mAuth.currentUser?.uid
        val currentUserDb = userId?.let { mDatabaseReference.child(it) }
        currentUserDb?.child("fullName")?.setValue(fullName)
        currentUserDb?.child("email")?.setValue(login.email)
    }
}

interface UserCallback {
    fun isUserExist(exist: Boolean)
}