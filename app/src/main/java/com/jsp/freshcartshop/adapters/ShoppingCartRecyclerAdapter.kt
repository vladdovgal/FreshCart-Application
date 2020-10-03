package com.jsp.freshcartshop.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.jsp.freshcartshop.R
import com.jsp.freshcartshop.databinding.ListItemShoppingCartBinding
import com.jsp.freshcartshop.model.CartItem

class ShoppingCartRecyclerAdapter : BaseRecyclerAdapter<CartItem, ShoppingCartRecyclerAdapter.CartItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CartItemViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.list_item_shopping_cart,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: CartItemViewHolder, position: Int) {
        holder.listItemRecyclerViewShoppingCartBinding.cartItem = items[position]
        Log.d("myLogs", "Cart first elem : ${items[0].product.name}")
    }

    inner class CartItemViewHolder(val listItemRecyclerViewShoppingCartBinding : ListItemShoppingCartBinding) :
     RecyclerView.ViewHolder(listItemRecyclerViewShoppingCartBinding.root)
}