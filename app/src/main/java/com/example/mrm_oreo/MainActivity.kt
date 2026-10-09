package com.example.mrm_oreo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mrm_oreo.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)

        binding.btnMasuk.setOnClickListener {
            val i = Intent(this, MyProject::class.java)
            startActivity(i)
        }
        binding.btnMasuk.setOnClickListener {
            val username = binding.idNama.text.toString()
            val password = binding.Password.text.toString()

            val editor = sharedPref.edit()
            editor.putBoolean("isLogin", true)
            editor.putString("username",username)
            editor.apply()

            if (username == password){
                val i = Intent(this, MyProject::class.java)
                startActivity(i)
                finish()

            }else{
                MaterialAlertDialogBuilder(this)
                    .setTitle("Opppp")
                    .setMessage("Username Dan Password Salah")
                    .show()
            }
        }
    }
}
