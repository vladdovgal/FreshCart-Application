package com.jsp.freshcartshop

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.jsp.freshcartshop.databinding.ActivityLoginBinding
import com.jsp.freshcartshop.utils.ValidationUtils
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : BaseActivity() {

    private lateinit var loginViewModel: LoginViewModel
    private lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.lifecycleOwner = this
        binding.loginViewModel = loginViewModel
        init()
    }

    private fun init() {
        observeData()
        binding.signInButton.setOnClickListener {
            onSignInClick()
        }
        binding.tvNotMember.setOnClickListener {
            onTvNotMemberClick()
        }
    }

    private fun onSignInClick() {
        var flag = true
        if (loginViewModel.errorEmail.value != "") {
            etUsername.error = loginViewModel.errorEmail.value
            flag = false
        }
        if (loginViewModel.errorPass.value != "") {
            etPassword.error = loginViewModel.errorPass.value
            flag = false
        }
        if (flag) {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun onTvNotMemberClick() {
        val signUpFragment = SignUpFragment()
        openFragment(signUpFragment)
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 0) {
            this.finish()
        } else {
            supportFragmentManager.popBackStack()
        }
    }

    private fun openFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.signIn, fragment)
            .addToBackStack(null)
            .commit()
    }

    private fun validatePassword(password: String) {
        val error = ValidationUtils.isPasswordValid(password)
        if (error != "") {
            loginViewModel.errorPass.value = error
            binding.etPassword.requestFocus()
        } else loginViewModel.errorPass.value = ""
    }

    private fun validateEmail(email : String) {
        val error = ValidationUtils.isEmailValid(email)
        if (error != "") {
            loginViewModel.errorEmail.value = error
            binding.etUsername.requestFocus()
        } else loginViewModel.errorEmail.value = ""
    }

    private fun observeData() {
        loginViewModel.password.observe(this, androidx.lifecycle.Observer() {
            validatePassword(it)
        })

        loginViewModel.emailAddress.observe(this, androidx.lifecycle.Observer() {
            validateEmail(it)
        })
    }
}