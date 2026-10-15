package com.example.mrm_oreo.Home

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mrm_oreo.MyProject
import com.example.mrm_oreo.R
import com.example.mrm_oreo.databinding.FragmentHomeBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPref = requireContext().getSharedPreferences("user_pref", MODE_PRIVATE)

        binding.btnMasuk.setOnClickListener {
            val i = Intent(requireContext(), MyProject::class.java)
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
                val i = Intent(requireContext(), MyProject::class.java)
                startActivity(i)
                    requireActivity().finish()

            }else{
                MaterialAlertDialogBuilder(requireContext())
                    .setTitle("Opppp")
                    .setMessage("Username Dan Password Salah")
                    .show()
            }
        }

    }
}