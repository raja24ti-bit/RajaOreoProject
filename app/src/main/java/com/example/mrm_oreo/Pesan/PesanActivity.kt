package com.example.mrm_oreo.Pesan

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mrm_oreo.R
import com.example.mrm_oreo.databinding.ActivityPesanBinding
import com.google.android.material.tabs.TabLayoutMediator

class PesanActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPesanBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPesanBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Gadoca Activity"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)

            setHomeAsUpIndicator(R.drawable.ic_back)
        }
        val tabsAdapter = GadocaAdapter(this)

        // 2. Set adapter ke ViewPager2
        binding.viewPager.adapter = tabsAdapter

        // 3. Hubungkan TabLayout & ViewPager2 menggunakan Adapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            // Atur judul untuk setiap tab
            when (position) {
                0 -> {
                    tab.text = "Pesan"
                    //Tambah Icon
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.ic_home)
                    //Tambah Badge Tanpa nomor (hanya titik)
                    val badge = tab.getOrCreateBadge()
                    badge.isVisible = true
                }

                1 -> {
                    tab.text = "Status"
                    //Tambah Icon
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.ic_status)
                    //Tambah Badge dengan nomor
                    val badge = tab.getOrCreateBadge()
                    badge.isVisible = true
                }

                2 -> {
                    tab.text = "Hasil"
                    //Tambah Icon
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.ic_baru)
                    //Tambah Badge dengan nomor
                    val badge = tab.getOrCreateBadge()
                    badge.isVisible = true
                }
            }
        }.attach()
    }
        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            return when (item.itemId) {
                android.R.id.home -> {
                    onBackPressedDispatcher.onBackPressed()
                    true
                }

                else -> super.onOptionsItemSelected(item)
            }
        }
    }