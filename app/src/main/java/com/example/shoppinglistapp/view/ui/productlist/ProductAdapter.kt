package com.example.shoppinglistapp.view.ui.productlist

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglistapp.R
import com.example.shoppinglistapp.data.model.ProductItemResponse
import com.example.shoppinglistapp.databinding.ProductItemListBinding
import com.example.shoppinglistapp.view.ui.productdetails.ProductDetailsActivity
import com.squareup.picasso.Picasso

class ProductAdapter(
    private var productItemDetails: List<ProductItemResponse>? = null,
    private var context: Context? = null,
    private val onItemClick: (ProductItemResponse) -> Unit,
    private val isMyCart :Boolean = false
) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ProductItemListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return productItemDetails!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.textViewTitle.setText(productItemDetails!!.get(position).name)
        holder.binding.textViewShortDesc.setText(productItemDetails!!.get(position).producer)
        holder.binding.textViewPrice.text = productItemDetails!!.get(position).cost.toString()
        holder.binding.ratingBar.rating = productItemDetails!!.get(position).rating!!.toFloat()

        holder.binding.idLinear.setOnClickListener {
            productItemDetails!!.get(position).id
            val intent = Intent(context, ProductDetailsActivity::class.java)
            intent.putExtra("id_value", productItemDetails!!.get(position).id)
            context?.startActivity(intent)
        }
        holder.binding.ivFavorite.setOnClickListener {
               onItemClick(productItemDetails!!.get(position))
            holder.binding.ivFavorite.setBackgroundResource(R.drawable.ic_favorite_click)
        }
        Picasso.get().load(productItemDetails!!.get(position).productImages).into(holder.binding.ivProductItem)
        holder.binding.ivFavorite.setBackgroundResource(R.drawable.ic_favorite)

        if (isMyCart){
            holder.binding.ivFavorite.setBackgroundResource(R.drawable.ic_delete)
        }
    }

    class ViewHolder(val binding: ProductItemListBinding) : RecyclerView.ViewHolder(binding.root)
}