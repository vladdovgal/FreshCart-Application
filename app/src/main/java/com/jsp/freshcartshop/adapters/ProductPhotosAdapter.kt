package com.jsp.freshcartshop.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.jsp.freshcartshop.databinding.PhotoItemViewpagerProductBinding

class ProductPhotosAdapter(private val context : Context, private val images : List<String>) : PagerAdapter() {

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return images.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val binding = PhotoItemViewpagerProductBinding.inflate(LayoutInflater.from(context), container, false)
        binding.image = images[position]
        container.addView(binding.root)

        return binding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}