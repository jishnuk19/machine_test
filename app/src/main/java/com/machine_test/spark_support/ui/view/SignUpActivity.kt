package com.machine_test.spark_support.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.machine_test.spark_support.databinding.ActivitySignUpBinding
import com.machine_test.spark_support.model.SignUpBody
import com.machine_test.spark_support.ui.viewmodel.SignUpViewModel
import com.machine_test.spark_support.ui.viewmodel.ViewModelFactory

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private val signUpViewModel: SignUpViewModel by viewModels {
        ViewModelFactory.getInstance(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        signUpViewModel.toastMessage.observe(this) { message ->
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }

        binding.signUpButton.setOnClickListener {
            val userName = binding.usernameEditText.text.toString()
            val email = binding.emailEditText.text.toString()
            val firstName = binding.firstNameEditText.text.toString()
            val lastName = binding.lastNameEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            val password1 = binding.passwordEditText1.text.toString()

            // Verify if the passwords match
            if (password != password1) {
                binding.passwordEditText.error = "Passwords do not match"
                binding.passwordEditText1.error = "Passwords do not match"
            } else {
                // Passwords match, proceed with sign-up
                when {
                    userName.isEmpty() -> {
                        binding.usernameEditText.error = "Enter userName"
                    }
                    email.isEmpty() -> {
                        binding.emailEditText.error = "Enter email"
                    }
                    firstName.isEmpty() -> {
                        binding.firstNameEditText.error = "Enter firstName"
                    }
                    lastName.isEmpty() -> {
                        binding.lastNameEditText.error = "Enter lastName"
                    }
                    password.isEmpty() -> {
                        binding.passwordEditText.error = "Enter Password"
                    }
                    else -> {
                        val signUpBody = SignUpBody(userName, email, firstName, lastName, password, password1)
                        signUpViewModel.signUp(signUpBody)
                    }
                }
            }
        }
    }
}
