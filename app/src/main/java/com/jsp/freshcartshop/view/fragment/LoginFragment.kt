package com.jsp.freshcartshop.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import com.jsp.freshcartshop.R
import com.jsp.freshcartshop.databinding.FragmentLoginBinding
import com.jsp.freshcartshop.view.BaseActivity
import com.jsp.freshcartshop.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.fragment_login.*
import org.koin.android.ext.android.get

class LoginFragment : BaseFragment<LoginViewModel>() {

    override val viewModel: LoginViewModel = get()
    private lateinit var binding: FragmentLoginBinding

    override fun setFragmentLayout(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        binding.lifecycleOwner = this
        binding.loginViewModel = viewModel

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
        viewModel.checkIfUserExists()

        if (checkForSyntaxWarnings()) {
            if (viewModel.userExists.value == true) {
                    view.findNavController().navigate(R.id.action_loginFragment_to_mainActivity)
                } else {
                Snackbar.make(requireView(), resources.getString(R.string.wrong_login_or_pass), Snackbar.LENGTH_LONG )
                    .show()
                }
            }
        }

        private fun onTvNotMemberClick(view: View) {
            view.findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
        }

        private fun checkForSyntaxWarnings(): Boolean {
            var isLoginFieldsValid = true
            if (viewModel.login.value != null && viewModel.password.value != null) {
                if (viewModel.errorEmail.value != "") {
                    etLogin.error = viewModel.errorEmail.value
                    isLoginFieldsValid = false
                }
            } else {
                Snackbar.make(requireView(), resources.getString(R.string.empty_fields), Snackbar.LENGTH_LONG )
                    .show()
                return false
            }
            if (viewModel.errorPass.value != "") {
                etPassword.error = viewModel.errorPass.value
                isLoginFieldsValid = false
            }
            return isLoginFieldsValid
        }

        private fun observeData() {
            viewModel.password.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
                viewModel.validatePassword(it)
            })

            viewModel.login.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
                viewModel.validateEmail(it)
            })
        }
    }