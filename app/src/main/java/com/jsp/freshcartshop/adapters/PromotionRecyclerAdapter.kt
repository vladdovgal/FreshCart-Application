package com.jsp.freshcartshop.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.jsp.freshcartshop.R
import com.jsp.freshcartshop.databinding.ListItemRecyclerCategoryBinding
import com.jsp.freshcartshop.databinding.ListItemRecyclerPromotionBinding
import com.jsp.freshcartshop.model.Promotion

class PromotionRecyclerAdapter : BaseRecyclerAdapter<Promotion, PromotionRecyclerAdapter.PromotionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        PromotionViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.list_item_recycler_promotion,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: PromotionViewHolder, position: Int) {
        holder.listItemRecyclerPromotionBinding.promotion = items[position]
    }

    inner class PromotionViewHolder(val listItemRecyclerPromotionBinding: ListItemRecyclerPromotionBinding)
        : RecyclerView.ViewHolder(listItemRecyclerPromotionBinding.root)

}