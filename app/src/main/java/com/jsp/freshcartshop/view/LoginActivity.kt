package com.jsp.freshcartshop.view

import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.jsp.freshcartshop.R
import com.jsp.freshcartshop.databinding.ActivityLoginBinding
import com.jsp.freshcartshop.viewModel.LoginViewModel
import java.util.*


class LoginActivity : AppCompatActivity() {

    private lateinit var loginViewModel: LoginViewModel
    private lateinit var binding : ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        binding.lifecycleOwner = this
        binding.loginViewModel = loginViewModel

        loginViewModel.password.observe(this, androidx.lifecycle.Observer() {
            fun onChanged(@Nullable strEmailAddress : String, @Nullable strPassword: String ) {
                when {
                    TextUtils.isEmpty(Objects.requireNonNull(strPassword)) -> {
                        binding.etPassword.error = "Enter a Password"
                        binding.etPassword.requestFocus()
                    }
                    !strPassword.isPasswordLengthGreaterThan5() -> {
                        binding.etPassword.hint = "Enter at least 6 Digit password"
                        binding.etPassword.requestFocus()
                    }
                    else -> {
                        binding.etPassword.setText(strPassword)
                    }
                }
            }
        })

        loginViewModel.emailAddress.observe(this, androidx.lifecycle.Observer() {
            fun onChanged(@Nullable strEmailAddress : String, @Nullable strPassword: String ) {
                when {
                    TextUtils.isEmpty(Objects.requireNonNull(strEmailAddress)) -> {
                        binding.etUsername.error = "Enter an E-Mail Address"
                        binding.etUsername.requestFocus()
                    }
                    !strEmailAddress.isEmailValid() -> {
                        binding.etUsername.error = "Enter a Valid E-mail Address"
                        binding.etUsername.requestFocus()
                    }
                    else -> {
                        binding.etUsername.setText(strEmailAddress)
                    }
                }
            }
        })
    }

    fun String.isEmailValid() : Boolean = Patterns.EMAIL_ADDRESS.matcher(this).matches()

    fun String.isPasswordLengthGreaterThan5() : Boolean =  this.length > 5

}