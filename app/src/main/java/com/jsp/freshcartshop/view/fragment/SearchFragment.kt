package com.jsp.freshcartshop.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jsp.freshcartshop.R
import com.jsp.freshcartshop.view.BaseActivity
import com.jsp.freshcartshop.viewmodel.SearchViewModel
import org.koin.android.viewmodel.ext.android.sharedViewModel

class SearchFragment : BaseFragment<SearchViewModel>() {

    override val viewModel: SearchViewModel by sharedViewModel()

    override fun setFragmentLayout(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as BaseActivity).setToolBarTitle(getString(R.string.search))
    }
}