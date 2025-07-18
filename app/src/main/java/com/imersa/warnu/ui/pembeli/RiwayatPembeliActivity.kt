package com.imersa.warnu.ui.pembeli // Pastikan nama paket ini sesuai dengan lokasi file Anda

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.imersa.warnu.R

// Data class sederhana untuk menampung data riwayat
data class RiwayatItem(val id: String)

class RiwayatPembeliActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_riwayat_pembeli)

        val rvRiwayat: RecyclerView = findViewById(R.id.rvRiwayat)

        // Buat data dummy untuk ditampilkan
        val riwayatList = listOf(
            RiwayatItem("1"), RiwayatItem("2"), RiwayatItem("3"), RiwayatItem("4"),
            RiwayatItem("5"), RiwayatItem("6"), RiwayatItem("7"), RiwayatItem("8")
        )

        // Set adapter ke RecyclerView
        rvRiwayat.adapter = RiwayatAdapter(riwayatList)
    }
}

// Adapter untuk RecyclerView Riwayat
class RiwayatAdapter(private val items: List<RiwayatItem>) :
    RecyclerView.Adapter<RiwayatAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Di sini Anda bisa menambahkan referensi ke view di dalam item_riwayat_pembeli.xml jika ada
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_riwayat_pembeli, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Di sini Anda akan mengatur data untuk setiap item
        // Contoh: val item = items[position]
    }

    override fun getItemCount() = items.size
}
