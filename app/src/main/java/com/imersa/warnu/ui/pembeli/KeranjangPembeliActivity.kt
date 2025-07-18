package com.imersa.warnu.ui.pembeli // Pastikan nama paket ini sesuai dengan lokasi file Anda

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.imersa.warnu.R

// Data class sederhana untuk menampung data item di keranjang
data class KeranjangItem(val id: String)

class KeranjangPembeliActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_keranjang_pembeli)

        val rvKeranjang: RecyclerView = findViewById(R.id.rvKeranjang)

        // Buat data dummy untuk ditampilkan
        val keranjangList = listOf(
            KeranjangItem("1"), KeranjangItem("2"), KeranjangItem("3"), KeranjangItem("4"),
            KeranjangItem("5"), KeranjangItem("6"), KeranjangItem("7"), KeranjangItem("8")
        )

        // Set adapter ke RecyclerView
        rvKeranjang.adapter = KeranjangAdapter(keranjangList)
    }
}

// Adapter untuk RecyclerView Keranjang
class KeranjangAdapter(private val items: List<KeranjangItem>) :
    RecyclerView.Adapter<KeranjangAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Di sini Anda bisa menambahkan referensi ke view di dalam item_keranjang_pembeli.xml jika ada
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_keranjang_pembeli, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Di sini Anda akan mengatur data untuk setiap item
        // Contoh: val item = items[position]
    }

    override fun getItemCount() = items.size
}
