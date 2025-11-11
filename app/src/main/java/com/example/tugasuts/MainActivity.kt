package com.example.tugasuts

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val inputUsername = findViewById<EditText>(R.id.editTextUsername)
        val inputEmail = findViewById<EditText>(R.id.editEmail)
        val inputNamaDepan = findViewById<EditText>(R.id.editLastName)
        val inputNamaBelakang = findViewById<EditText>(R.id.editLastName)
        val inputPassword = findViewById<EditText>(R.id.editTextPassword)
        val inputKetikUlangPassword = findViewById<EditText>(R.id.editTextUlangPassword)

        val buttonSubmit = findViewById<Button>(R.id.buttonSubmit)

        buttonSubmit.setOnClickListener {
            var username = inputUsername.text.toString()
            var email = inputEmail.text.toString()
            var namadepan = inputNamaDepan.text.toString()
            var namabelakang = inputNamaBelakang.text.toString()
            var password = inputPassword.text.toString()
            var ulangipassword = inputKetikUlangPassword.text.toString()

            if (username.isEmpty() || email.isEmpty() || namadepan.isEmpty() || namabelakang.isEmpty() || password.isEmpty() || ulangipassword.isEmpty()) {
                Toast.makeText(
                    this, "Username / Password tidak boleh kosong",
                    Toast.LENGTH_LONG
                )
                    .show()


                if (password != ulangipassword) {
                    Toast.makeText(
                        this, "Password dan ulangi password harus sama!",
                        Toast.LENGTH_LONG
                    )
                        .show()

                    val fullName = "$namadepan $namabelakang"
                    Toast.makeText(
                        this,
                        "Berhasil mendaftar! Selamat datang, $fullName",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            }
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }
    }
}
