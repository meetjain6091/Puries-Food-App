package com.example.puriesfooddelivery.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.example.puriesfooddelivery.R
import com.example.puriesfooddelivery.adapter.PopularAdapter
import com.example.puriesfooddelivery.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Image Slider Setup
        val imageList = arrayListOf(
            SlideModel(R.drawable.banner4, "Discounts Up to 50%", ScaleTypes.FIT),
            SlideModel(R.drawable.banner5, "Try Our New Dishes", ScaleTypes.FIT),
            SlideModel(R.drawable.banner1, "Special Weekend Offers", ScaleTypes.FIT)
        )

        binding.imageSlider.setImageList(imageList, ScaleTypes.FIT)
        binding.imageSlider.setItemClickListener(object : ItemClickListener {
            override fun doubleClick(position: Int) {
                // Optional: Handle double-click if needed
            }

            override fun onItemSelected(position: Int) {
                Toast.makeText(
                    requireContext(),
                    "Selected: ${imageList[position].title}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })

        // RecyclerView Setup
        val foodNames = listOf("Burger", "Sandwich", "Momo", "Item")
        val prices = listOf("$5", "$7", "$9", "$6")
        val images = listOf(R.drawable.menu1, R.drawable.menu2, R.drawable.menu3, R.drawable.menu4)

        val adapter = PopularAdapter(foodNames, prices, images)
        binding.popularRecyclerView.layoutManager =  LinearLayoutManager(requireContext())
        binding.popularRecyclerView.setHasFixedSize(true)
        binding.popularRecyclerView.adapter = adapter

        // View Menu Button Click Listener
        binding.textView22.setOnClickListener {
            Toast.makeText(requireContext(), "Navigating to Full Menu...", Toast.LENGTH_SHORT).show()
            // Add navigation logic here if required, e.g., using Navigation Component
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // Clear binding to prevent memory leaks
    }
}
