package com.example.tugasuts

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etUsername: EditText
    private lateinit var etEmail: EditText
    private lateinit var etNamaDepan: EditText
    private lateinit var etNamaBelakang: EditText
    private lateinit var etPassword: EditText
    private lateinit var etConfirmPassword: EditText
    private lateinit var btnKirim: Button
    private lateinit var btnBatal: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Pastikan file layout berada di res/layout/activity_main.xml
        setContentView(R.layout.activity_main)

        // bind views
        etUsername = findViewById(R.id.editUsername)
        etEmail = findViewById(R.id.editEmail)
        etNamaDepan = findViewById(R.id.editFirstName)
        etNamaBelakang = findViewById(R.id.editFirstName)
        etPassword = findViewById(R.id.editConfirmPassword)
        etConfirmPassword = findViewById(R.id.editConfirmPassword)
        btnKirim = findViewById(R.id.btnSubmit)   // pada layout btnCancel bertuliskan "Kirim"
        btnBatal = findViewById(R.id.btnCancel)   // pada layout btnSubmit bertuliskan "Batal"

        btnKirim.setOnClickListener {
            submitForm()
        }

        btnBatal.setOnClickListener {
            clearFields()
            Toast.makeText(this, "Form dibersihkan", Toast.LENGTH_SHORT).show()
        }
    }

    private fun submitForm() {
        // Ambil value
        val username = etUsername.text.toString().trim()
        val email = etEmail.text.toString().trim()
        val namaDepan = etNamaDepan.text.toString().trim()
        val namaBelakang = etNamaBelakang.text.toString().trim()
        val password = etPassword.text.toString()
        val confirmPassword = etConfirmPassword.text.toString()

        // Reset error sebelumnya
        etUsername.error = null
        etEmail.error = null
        etNamaDepan.error = null
        etNamaBelakang.error = null
        etPassword.error = null
        etConfirmPassword.error = null

        // Validasi sederhana
        when {
            username.isEmpty() -> {
                etUsername.requestFocus()
                showShort("Isi username terlebih dahulu")
            }
            email.isEmpty() -> {
                etEmail.requestFocus()
                showShort("Isi email terlebih dahulu")
            }
            namaDepan.isEmpty() -> {

                etNamaDepan.requestFocus()
                showShort("Isi nama depan terlebih dahulu")
            }
            namaBelakang.isEmpty() -> {

                etNamaBelakang.requestFocus()
                showShort("Isi nama belakang terlebih dahulu")
            }
            password.isEmpty() -> {

                etPassword.requestFocus()
                showShort("Isi password terlebih dahulu")
            }
            confirmPassword.isEmpty() -> {

                etConfirmPassword.requestFocus()
                showShort("Konfirmasi password terlebih dahulu")
            }
            password != confirmPassword -> {
                // Password tidak sama
                etPassword.error = "Password berbeda"
                etConfirmPassword.error = "Password berbeda"
                etConfirmPassword.requestFocus()
                showShort("Password tidak sama")
            }
            else -> {
                // Sukses - buat user (simulasi)
                val namaUser = "$namaDepan $namaBelakang"
                Toast.makeText(this, "User $namaUser berhasil dibuat.", Toast.LENGTH_LONG).show()
                // Jika ingin reset form setelah sukses, aktifkan baris ini:
                // clearFields()
            }
        }
    }

    private fun clearFields() {
        etUsername.text.clear()
        etEmail.text.clear()
        etNamaDepan.text.clear()
        etNamaBelakang.text.clear()
        etPassword.text.clear()
        etConfirmPassword.text.clear()
    }

    private fun showShort(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}