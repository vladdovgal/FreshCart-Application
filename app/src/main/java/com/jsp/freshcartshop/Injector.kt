package com.jsp.freshcartshop

import com.jsp.freshcartshop.data.db.FreshCartDao
import com.jsp.freshcartshop.data.repository.FreshCartRepositoryImpl
import com.jsp.freshcartshop.viewmodel.LoginViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule =  module {
    viewModel { LoginViewModel() }
}

val repositoryModule = module {
    single { FreshCartDao() }
    single { FreshCartRepositoryImpl(get<FreshCartDao>()) }
}