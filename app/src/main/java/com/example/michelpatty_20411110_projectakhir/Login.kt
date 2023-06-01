package com.example.michelpatty_20411110_projectakhir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.michelpatty_20411110_projectakhir.databinding.ActivityLoginBinding
//import com.example.michelpatty_20411110_projectakhir.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.btnLogin.setOnClickListener {
            val email : String = binding.loginEmail.text.toString().trim()
            val password : String = binding.loginPassword.text.toString().trim()

            if(email.isEmpty()) {
                binding.loginEmail.error = "Masukkan Email"
                binding.loginEmail.requestFocus()
                return@setOnClickListener
            }

            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.loginEmail.error = "Email Salah"
                binding.loginEmail.requestFocus()
                return@setOnClickListener
            }

            if(password.isEmpty() || password.length < 6) {
                binding.loginPassword.error = "password harus lebih dari 6 karakter"
                binding.loginPassword.requestFocus()
                return@setOnClickListener
            }
            loginUser(email,password)
        }

        binding.textRegister.setOnClickListener {
            startActivity(Intent(this, Register::class.java))
        }

        binding.lupaPass.setOnClickListener {
            Intent(this, ResetPassword::class.java).also {
                startActivity(it)
            }
        }
    }
    private fun loginUser(email: String, password: String) {
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                Intent(this, MainActivity::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }
            }
            else {
                Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}