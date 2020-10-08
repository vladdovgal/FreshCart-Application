package com.jsp.freshcartshop.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.jsp.freshcartshop.R
import com.jsp.freshcartshop.databinding.ListItemRecyclerCategoryBinding
import com.jsp.freshcartshop.model.Category

class CategoryRecyclerAdapter : BaseRecyclerAdapter<Category, CategoryRecyclerAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CategoryViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.list_item_recycler_category,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.listItemRecyclerCategoryBinding.category = items[position]
    }

    inner class CategoryViewHolder(val listItemRecyclerCategoryBinding: ListItemRecyclerCategoryBinding)
        : RecyclerView.ViewHolder(listItemRecyclerCategoryBinding.root)

}