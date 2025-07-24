package com.imersa.warnu.ui.seller

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.imersa.warnu.adapter.ProdukAdapter
import com.imersa.warnu.databinding.FragmentDashboardBinding
import com.imersa.warnu.model.Product

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!
    private lateinit var productAdapter: ProdukAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupButton()
    }

    private fun setupRecyclerView() {
        productAdapter = ProdukAdapter(getDummyProduk())
        binding.rvDashboardProduct.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = productAdapter
        }
    }

    private fun setupButton() {
        binding.btnAddProduct.setOnClickListener {
            Toast.makeText(requireContext(), "Tambah produk diklik", Toast.LENGTH_SHORT).show()
            // Contoh navigasi ke fragment tambah produk
            // findNavController().navigate(R.id.action_dashboard_to_tambahProdukFragment)
        }
    }

    private fun getDummyProduk(): List<Product> {
        return listOf(
            Product("Kopi Arabika", "https://example.com/kopi1.jpg"),
            Product("Kopi Robusta", "https://example.com/kopi2.jpg"),
            Product("Kopi Gayo", "https://example.com/kopi3.jpg"),
            Product("Kopi Toraja", "https://example.com/kopi4.jpg"),
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
