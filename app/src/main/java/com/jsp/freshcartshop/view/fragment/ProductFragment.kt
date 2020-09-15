package com.jsp.freshcartshop.view.fragment

import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jsp.freshcartshop.R
import com.jsp.freshcartshop.view.BaseActivity
import com.jsp.freshcartshop.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_product.*
import org.koin.android.ext.android.get

class ProductFragment : BaseFragment() {

    private val mainViewModel : MainViewModel = get()

    override fun setFragmentLayout(inflater: LayoutInflater,
                                   container: ViewGroup?,
                                   savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_product, container, false)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val activity = activity as BaseActivity
        activity.setToolBarTitle(getString(R.string.empty_string))
        // todo : fix bug (make toolbar show again after fragment is destroyed)
        activity.supportActionBar?.hide()
        activity.setSupportActionBar(toolbar_product)

        return super.onCreateView(inflater, container, savedInstanceState)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewPager()
    }

    private fun initViewPager() {
        tab_layout_product_viewpager.setupWithViewPager(product_view_pager, true)
        // todo implementation of viewPager and viewPagerAdapter
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val params = coordinator_layout.layoutParams as ViewGroup.MarginLayoutParams
        val tv = TypedValue()
        if (requireActivity().theme.resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
            val actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data, resources.displayMetrics)
            params.topMargin = -actionBarHeight
        }
    }
}