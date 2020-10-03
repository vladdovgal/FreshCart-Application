package com.jsp.freshcartshop.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.jsp.freshcartshop.R
import com.jsp.freshcartshop.adapters.ShoppingCartRecyclerAdapter
import com.jsp.freshcartshop.databinding.FragmentShoppingCartBinding
import com.jsp.freshcartshop.view.BaseActivity
import com.jsp.freshcartshop.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_shopping_cart.*
import org.koin.android.viewmodel.ext.android.sharedViewModel

class ShoppingCartFragment : BaseFragment<MainViewModel>() {

    override val viewModel: MainViewModel by sharedViewModel()

    private lateinit var binding : FragmentShoppingCartBinding

    override fun setFragmentLayout(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_shopping_cart, container, false)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shopping_cart, container, false)
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as BaseActivity).setToolBarTitle(getString(R.string.cart))
        observeData()
    }

    private fun observeData() {
        Log.d("myLogs", "Hello from out observe data")
        viewModel.cart.observe(viewLifecycleOwner, Observer { cartItems ->
            shopping_cart.also {
                it.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
                it.adapter = ShoppingCartRecyclerAdapter().also {
                    it.addAll(cartItems)
                }
            }
        })
    }
}