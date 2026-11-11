package com.example.mrm_oreo.Pesan

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mrm_oreo.databinding.ItemHasilBinding


class HasilAdapter (
    private val productList: List<HasilModel>,
    private val onItemClick: (HasilModel) -> Unit
) : RecyclerView.Adapter<HasilAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(val binding: ItemHasilBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ItemHasilBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val item = productList[position]
        with(holder.binding) {
            tvProductName.text = item.name
            tvProductPrice.text = item.price

            Glide.with(holder.itemView.context)
                .load(item.imageUrl)
                .into(holder.binding.imgProduct)

            root.setOnClickListener {
                onItemClick(item)
            }
        }
        Log.e("RV-TEST",item.name)
    }

    override fun getItemCount(): Int = productList.size
}