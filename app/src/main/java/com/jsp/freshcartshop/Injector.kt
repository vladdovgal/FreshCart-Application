package com.jsp.freshcartshop

import com.jsp.freshcartshop.data.db.dao.FreshCartDao
import com.jsp.freshcartshop.data.repository.FreshCartRepositoryImpl
import com.jsp.freshcartshop.viewmodel.*
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule =  module {
    viewModel { LoginViewModel() }
    viewModel { MainViewModel() }
    viewModel { SignUpViewModel() }
    viewModel { ShoppingCartViewModel() }
}

val repositoryModule = module {
    single { FreshCartDao() }
    single { FreshCartRepositoryImpl(get<FreshCartDao>()) }
}