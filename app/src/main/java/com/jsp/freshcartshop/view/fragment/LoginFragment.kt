package com.jsp.freshcartshop.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.jsp.freshcartshop.R
import com.jsp.freshcartshop.databinding.FragmentLoginBinding
import com.jsp.freshcartshop.view.BaseActivity
import com.jsp.freshcartshop.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.fragment_login.*
import org.koin.android.ext.android.get

class LoginFragment : BaseFragment() {

    private var loginViewModel: LoginViewModel = get()
    private lateinit var binding : FragmentLoginBinding

    override fun setFragmentLayout(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
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
        if (checkForSyntaxWarnings())  {
            if (loginViewModel.validateInput()) {
                view.findNavController().navigate(R.id.action_loginFragment_to_mainActivity)
            } else Toast.makeText(context, "Wrong login or password", Toast.LENGTH_SHORT).show()
        }
    }

    private fun onTvNotMemberClick(view: View) {
        view.findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
    }

    private fun checkForSyntaxWarnings() : Boolean {
        var flag = true
        if (loginViewModel.login.value != null && loginViewModel.password.value != null) {
            if (loginViewModel.errorEmail.value != "") {
                etLogin.error = loginViewModel.errorEmail.value
                flag = false
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

    private fun observeData() {
        loginViewModel.password.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            loginViewModel.validatePassword(it)
        })

        loginViewModel.login.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            loginViewModel.validateEmail(it)
        })
    }
}