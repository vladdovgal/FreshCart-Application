package com.jsp.freshcartshop.utils

import android.text.TextUtils
import android.util.Patterns
import java.util.*

object StringUtils {
    fun isPasswordValid(password : String) : String {
        return when {
            TextUtils.isEmpty(Objects.requireNonNull(password)) -> {
                "Password can't be empty"
            }
            password.length <= 5 -> {
                "Password must be 6 digits or longer"
            }
            else -> ""
        }
    }
    fun isEmailValid(email : String) : String {
        return when {
            TextUtils.isEmpty(Objects.requireNonNull(email)) -> {
                "Email can't be empty"
            }
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                "Input valid email"
            }
            else -> ""
        }
    }
}
