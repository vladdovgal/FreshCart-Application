package com.jsp.freshcartshop.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.jsp.freshcartshop.R
import com.jsp.freshcartshop.view.BaseActivity
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : BaseFragment() {

    override fun setFragmentLayout(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        signInButton.setOnClickListener{
            view.findNavController().navigate(R.id.action_loginFragment_to_mainActivity)
        }
        tvNotMember.setOnClickListener{
            view.findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
        }

        (activity as BaseActivity).setToolBarTitle(getString(R.string.login_title))
    }
}