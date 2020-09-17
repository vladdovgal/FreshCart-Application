package com.jsp.freshcartshop.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.jsp.freshcartshop.model.Product

class ProductPhotosAdapter(private val context : Context, private val product : Product) : PagerAdapter() {

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return product.images.size
    }

//    override fun instantiateItem(container: ViewGroup, position: Int): Any {
//
//    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}