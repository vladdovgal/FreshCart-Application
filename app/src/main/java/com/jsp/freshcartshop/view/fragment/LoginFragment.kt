package com.jsp.freshcartshop.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.jsp.freshcartshop.R
import com.jsp.freshcartshop.data.repository.LoginRepositoryImpl
import com.jsp.freshcartshop.databinding.FragmentLoginBinding
import com.jsp.freshcartshop.utils.ValidationUtils
import com.jsp.freshcartshop.view.BaseActivity
import com.jsp.freshcartshop.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.fragment_login.*
import org.koin.android.ext.android.get

class LoginFragment : BaseFragment() {

    private var loginViewModel: LoginViewModel = get()
    private lateinit var binding : FragmentLoginBinding
    private var repository : LoginRepositoryImpl = get()

    override fun setFragmentLayout(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        binding.lifecycleOwner = this
        binding.loginViewModel = loginViewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as BaseActivity).setToolBarTitle(getString(R.string.login_title))
        init(view)
    }

    private fun init(view: View) {
        observeData()
        binding.signInButton.setOnClickListener {
            onSignInClick(view)
        }
        binding.tvNotMember.setOnClickListener {
            onTvNotMemberClick(view)
        }
    }

    private fun onSignInClick(view: View) {
        if (validateInput()) {
            if (repository.isValidAccount(loginViewModel.login.value.toString(),
                loginViewModel.password.value.toString())) {
                view.findNavController().navigate(R.id.action_loginFragment_to_mainActivity)
            } else Toast.makeText(context, "Wrong login or password", Toast.LENGTH_SHORT).show()
        }
    }

    private fun validateInput() : Boolean {
        var flag = true
        if (loginViewModel.login.value != null) {
            if (loginViewModel.login.value?.contains('@')!!) {
                // validate email
                if (loginViewModel.errorEmail.value != "") {
                    etUsername.error = loginViewModel.errorEmail.value
                    flag = false
                }
            }
        } else {
            Toast.makeText(context, "Input fields can't be empty", Toast.LENGTH_SHORT).show()
            return false
        }
        if (loginViewModel.errorPass.value != "") {
            etPassword.error = loginViewModel.errorPass.value
            flag = false
        }
        return flag
    }

    private fun onTvNotMemberClick(view: View) {
        view.findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
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
        loginViewModel.password.observe(viewLifecycleOwner, androidx.lifecycle.Observer() {
            validatePassword(it)
        })

        loginViewModel.login.observe(viewLifecycleOwner, androidx.lifecycle.Observer() {
            validateEmail(it)
        })
    }
}