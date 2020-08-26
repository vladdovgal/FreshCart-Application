package com.jsp.freshcartshop.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

open class BaseActivity : AppCompatActivity() {

    fun setToolBarTitle(title: String) {
        toolbarTitle.text = title
    }
}