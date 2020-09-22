package com.jsp.freshcartshop.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import br.com.ilhasoft.support.validation.Validator
import com.jsp.freshcartshop.R
import com.jsp.freshcartshop.databinding.FragmentSignUpBinding
import com.jsp.freshcartshop.view.BaseActivity
import com.jsp.freshcartshop.viewmodel.SignUpViewModel
import org.koin.android.ext.android.get

class SignUpFragment : BaseFragment() {

    private val signUpViewModel: SignUpViewModel = get()
    private lateinit var binding: FragmentSignUpBinding
    private lateinit var validator: Validator

    override fun setFragmentLayout(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_up, container, false)
        binding.lifecycleOwner = this
        binding.signUpViewModel = signUpViewModel
        validator = Validator(binding)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as BaseActivity).setToolBarTitle(getString(R.string.sign_up))
        init()
    }

    fun init() {
        observeData()

        binding.signUpButton.setOnClickListener{
            if (validator.validate()) {
                signUpViewModel.registerUser()
            }
        }

        binding.tvHaveAccount.setOnClickListener {
            view.findNavController().navigate(R.id.action_signUpFragment_to_loginFragment)
        }
    }

    fun observeData() {
        signUpViewModel.isLoaded.observe(viewLifecycleOwner, Observer { isLoaded ->
            if (isLoaded) {
                findNavController().navigate(R.id.action_signUpFragment_to_loginFragment)
            }
        })
    }

}