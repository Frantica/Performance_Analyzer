package com.bhavani.performanceanalyzer.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bhavani.performanceanalyzer.common.toast
import com.bhavani.performanceanalyzer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setClickListeners()
    }

    private fun setClickListeners() {
        binding.loginButton.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            //login is successful only if both email and passwords are entered
            when {
                email.isNotEmpty() && password.isNotEmpty() -> {
                    toast("Login successful")
                    DashboardActivity.start(this)
                    finish()
                }

                else -> toast("Invalid credentials")
            }
        }
    }
}