package com.example.mrm_oreo

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mrm_oreo.databinding.ActivityVerifikasiBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class VerifikasiActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVerifikasiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityVerifikasiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnVerifikasi.setOnClickListener {

            val otp = binding.etOtp.text.toString().trim()
            val noHp = intent.getStringExtra("noHp").orEmpty()

            if (otp.isEmpty() || otp != noHp) {

                MaterialAlertDialogBuilder(this)
                    .setTitle("Verifikasi Gagal")
                    .setMessage(
                        "Kode OTP salah atau masih kosong. " +
                                "Masukkan nomor handphone saat registrasi."
                    )
                    .setPositiveButton("OK", null)
                    .show()

                return@setOnClickListener
            }

            val pref = getSharedPreferences(
                "user_pref",
                MODE_PRIVATE
            )

            pref.edit()
                .putString("nama", intent.getStringExtra("nama"))
                .putString("noHp", noHp)
                .putString(
                    "username",
                    intent.getStringExtra("username")
                )
                .putString(
                    "password",
                    intent.getStringExtra("password")
                )
                .apply()

            MaterialAlertDialogBuilder(this)
                .setTitle("Registrasi Berhasil")
                .setMessage("Akun berhasil dibuat. Silakan login.")
                .setPositiveButton("Login") { _, _ ->

                    val loginIntent = Intent(
                        this,
                        MainActivity::class.java
                    )

                    loginIntent.flags =
                        Intent.FLAG_ACTIVITY_CLEAR_TOP or
                                Intent.FLAG_ACTIVITY_SINGLE_TOP

                    startActivity(loginIntent)
                    finish()
                }
                .setCancelable(false)
                .show()
        }
    }
}