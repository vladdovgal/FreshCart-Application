package com.jsp.freshcartshop.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jsp.freshcartshop.R
import com.jsp.freshcartshop.view.BaseActivity
import com.jsp.freshcartshop.viewmodel.ShoppingCartViewModel
import org.koin.android.viewmodel.ext.android.sharedViewModel

class ShoppingCartFragment : BaseFragment<ShoppingCartViewModel>() {

    override val viewModel: ShoppingCartViewModel by sharedViewModel()

    override fun setFragmentLayout(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_shopping_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as BaseActivity).setToolBarTitle(getString(R.string.cart))
    }
}