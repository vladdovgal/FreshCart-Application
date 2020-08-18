package com.jsp.freshcartshop

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        signInButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        tvNotMember.setOnClickListener{
            val signUpFragment = SignUpFragment()
            openFragment(signUpFragment)
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 0) {
            this.finish()
        } else {
            supportFragmentManager.popBackStack()
        }
    }

    private fun openFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.signIn, fragment)
            .addToBackStack(null)
            .commit()
    }
}