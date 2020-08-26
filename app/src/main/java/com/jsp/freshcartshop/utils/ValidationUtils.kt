package com.jsp.freshcartshop.utils

import android.text.TextUtils
import android.util.Patterns
import java.util.*

object ValidationUtils {
    private const val MIN_PASSWORD_LENGTH = 6
    private const val NO_ERROR = ""


    fun isPasswordValid(password : String) : String {
        return when {
            TextUtils.isEmpty(Objects.requireNonNull(password)) -> {
                "Password can't be empty"
            }
            password.length < MIN_PASSWORD_LENGTH -> {
                "Password must be $MIN_PASSWORD_LENGTH digits or longer"
            }
            else -> NO_ERROR
        }
    }

    fun isEmailValid(email : String) : String {
        return when {
            TextUtils.isEmpty(Objects.requireNonNull(email)) -> {
                "Email can't be empty"
            }
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                "Email is not valid"
            }
            else -> NO_ERROR
        }
    }
}
