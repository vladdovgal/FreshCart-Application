package com.jsp.freshcartshop

import com.jsp.freshcartshop.data.db.LoginDaoFakeImpl
import com.jsp.freshcartshop.data.repository.LoginRepositoryImpl
import com.jsp.freshcartshop.viewmodel.LoginViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loginViewModelModule =  module {
    viewModel { LoginViewModel(get()) }
}

val repositoryModule = module {
//    fun provideRepository(api : LoginDao) : LoginRepositoryImpl {
//        return LoginRepositoryImpl(api)
//    }

    single { LoginRepositoryImpl(LoginDaoFakeImpl()) }
}