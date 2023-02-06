package com.example.shoppinglistapp.view.ui.productdetails

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglistapp.data.model.ProductImage
import com.example.shoppinglistapp.databinding.ListItemBinding
import com.squareup.picasso.Picasso

class ProductDetailsAdapter:RecyclerView.Adapter<ProductDetailsAdapter.ViewHolder> {

    private var productImageList :List<ProductImage>?= null

    constructor(productImage:List<ProductImage>)
    {
        this.productImageList = productImage
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return productImageList!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Picasso.get().load(productImageList!!.get(position)?.image!!).into(holder.binding.ivProductAngle)
    }

    class ViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)
}