package com.example.shoppinglistapp.view.ui.productlist.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.neostore.R
import com.example.neostore.activity.product_detail.ProductDetailsActivity
import com.example.neostore.activity.product.model.ProductItem
import com.squareup.picasso.Picasso

class ProductAdapter:RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private var data1: List<ProductItem>? = null
    private var context: Context? = null

    constructor(data: List<ProductItem>?, context: Context?)
    {
        this.data1 = data
        this.context = context
    }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val v = LayoutInflater.from(parent.context).inflate(R.layout.list_layout,parent,false)
            return ViewHolder(v)
        }

        override fun getItemCount(): Int {
            return data1!!.size
        }

        // set data for perticular position
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {

            holder.textViewTitle.text = data1!!.get(position).name
            holder.textViewShortDesc.text = data1!!.get(position).producer
            holder.textViewPrice.text = data1!!.get(position).cost.toString()
            holder.ratingBar.rating = data1!!.get(position).rating!!.toFloat()
            ///////////// This lines are call itemclick on api product/////////
            holder.idLinear.setOnClickListener{

                data1!!.get(position).id
                val intent = Intent(context, ProductDetailsActivity::class.java)
                intent.putExtra("id_value", data1!!.get(position).id)
                context?.startActivity(intent)

            }
            Picasso.get().load(data1!!.get(position).productImages!!).into(holder.imageV)

        }

    fun setToAdapter(data: List<ProductItem>?) {

        this.data1 = data
        notifyDataSetChanged()

    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        var imageV = itemView.findViewById<View>(R.id.imageView) as ImageView
        val textViewTitle = itemView.findViewById<TextView>(R.id.textViewTitle)
        val textViewShortDesc = itemView.findViewById<TextView>(R.id.textViewShortDesc)
        val textViewPrice = itemView.findViewById<TextView>(R.id.textViewPrice)
        val ratingBar = itemView.findViewById<RatingBar>(R.id.ratingBar)
        var idLinear = itemView.findViewById<LinearLayout>(R.id.idLinear)
    }
}