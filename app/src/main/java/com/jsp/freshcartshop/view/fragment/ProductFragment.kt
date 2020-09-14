package com.jsp.freshcartshop.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jsp.freshcartshop.R
import com.jsp.freshcartshop.view.BaseActivity
import kotlinx.android.synthetic.main.fragment_product.*

class ProductFragment : BaseFragment() {

    override fun setFragmentLayout(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_product, container, false)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val activity = activity as BaseActivity
        activity.setToolBarTitle(getString(R.string.empty_string))
        // todo : fix bug (make toolbar show again after fragment is destroyed)
        activity.supportActionBar?.hide()
        activity.setSupportActionBar(toolbar_product)
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}