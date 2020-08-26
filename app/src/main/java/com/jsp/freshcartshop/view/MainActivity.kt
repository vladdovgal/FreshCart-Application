package com.jsp.freshcartshop.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.PopupMenu
import androidx.navigation.findNavController
import com.jsp.freshcartshop.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        init()
    }

    private fun init() {
        initListeners()
    }

    private fun initListeners() {
        arrowBack.setOnClickListener {
            findNavController(R.id.mainActivityHost).popBackStack()
        }

        navMenu.setOnClickListener {
            showNavMenu()
        }

        homeNavButton.setOnClickListener {
            findNavController(R.id.mainActivityHost).navigate(R.id.mainFragment)
        }

        searchButton.setOnClickListener {
            findNavController(R.id.mainActivityHost).navigate(R.id.searchFragment)
        }

        cartNavButton.setOnClickListener {
            findNavController(R.id.mainActivityHost).navigate(R.id.shoppingCartFragment)
        }
    }

    private fun showNavMenu() {
        val popupMenu = PopupMenu(this, navMenu)
        popupMenu.menuInflater.inflate(R.menu.nav_menu, popupMenu.menu)
        popupMenu.show()
    }
}