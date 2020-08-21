package com.jsp.freshcartshop.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.jsp.freshcartshop.R
import com.jsp.freshcartshop.databinding.ActivityLoginBinding
import com.jsp.freshcartshop.utils.StringUtils
import com.jsp.freshcartshop.viewModel.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*


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
            val error = StringUtils.isPasswordValid(it)
            if (error != "") {
                loginViewModel.errorPass.value = error
                binding.etPassword.requestFocus()
            }
        })

        loginViewModel.emailAddress.observe(this, androidx.lifecycle.Observer() {
            val error = StringUtils.isEmailValid(it)
            if (error != "") {
                loginViewModel.errorEmail.value = error
                binding.etUsername.requestFocus()
            }
        })

        binding.signInButton.setOnClickListener {
            if (loginViewModel.errorEmail.value != "") {
                etUsername.error = loginViewModel.errorEmail.value
            }
            if (loginViewModel.errorPass.value != "") {
                etPassword.error = loginViewModel.errorPass.value
            }
        }
    }
}