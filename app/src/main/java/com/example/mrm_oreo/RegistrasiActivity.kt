package com.example.mrm_oreo

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mrm_oreo.databinding.ActivityRegistrasiBinding
import kotlin.jvm.java

class RegistrasiActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegistrasiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRegistrasiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.button.setOnClickListener {
            val nama = binding.nama.text.toString().trim()
            val noHp = binding.noHp.text.toString().trim()
            val username = binding.username.text.toString().trim()
            val password = binding.password.text.toString()

            if (nama.isEmpty() || noHp.isEmpty() ||
                username.isEmpty() || password.isEmpty()
            ) {
                Toast.makeText(
                    this,
                    "Semua kolom wajib diisi",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            if (noHp.length < 8) {
                binding.noHp.error =
                    "Nomor handphone minimal 8 angka"
                return@setOnClickListener
            }

            val intent = Intent(
                this,
                VerifikasiActivity::class.java
            )

            intent.putExtra("nama", nama)
            intent.putExtra("noHp", noHp)
            intent.putExtra("username", username)
            intent.putExtra("password", password)

            startActivity(intent)
        }

        binding.tvKembaliLogin.setOnClickListener {
            finish()
        }
    }
}