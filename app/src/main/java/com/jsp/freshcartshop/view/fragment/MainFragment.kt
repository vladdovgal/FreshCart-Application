package com.jsp.freshcartshop.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.jsp.freshcartshop.R
import com.jsp.freshcartshop.adapters.ProductRecyclerAdapter
import com.jsp.freshcartshop.adapters.ProductPagerAdapter
import com.jsp.freshcartshop.databinding.FragmentMainBinding
import com.jsp.freshcartshop.view.MainActivity
import com.jsp.freshcartshop.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_main.*
import org.koin.android.ext.android.get

class MainFragment : BaseFragment() {

    private val mainViewModel: MainViewModel = get()
    private lateinit var productPagerAdapter: ProductPagerAdapter
    private lateinit var productRecyclerAdapter: ProductRecyclerAdapter
    private lateinit var binding: FragmentMainBinding

    override fun setFragmentLayout(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).setToolBarTitle(getString(R.string.toolbar_title))
        tabDots.setupWithViewPager(vpMainProducts, true)
        mainViewModel.getProducts()
        mainViewModel.products.observe(viewLifecycleOwner, Observer { products ->
            binding.vpMainProducts.adapter = ProductPagerAdapter(requireContext(), products)
         })


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mainViewModel.getProducts()
        mainViewModel.products.observe(viewLifecycleOwner, Observer { products ->
            rvMainProducts.also {
                it.layoutManager = GridLayoutManager(activity, 3)
                it.adapter = ProductRecyclerAdapter().also { it.addAll(products) }
            }
        })
    }

}