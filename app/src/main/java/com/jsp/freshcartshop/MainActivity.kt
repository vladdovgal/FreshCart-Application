package com.jsp.freshcartshop

import android.os.Bundle
import android.widget.PopupMenu
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        navMenu.setOnClickListener{
            val popupMenu = PopupMenu(this, navMenu)
            popupMenu.menuInflater.inflate(R.menu.nav_menu, popupMenu.menu)
            popupMenu.show()
        }
    }
}