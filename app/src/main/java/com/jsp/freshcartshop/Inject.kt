package com.jsp.freshcartshop

import com.jsp.freshcartshop.data.db.dao.FreshCartDao
import com.jsp.freshcartshop.data.db.dao.FreshCartDaoFakeImpl
import com.jsp.freshcartshop.data.repository.FreshCartRepository
import com.jsp.freshcartshop.data.repository.FreshCartRepositoryImpl
import com.jsp.freshcartshop.viewmodel.LoginViewModel
import com.jsp.freshcartshop.viewmodel.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule =  module {
    viewModel { LoginViewModel() }
    viewModel { MainViewModel(get()) }
}

val repositoryModule = module {

    single <FreshCartDao> { FreshCartDaoFakeImpl() }
    single <FreshCartRepository> { FreshCartRepositoryImpl(get()) }
}