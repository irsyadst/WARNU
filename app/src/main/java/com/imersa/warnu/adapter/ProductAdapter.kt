package com.imersa.warnu.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.imersa.warnu.databinding.ItemProductDashboardBinding
import com.imersa.warnu.model.Product

class ProdukAdapter(private val produkList: List<Product>) :
    RecyclerView.Adapter<ProdukAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemProductDashboardBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemProductDashboardBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produk = produkList[position]
        holder.binding.tvProductName.text = produk.nama
        Glide.with(holder.itemView.context)
            .load(produk.gambarUrl)
            .into(holder.binding.ivProduct)
    }

    override fun getItemCount(): Int = produkList.size
}
