package com.example.mrm_oreo.Pesan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mrm_oreo.R
import com.example.mrm_oreo.databinding.FragmentHasilBinding

class HasilFragment : Fragment() {
    private var _binding: FragmentHasilBinding? = null
    private val binding get() = _binding!!

    private val productList = listOf(
        HasilModel(
            "Ayam Geprek",
            "Rp 15.000",
            R.drawable.menugadoca1
        ),
        HasilModel(
            "Ayam Rica Rica",
            "Rp 18.000",
            R.drawable.menugadoca2
        ),
        HasilModel(
            "Pisang Keju Karamel",
            "Rp 15.000",
            R.drawable.menugadoca3
        ),
        HasilModel(
            "Mix Platter",
            "Rp 14.000",
            R.drawable.menugadoca4
        ),
        HasilModel(
            "Butterscotch",
            "Rp 20.000",
            R.drawable.menugadoca5
        ),
        HasilModel(
            "Vanila Oreo",
            "Rp 12.000",
            R.drawable.menugadoca6
        ),
        HasilModel(
            "Nasi Talua Barendo",
            "Rp 13.000",
            R.drawable.menugadoca7
        ),
        HasilModel(
            "Risol Mayo",
            "Rp 10.000",
            R.drawable.menugadoca8
        ),
        HasilModel(
            "Enoki Jamur Krispy",
            "Rp 13.000",
            R.drawable.menugadoca9
        ),
        HasilModel(
            "Nugget Kanzler",
            "Rp 15.000",
            R.drawable.menugadoca10
        )
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHasilBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = HasilAdapter(productList) { selectedItem ->
            Toast.makeText(
                requireContext(),
                "Anda memilih ${selectedItem.name}",
                Toast.LENGTH_SHORT
            ).show()
        }
        binding.rvProducts.apply {
            /** Mode Grid **/
            layoutManager = GridLayoutManager(requireContext(), 2)

            /** Jika ingin model Linear **/
            //layoutManager = LinearLayoutManager(requireContext())

            this.adapter = adapter
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}