package com.imersa.warnu.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import com.imersa.warnu.R
// Import Activity lain yang Anda perlukan
// import com.imersa.warnu.ui.profile.ProfilSellerActivity

// Data class untuk menampung data produk
data class Product(val name: String, val price: String, val stock: Int)

class DashboardFragment : Fragment() {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.dashboard_seller, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // --- BAGIAN PENTING UNTUK MENU ---
        // 1. Dapatkan referensi ke semua view yang dibutuhkan
        drawerLayout = view.findViewById(R.id.drawer_layout)
        val navigationView = view.findViewById<NavigationView>(R.id.nav_view)
        val hamburgerIcon = view.findViewById<ImageView>(R.id.hamburger_icon)

        // 2. Atur listener saat ikon hamburger di-klik
        hamburgerIcon.setOnClickListener {
            // Perintah untuk membuka menu dari sisi kiri (start)
            drawerLayout.openDrawer(GravityCompat.START)
        }
        // --- BATAS AKHIR BAGIAN PENTING ---

        // Handler untuk klik item di dalam menu samping
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_profil -> {
                    // Contoh navigasi ke Profil Activity
                    // val intent = Intent(activity, ProfilSellerActivity::class.java)
                    // startActivity(intent)
                }
                // Tambahkan case lain untuk item menu lainnya
            }
            // Tutup drawer setelah item diklik
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }

        // Setup RecyclerView untuk menampilkan produk
        setupRecyclerView(view)
    }

    private fun setupRecyclerView(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.rvProdukDashboard)

        // Buat data dummy untuk ditampilkan
        val productList = listOf(
            Product("Kaos", "Rp 20.000", 10),
            Product("Kaos", "Rp 20.000", 10),
            Product("Kaos", "Rp 20.000", 10),
            Product("Sepatu", "Rp 150.000", 5),
            Product("Topi", "Rp 50.000", 20)
        )

        recyclerView.adapter = DashboardProductAdapter(productList)
    }
}

// Adapter untuk RecyclerView (Tidak perlu diubah)
class DashboardProductAdapter(private val productList: List<Product>) :
    RecyclerView.Adapter<DashboardProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productImage: ImageView = itemView.findViewById(R.id.ivProduk)
        val productName: TextView = itemView.findViewById(R.id.tvNamaProduk)
        val productPrice: TextView = itemView.findViewById(R.id.tvHargaProduk)
        val productStock: TextView = itemView.findViewById(R.id.tvStokProduk)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_produk_dashboard, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.productName.text = product.name
        holder.productPrice.text = product.price
        holder.productStock.text = "Stok: ${product.stock}"
    }

    override fun getItemCount() = productList.size
}
