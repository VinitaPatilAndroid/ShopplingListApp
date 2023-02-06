package com.example.shoppinglistapp.view.ui.productdetails.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglistapp.data.entity.response.ProductImage
import com.example.shoppinglistapp.databinding.ListItemBinding
import com.squareup.picasso.Picasso

class ProductDetailsAdapter:RecyclerView.Adapter<ProductDetailsAdapter.ViewHolder> {

    private var productImageList :List<ProductImage>?= null
    private var context :Context? = null

    constructor(data1:List<ProductImage>, context: Context?)
    {
        this.productImageList = data1
        this.context = context

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