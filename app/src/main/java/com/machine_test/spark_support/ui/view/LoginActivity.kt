package com.machine_test.spark_support.ui.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

import com.machine_test.spark_support.model.LoginBody
import com.machine_test.spark_support.ui.viewmodel.LoginViewModel
import com.machine_test.spark_support.databinding.ActivityLoginBinding
import com.machine_test.spark_support.ui.viewmodel.ViewModelFactory

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val loginViewModel : LoginViewModel by viewModels {
        ViewModelFactory.getInstance(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

binding.signUp.setOnClickListener {
    val intent = Intent(this, SignUpActivity::class.java)
    startActivity(intent)
}
        binding.loginButton.setOnClickListener {
            val email = binding.usernameEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            when {
                email.isEmpty() -> {
                    binding.usernameEditText.error = "Enter UserName"
                }
                password.isEmpty() -> {
                    binding.passwordEditText.error = "Enter Password"
                }
                else -> {
                    val loginBody = LoginBody(email,password)
                    loginViewModel.Login(loginBody)
                }
            }
        }

    }
}