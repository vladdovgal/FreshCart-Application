package com.jsp.freshcartshop.view

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.jsp.freshcartshop.R
import com.jsp.freshcartshop.databinding.ActivityLoginBinding
import com.jsp.freshcartshop.model.LoginUser
import com.jsp.freshcartshop.viewModel.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*
import java.util.*


class LoginActivity : AppCompatActivity() {

    private var loginViewModel: LoginViewModel? = null
    private lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        binding.lifecycleOwner = this

        binding.loginViewModel = loginViewModel

        loginViewModel!!.getUser().observe(this, androidx.lifecycle.Observer<LoginUser>() {
            fun onChanged(@Nullable loginUser: LoginUser) {
                if (TextUtils.isEmpty(Objects.requireNonNull(loginUser).strEmailAddress)) {
                    binding.etUsername.error = "Enter an E-Mail Address"
                    binding.etUsername.requestFocus()
                } else if (!loginUser.isEmailValid) {
                    binding.etUsername.error = "Enter a Valid E-mail Address"
                    binding.etUsername.requestFocus()
                } else if (TextUtils.isEmpty(Objects.requireNonNull(loginUser).strPassword)) {
                    binding.etPassword.error = "Enter a Password"
                    binding.etPassword.requestFocus()
                } else if (!loginUser.isPasswordLengthGreaterThan5) {
                    binding.etPassword.error = "Enter at least 6 Digit password"
                    binding.etPassword.requestFocus()
                } else {
//                    binding.lblEmailAnswer.setText(loginUser.strEmailAddress)
//                    binding.lblPasswordAnswer.setText(loginUser.strPassword)
                }
            }
        })


        signInButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}