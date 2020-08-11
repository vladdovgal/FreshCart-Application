package com.jsp.freshcartshop

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // set fonts
        welcomeLogo.typeface = ResourcesCompat.getFont(this, R.font.fortemt)
        val poppinsTypeface = ResourcesCompat.getFont(this, R.font.poppins_medium)
        etUsername.typeface = poppinsTypeface
        inputUsername.typeface = poppinsTypeface
        etPassword.typeface = poppinsTypeface
        inputPassword.typeface = poppinsTypeface

        signInButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

}