package com.jsp.freshcartshop

import com.jsp.freshcartshop.viewmodel.LoginViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loginModule =  module {
    viewModel { LoginViewModel() }
}