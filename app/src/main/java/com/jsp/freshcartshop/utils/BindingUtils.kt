package com.jsp.freshcartshop.utils

import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView
import com.jsp.freshcartshop.R

@BindingAdapter("image")
fun loadImage(view: ShapeableImageView, url: String) {
    Glide.with(view)
        .load(url)
        .placeholder(R.drawable.img_placeholder)
        .error(R.drawable.img_error)
        .into(view)
}