package com.jsp.freshcartshop.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.jsp.freshcartshop.databinding.ListItemViewpagerProductBinding
import com.jsp.freshcartshop.model.Product

class ProductPagerAdapter(private val context: Context, private val products: List<Product>) : PagerAdapter() {

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
       return products.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val binding = ListItemViewpagerProductBinding.inflate(LayoutInflater.from(context), container, false)
        binding.product = products[position]
        container.addView(binding.root)

        return binding.root
    }



    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}