package com.example.sih

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import java.util.jar.Attributes.Name

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)

        val ipErr: TextView = findViewById(R.id.ipErr)
        val cnfErr: TextView = findViewById(R.id.cnfErr)
        val name: TextInputEditText = findViewById(R.id.name)
        val phoneInput: TextInputEditText = findViewById(R.id.phoneInput)
        val emailInput: TextInputEditText = findViewById(R.id.emailInput)
        val passwordInput: TextInputEditText = findViewById(R.id.passwordInput)
        val confirmPasswordInput: TextInputEditText = findViewById(R.id.confirmPasswordInput)
        val otpBtn: Button = findViewById(R.id.signUpButton)

        otpBtn.setOnClickListener {
            var isValid = true;
            ipErr.text = "";
            ipErr.visibility = TextView.GONE
            cnfErr.text = "";
            cnfErr.visibility = TextView.GONE
            val fullName = name.text.toString()
            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()
            val confirmPass = confirmPasswordInput.text.toString().trim()

            name.setBackgroundResource(android.R.drawable.edit_text)
            emailInput.setBackgroundResource(android.R.drawable.edit_text)
            passwordInput.setBackgroundResource(android.R.drawable.edit_text)
            confirmPasswordInput.setBackgroundResource(android.R.drawable.edit_text)

            if(fullName.isEmpty()){
                name.setBackgroundColor(Color.RED)
                isValid = false;
            }
            if(phoneInput.toString().isEmpty()){
                phoneInput.setBackgroundColor(Color.RED)
                isValid = false;
            }
            if(email.isEmpty()){
                emailInput.setBackgroundColor(Color.RED)
                isValid = false;
            }
            if(password.isEmpty()){
                passwordInput.setBackgroundColor(Color.RED)
                isValid = false;
            }
            if(confirmPass.isEmpty()){
                confirmPasswordInput.setBackgroundColor(Color.RED)
                isValid = false;
            }
            if(confirmPass != password){
                confirmPasswordInput.setBackgroundColor(Color.RED)
                cnfErr.text = "ConfirmPassword should be same as Password"
                cnfErr.setTextColor(Color.RED)
                cnfErr.visibility = TextView.VISIBLE
                cnfErr.setPadding(16, 8, 16, 8)
            }


            if (!isValid) {
                ipErr.text = "Please provide all necessary details."
                ipErr.setTextColor(Color.RED)
                ipErr.visibility = TextView.VISIBLE
                ipErr.setPadding(16, 8, 16, 8)
                return@setOnClickListener
            }
        }

    }
}