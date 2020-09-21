package com.jsp.freshcartshop.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.jsp.freshcartshop.R
import com.jsp.freshcartshop.databinding.ListItemRecyclerviewProductBinding
import com.jsp.freshcartshop.model.Product

class ProductRecyclerAdapter : BaseRecyclerAdapter<Product, ProductRecyclerAdapter.ProductViewHolder>() {

    var onItemClick : ((Product) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ProductViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.list_item_recyclerview_product,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ProductRecyclerAdapter.ProductViewHolder, position: Int) {
        holder.listItemRecyclerViewProductBinding.product = items[position]
    }

    inner class ProductViewHolder(val listItemRecyclerViewProductBinding: ListItemRecyclerviewProductBinding)
        : RecyclerView.ViewHolder(listItemRecyclerViewProductBinding.root) {
        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(items[adapterPosition])
            }
        }
    }
}


