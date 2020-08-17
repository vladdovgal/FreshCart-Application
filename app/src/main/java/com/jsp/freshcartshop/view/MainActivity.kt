package com.jsp.freshcartshop.view

import android.os.Bundle
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import com.jsp.freshcartshop.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

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