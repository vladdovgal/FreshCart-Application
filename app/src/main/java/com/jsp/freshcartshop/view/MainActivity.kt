package com.jsp.freshcartshop.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.PopupMenu
import androidx.navigation.findNavController
import com.jsp.freshcartshop.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        arrowBack.setOnClickListener(this)
        navMenu.setOnClickListener(this)
        homeNavButton.setOnClickListener(this)
        searchButton.setOnClickListener(this)
        cartNavButton.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.arrowBack -> findNavController(R.id.mainActivityHost).popBackStack()
            R.id.navMenu -> showNavMenu()
            R.id.homeNavButton -> findNavController(R.id.mainActivityHost).navigate(R.id.mainFragment)
            R.id.searchButton -> findNavController(R.id.mainActivityHost).navigate(R.id.searchFragment)
            R.id.cartNavButton -> findNavController(R.id.mainActivityHost).navigate(R.id.shoppingCartFragment)
            else -> {}
        }
    }

    fun setToolBarTitle(title: String) {
        toolbarTitle.text = title
    }

    private fun showNavMenu() {
        val popupMenu = PopupMenu(this, navMenu)
        popupMenu.menuInflater.inflate(R.menu.nav_menu, popupMenu.menu)
        popupMenu.show()
    }
}