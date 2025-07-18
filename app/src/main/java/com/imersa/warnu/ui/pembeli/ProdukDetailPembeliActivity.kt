package com.imersa.warnu.ui.pembeli // Pastikan nama paket ini sesuai dengan lokasi file Anda

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.imersa.warnu.R

class ProdukDetailPembeliActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produk_detail_pembeli)

        // Dapatkan referensi ke tombol
        val btnKeranjang: MaterialButton = findViewById(R.id.btnKeranjang)
        val btnBeli: MaterialButton = findViewById(R.id.btnBeli)

        // Atur listener untuk tombol Keranjang
        btnKeranjang.setOnClickListener {
            // Logika untuk menambahkan produk ke keranjang
            Toast.makeText(this, "Produk ditambahkan ke keranjang", Toast.LENGTH_SHORT).show()
        }

        // Atur listener untuk tombol Beli
        btnBeli.setOnClickListener {
            // Logika untuk langsung melanjutkan ke pembayaran
            Toast.makeText(this, "Lanjut ke pembayaran", Toast.LENGTH_SHORT).show()
        }

        // Di sini Anda akan mengambil data produk (misalnya dari Intent) dan menampilkannya
        // val namaProduk = intent.getStringExtra("NAMA_PRODUK")
        // findViewById<TextView>(R.id.tvNamaProduk).text = namaProduk
    }
}
