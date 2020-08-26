package com.jsp.freshcartshop.utils

import android.text.TextUtils
import android.util.Patterns
import java.util.*

object ValidationUtils {
    private const val MAX_PASSWORD_LENGTH = 5
    private const val EMPTY_PASSWORD = "Password can't be empty"
    private const val EMPTY_EMAIL = "Email can't be empty"
    private const val NOT_VALID_EMAIL = "Email is not valid"
    private const val SHORT_EMAIL = "Password must be 6 digits or longer"
    private const val NO_ERROR = ""


    fun isPasswordValid(password : String) : String {
        return when {
            TextUtils.isEmpty(Objects.requireNonNull(password)) -> {
                EMPTY_PASSWORD
            }
            password.length <= MAX_PASSWORD_LENGTH -> {
                SHORT_EMAIL
            }
            else -> NO_ERROR
        }
    }

    fun isEmailValid(email : String) : String {
        return when {
            TextUtils.isEmpty(Objects.requireNonNull(email)) -> {
                EMPTY_EMAIL
            }
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                NOT_VALID_EMAIL
            }
            else -> NO_ERROR
        }
    }
}
