package com.jsp.freshcartshop.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.jsp.freshcartshop.R
import com.jsp.freshcartshop.adapters.CategoryRecyclerAdapter
import com.jsp.freshcartshop.adapters.ProductRecyclerAdapter
import com.jsp.freshcartshop.adapters.PromotionRecyclerAdapter
import com.jsp.freshcartshop.databinding.FragmentSearchBinding
import com.jsp.freshcartshop.view.BaseActivity
import com.jsp.freshcartshop.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_search.*
import org.koin.android.viewmodel.ext.android.sharedViewModel

class SearchFragment : BaseFragment<MainViewModel>() {

    override val viewModel: MainViewModel by sharedViewModel()
    private lateinit var binding: FragmentSearchBinding

    override fun setFragmentLayout(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false)
        binding.lifecycleOwner = this
        binding.searchviewmodel = viewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as BaseActivity).setToolBarTitle(getString(R.string.search))
        init()
    }

    private fun init() {
        observeData()
        initListeners()
    }

    private fun initListeners() {
        inputSearch.setStartIconOnClickListener{
            if (binding.etSearch.text.toString() != "") {
                viewModel.findProducts()
                setSearchValue(viewModel.searchValue.value!!)
            }
        }

        binding.etSearch.setOnEditorActionListener{ _, actionId, _ ->
            if(actionId == EditorInfo.IME_ACTION_SEARCH){
                viewModel.findProducts()
                setSearchValue(viewModel.searchValue.value!!)
                true
            } else {
                false
            }}
    }

    private fun observeData() {
        viewModel.loadCategories()
        viewModel.loadSearchPromotions()

        viewModel.filteredProductList.observe(viewLifecycleOwner, Observer { products ->
            rvSearchProducts.also {
                it.layoutManager = GridLayoutManager(activity, 3)
                it.adapter = ProductRecyclerAdapter().also { it.addAll(products) }
                (it.adapter as ProductRecyclerAdapter).onItemClick = { product ->
                    val action = SearchFragmentDirections.actionSearchFragmentToProductFragment(product.id)
                    findNavController().navigate(action)
                }
            }
            if (products.isEmpty()) {
                tvNothingFound.visibility = View.VISIBLE
                setSearchValue(viewModel.searchValue.value!!)
            } else {
                tvNothingFound.visibility = View.GONE
            }
        })

        viewModel.categoryList.observe(viewLifecycleOwner, Observer { categories ->
            rvCategories.also {
                it.layoutManager = GridLayoutManager(activity, 3)
                it.adapter = CategoryRecyclerAdapter().also { it.addAll(categories) }
            }
        })

        viewModel.searchPromotionList.observe(viewLifecycleOwner, Observer { promotions ->
            rvSearchPromotions.also {
                it.layoutManager = LinearLayoutManager(activity)
                it.adapter = PromotionRecyclerAdapter().also { it.addAll(promotions) }
            }
        })
    }

    private fun setSearchValue(value: String) {
        binding.tvNothingFound.text = resources.getString(R.string.nothing_found, value)
    }
}