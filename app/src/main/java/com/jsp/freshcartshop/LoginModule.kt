package com.jsp.freshcartshop

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loginModule =  module {
    viewModel { LoginViewModel() }
}