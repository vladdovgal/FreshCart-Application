package com.jsp.freshcartshop.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.jsp.freshcartshop.R
import com.jsp.freshcartshop.databinding.ViewpagerProductBinding
import com.jsp.freshcartshop.model.Product
import kotlinx.android.synthetic.main.viewpager_product.view.*

class ProductPagerAdapter(private val context: Context, private val products: List<Product>) : PagerAdapter() {

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
       return products.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val binding = ViewpagerProductBinding.inflate(LayoutInflater.from(context), container, false)

        val product = products[position]

        binding.tvProductRecommendName.text = product.name
        binding.tvProductRecommendOldPrice.text = "\$"  + product.oldPrice.toString()
        binding.tvProductRecommendPrice.text = "\$"  + product.price.toString()
        binding.imgProductRecommendImage.setImageResource(product.image)

        container.addView(binding.root)

        return binding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}