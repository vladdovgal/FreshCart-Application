package com.jsp.freshcartshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.PopupMenu
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var arrowBack: ImageButton
    private lateinit var navMenu: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        arrowBack = findViewById(R.id.arrowBack)
        navMenu = findViewById(R.id.navMenu)

        navMenu.setOnClickListener{
            val popupMenu: PopupMenu = PopupMenu(this, navMenu)
            popupMenu.menuInflater.inflate(R.menu.nav_menu, popupMenu.menu)
            popupMenu.show()
        }
    }
}