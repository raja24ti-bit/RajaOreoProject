package com.example.mrm_oreo.Menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.mrm_oreo.R
import com.example.mrm_oreo.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {
    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!

    private val messageList = listOf(
        MessageModel("Ayam Geprek", "Pedasnya mantap!", R.drawable.menugadoca1),
        MessageModel("Ayam Rica Rica", "Favorit banget!", R.drawable.menugadoca2),
        MessageModel("Nasi Talua Bardendo", "Wajib dicoba!", R.drawable.menugadoca3),
        MessageModel("Mie Goreng Gadoca", "Enak dan gurih!", R.drawable.menugadoca4),
        MessageModel("Cireng Gadoca", "Camilan favorit!", R.drawable.menugadoca4),
        MessageModel("Pisang Keju Karamel", "Manisnya pas!", R.drawable.menugadoca5),
        MessageModel("Gentang Goreng", "Renyah banget!", R.drawable.menugadoca6),
        MessageModel("Risol Coklat Keju", "Lumer di mulut!", R.drawable.menugadoca7),
        MessageModel("Risol Mayo", "Creamy dan lezat!", R.drawable.menugadoca8),
        MessageModel("Mix Platter", "Cocok buat sharing!", R.drawable.oreo)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Menu Makanan Gadoca"
        }
        val adapter = MessageAdapter(requireContext(), messageList)
        binding.listMessageItems.adapter = adapter
    }
}