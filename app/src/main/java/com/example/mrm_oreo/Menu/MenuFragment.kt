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
        MessageModel("Pisang Keju Karamel", "Manisnya pas!", R.drawable.menugadoca3),
        MessageModel("Mix Platter", "Cocok buat sharing!", R.drawable.menugadoca4),
        MessageModel("Butterscotch", "Creamy dan bikin nagih!", R.drawable.menugadoca5),
        MessageModel("Vanila Oreo", "Manisnya bikin happy!", R.drawable.menugadoca6),
        MessageModel("Nasi Talua Barendo", "Gurihnya bikin ketagihan!", R.drawable.menugadoca7),
        MessageModel("Risol Mayo", "Lumer di mulut!", R.drawable.menugadoca8),
        MessageModel("Enoki Jamur Krispy", "Renyah di setiap gigitan!", R.drawable.menugadoca9),
        MessageModel("Nugget Kanzler", "Enak buat teman santai!", R.drawable.menugadoca10)
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