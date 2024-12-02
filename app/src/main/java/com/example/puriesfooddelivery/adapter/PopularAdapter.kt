package com.example.puriesfooddelivery.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.puriesfooddelivery.databinding.PopularitemBinding

class PopularAdapter (private  val items : List<String>, private  val price:List<String>, private  val image:List<Int>) : RecyclerView.Adapter<PopularAdapter.PouplerViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PouplerViewHolder {
        return PouplerViewHolder(PopularitemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(
        holder: PouplerViewHolder,
        position: Int
    ) {
        val item = items[position]
        val images = image[position]
        val price = price[position]
        holder.bind(item,price,images)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class PouplerViewHolder (private  val  binding : PopularitemBinding) : RecyclerView.ViewHolder(binding.root){
        private val imagesView = binding.imageView7
        fun bind(item: String, price: String, image: Int) {
            binding.foodNamePopular.text = item
            binding.pricePopular.text = price
            imagesView.setImageResource(image)
        }

    }
}