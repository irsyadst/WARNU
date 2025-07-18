package com.imersa.warnu.ui.profile

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.imersa.warnu.R

class ProfilePembeliActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_pembeli)

        // Mengisi data langsung ke setiap TextView dengan ID uniknya
        findViewById<TextView>(R.id.tvNamaValue).text = "Muhammad Alfan"
        findViewById<TextView>(R.id.tvEmailValue).text = "alfanyazid5@gmail.com"
        findViewById<TextView>(R.id.tvAlamatValue).text = "Pendem, Kota Batu"
        findViewById<TextView>(R.id.tvTeleponValue).text = "085648280667"
        findViewById<TextView>(R.id.tvRoleValue).text = "Pelanggan"
    }
}
