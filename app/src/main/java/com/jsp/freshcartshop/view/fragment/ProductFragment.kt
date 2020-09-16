package com.jsp.freshcartshop.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.jsp.freshcartshop.R
import com.jsp.freshcartshop.databinding.FragmentProductBinding
import com.jsp.freshcartshop.view.MainActivity
import com.jsp.freshcartshop.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.get

class ProductFragment : BaseFragment() {
    private var isToolbarBackgroundWhite = false

    private val mainViewModel : MainViewModel = get()
    private lateinit var binding : FragmentProductBinding

    override fun setFragmentLayout(inflater: LayoutInflater,
                                   container: ViewGroup?,
                                   savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_product, container, false)
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_product, container, false)
        binding.lifecycleOwner = this

        // change toolbar background color
        switchToolbarBackgroundColor()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewPager()
    }

    private fun initViewPager() {
//        tab_layout_product_viewpager.setupWithViewPager(product_view_pager, true)
//        mainViewModel.product.observe(viewLifecycleOwner, Observer { product ->
//            binding.productViewPager.adapter = ProductAdapter(requireContext(), product)
//        })
        // todo implementation of viewPager and viewPagerAdapter
    }

    override fun onStop() {
        super.onStop()
        // switch back silver as Toolbar background color
        switchToolbarBackgroundColor()
    }


    private fun switchToolbarBackgroundColor() {
        if (!isToolbarBackgroundWhite) {
            context?.let { ContextCompat.getColor(it, R.color.colorWhite) }?.let {
                (activity as MainActivity).toolbar_wrapper.setCardBackgroundColor(
                    it
                )
            }
        } else {
            context?.let { ContextCompat.getColor(it, R.color.colorBackground) }?.let {
                (activity as MainActivity).toolbar_wrapper.setCardBackgroundColor(
                    it
                )
            }
        }
        isToolbarBackgroundWhite = !isToolbarBackgroundWhite
    }

}