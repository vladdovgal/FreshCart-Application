package com.jsp.freshcartshop

import com.jsp.freshcartshop.adapters.ProductPagerAdapter
import com.jsp.freshcartshop.data.db.dao.ProductDao
import com.jsp.freshcartshop.data.db.dao.impl.ProductDaoFakeImpl
import com.jsp.freshcartshop.repository.ProductRepository
import com.jsp.freshcartshop.repository.impl.ProductRepositoryImpl
import com.jsp.freshcartshop.viewmodel.LoginViewModel
import com.jsp.freshcartshop.viewmodel.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loginModule =  module {
    viewModel { LoginViewModel() }
}

val mainModule = module {
    viewModel { MainViewModel(get()) }

    single <ProductDao> { ProductDaoFakeImpl() }
    single <ProductRepository> { ProductRepositoryImpl(get()) }
}