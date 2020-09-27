package com.jsp.freshcartshop

import androidx.room.Room
import com.jsp.freshcartshop.data.db.FreshCartDatabase
import com.jsp.freshcartshop.data.db.dao.FreshCartDao
import com.jsp.freshcartshop.data.repository.FreshCartRepositoryImpl
import com.jsp.freshcartshop.viewmodel.*
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule =  module {
    viewModel { LoginViewModel() }
    viewModel { MainViewModel() }
    viewModel { SignUpViewModel() }
    viewModel { SearchViewModel() }
    viewModel { ShoppingCartViewModel() }
}

val repositoryModule = module {
    single { Room.databaseBuilder(get(), FreshCartDatabase::class.java, "freshcart.db").build() }
    single { get<FreshCartDatabase>().getUserDao() }
    single { FreshCartDao() }
    single { FreshCartRepositoryImpl(get<FreshCartDao>(), get()) }
}