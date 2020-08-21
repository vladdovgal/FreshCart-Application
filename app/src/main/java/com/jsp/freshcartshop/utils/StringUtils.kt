package com.jsp.freshcartshop.utils

import android.text.TextUtils
import android.util.Patterns
import java.util.*


class StringUtils {
    companion object {
        fun isPasswordValid(password : String) : String {
            return when {
                TextUtils.isEmpty(Objects.requireNonNull(password)) -> {
                    "Password can't be empty"
                }
                !password.isPasswordLengthGreaterThan5() -> {
                    "Enter at least 6 Digit password"
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

        private fun String.isPasswordLengthGreaterThan5() : Boolean =  this.length > 5

    }

}