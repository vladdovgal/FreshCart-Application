package com.jsp.freshcartshop.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.jsp.freshcartshop.R
import com.jsp.freshcartshop.adapters.ShoppingCartRecyclerAdapter
import com.jsp.freshcartshop.databinding.FragmentShoppingCartBinding
import com.jsp.freshcartshop.model.CartItem
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
        viewModel.cart.observe(viewLifecycleOwner, Observer { cartItems ->
            shopping_cart.also { recyclerView ->
                recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
                recyclerView.adapter = ShoppingCartRecyclerAdapter().also {
                    it.addAll(cartItems)
                }
            }
            // Calculate total cart price
            val total: Int = getTotalCost(cartItems)
            // Update TextViews
            updateTotalPrice(total)
            // Check if cart is not empty
            showPlaceHolderHintIfCartIsEmpty()
        })
    }

    /**
     * Calculates total cost of the goods
     * @param cartItems - list of items in the shopping cart
     */
    private fun getTotalCost(cartItems: MutableList<CartItem>): Int {
        return cartItems.map {
            it.product.price * it.quantity
        }.sum()
    }

    /**
     * Sets appropriate values for total price views.
     * @param total - total sum by products in the shopping cart.
     */
    private fun updateTotalPrice(total: Int) {
        total_value.text = getString(R.string.price_template, total.toFloat())
        sub_total_value.text = getString(R.string.price_template, total.toFloat() + 5.00)
        delivery_charge.text = getString(R.string.price_template, 5.toFloat())
    }

    /**
     * If shopping cart is empty, user will see the hint.
     */
    private fun showPlaceHolderHintIfCartIsEmpty() {
        val isCartNotEmpty = viewModel.cart.value!!.size > 0
        if (isCartNotEmpty) {
            total_bill_card.visibility = View.VISIBLE
            empty_cart_tip.visibility = View.GONE
        } else {
            total_bill_card.visibility = View.GONE
            empty_cart_tip.visibility = View.VISIBLE
        }
    }
}