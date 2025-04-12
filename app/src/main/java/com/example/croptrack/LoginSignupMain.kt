package com.example.croptrack

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.croptrack.R

class LoginSignupMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_signup_main)

        val login: TextView = findViewById(R.id.login)
        val signup: TextView = findViewById(R.id.signup)

        login.text = getString(R.string.Login)
        signup.text = getString(R.string.Signup)

        var select = login
        loadFragment(Login())

        login.setOnClickListener {
            if (select != login) {
                login.setTextColor(Color.parseColor("#ffffff"))
                login.background = ContextCompat.getDrawable(this, R.drawable.colorbg)
                signup.setTextColor(Color.parseColor("#888888"))
                signup.background = null
                select = login
                loadFragment(Login())
            }
        }

        signup.setOnClickListener {
            if (select != signup) {
                login.setTextColor(Color.parseColor("#888888"))
                login.background = null
                signup.setTextColor(Color.parseColor("#ffffff"))
                signup.background = ContextCompat.getDrawable(this, R.drawable.colorbg)
                select = signup
                loadFragment(Signup())
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.loginSignup, fragment)
            .commit()
    }
}