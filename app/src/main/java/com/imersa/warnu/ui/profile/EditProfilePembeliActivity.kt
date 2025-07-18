package com.imersa.warnu.ui.profile // Pastikan nama paket ini sesuai dengan lokasi file Anda

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.imersa.warnu.R

class EditProfilePembeliActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profil_pembeli)

        // Dapatkan referensi ke semua view yang akan diisi
        val etNama: TextInputEditText = findViewById(R.id.etNama)
        val etEmail: TextInputEditText = findViewById(R.id.etEmail)
        val etAlamat: TextInputEditText = findViewById(R.id.etAlamat)
        val etTelepon: TextInputEditText = findViewById(R.id.etTelepon)
        val btnBatal: MaterialButton = findViewById(R.id.btnBatal)
        val btnSelesai: MaterialButton = findViewById(R.id.btnSelesai)

        // Panggil fungsi untuk mengisi form dengan data yang sudah ada
        populateExistingData(etNama, etEmail, etAlamat, etTelepon)

        // Atur listener untuk tombol Batal
        btnBatal.setOnClickListener {
            // Cukup tutup activity ini untuk kembali ke halaman sebelumnya
            finish()
        }

        // Atur listener untuk tombol Selesai
        btnSelesai.setOnClickListener {
            // Di sini Anda akan menambahkan logika untuk menyimpan data yang sudah diubah
            // Misalnya, mengambil teks dari setiap EditText dan menyimpannya ke database
            // val namaBaru = etNama.text.toString()
            // ...dan seterusnya

            // Setelah selesai, tutup activity
            finish()
        }
    }

    private fun populateExistingData(
        etNama: TextInputEditText,
        etEmail: TextInputEditText,
        etAlamat: TextInputEditText,
        etTelepon: TextInputEditText
    ) {
        // Di sini Anda akan mengambil data yang dikirim dari halaman sebelumnya (ProfilePembeliActivity)
        // Untuk saat ini, kita akan menggunakan data dummy sebagai contoh

        val namaExisting = "Muhammad Alfan"
        val emailExisting = "alfanyazid5@gmail.com"
        val alamatExisting = "Pendem, Kota Batu"
        val teleponExisting = "085648280667"

        // Set teks pada setiap EditText
        etNama.setText(namaExisting)
        etEmail.setText(emailExisting)
        etAlamat.setText(alamatExisting)
        etTelepon.setText(teleponExisting)
    }
}
