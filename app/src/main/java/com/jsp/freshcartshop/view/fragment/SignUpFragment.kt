package com.jsp.freshcartshop.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import br.com.ilhasoft.support.validation.Validator
import com.jsp.freshcartshop.R
import com.jsp.freshcartshop.databinding.FragmentSignUpBinding
import com.jsp.freshcartshop.view.BaseActivity
import com.jsp.freshcartshop.viewmodel.SignUpViewModel
import kotlinx.android.synthetic.main.fragment_sign_up.*
import org.koin.android.viewmodel.ext.android.sharedViewModel

class SignUpFragment : BaseFragment<SignUpViewModel>() {

    override val viewModel: SignUpViewModel by sharedViewModel()

    private lateinit var binding: FragmentSignUpBinding
    private lateinit var validator: Validator

    override fun setFragmentLayout(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_up, container, false)
        binding.lifecycleOwner = this
        binding.signUpViewModel = viewModel
        validator = Validator(binding)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as BaseActivity).setToolBarTitle(getString(R.string.sign_up))
        init()
    }

    private fun init() {
        observeData()

        binding.signUpButton.setOnClickListener{
            if (validator.validate()) {
                viewModel.registerUser()
            }
        }

        binding.tvHaveAccount.setOnClickListener {
            findNavController().navigate(R.id.action_signUpFragment_to_loginFragment)
        }
    }

    private fun observeData() {
        viewModel.isLoaded.observe(viewLifecycleOwner, Observer { isLoaded ->
            if (isLoaded) {
                findNavController().navigate(R.id.action_signUpFragment_to_loginFragment)
                clearInputs()
                viewModel.isLoaded.postValue(false)
            }
        })
    }

    private fun clearInputs() {
        etFullName.text?.clear()
        etEmail.text?.clear()
        etPassword.text?.clear()
    }
}