package com.jsp.freshcartshop.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.jsp.freshcartshop.R

import com.jsp.freshcartshop.databinding.RecyclerviewProductBinding
import com.jsp.freshcartshop.model.Product

class ProductRecyclerAdapter : BaseRecyclerAdapter<Product, ProductRecyclerAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ProductViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.recyclerview_product,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ProductRecyclerAdapter.ProductViewHolder, position: Int) {
        holder.recyclerViewProductBinding.product = items[position]
    }

    inner class ProductViewHolder(val recyclerViewProductBinding: RecyclerviewProductBinding)
        : RecyclerView.ViewHolder(recyclerViewProductBinding.root)

}


