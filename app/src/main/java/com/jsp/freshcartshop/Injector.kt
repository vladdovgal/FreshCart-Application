package com.jsp.freshcartshop

import androidx.room.Room
import com.jsp.freshcartshop.data.db.FreshCartDatabase
import com.jsp.freshcartshop.data.db.dao.FreshCartDao
import com.jsp.freshcartshop.data.db.dao.UserFirebaseDao
import com.jsp.freshcartshop.data.repository.FreshCartRepositoryImpl
import com.jsp.freshcartshop.viewmodel.LoginViewModel
import com.jsp.freshcartshop.viewmodel.MainViewModel
import com.jsp.freshcartshop.viewmodel.ShoppingCartViewModel
import com.jsp.freshcartshop.viewmodel.SignUpViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule =  module {
    viewModel { LoginViewModel() }
    viewModel { MainViewModel() }
    viewModel { SignUpViewModel() }
    viewModel { ShoppingCartViewModel() }
}

val repositoryModule = module {
    single { Room.databaseBuilder(get(), FreshCartDatabase::class.java, "freshcart.db").fallbackToDestructiveMigration().build() }
    single { get<FreshCartDatabase>().getUserDao() }
    single { FreshCartDao() }
    single { UserFirebaseDao() }
    single { FreshCartRepositoryImpl(get<FreshCartDao>(), get()) }
}