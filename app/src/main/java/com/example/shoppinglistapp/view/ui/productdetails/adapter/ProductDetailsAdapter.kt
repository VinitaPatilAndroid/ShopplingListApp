package com.example.shoppinglistapp.view.ui.productdetails.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.neostore.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item.*

class ProductDetailsAdapter:RecyclerView.Adapter<ProductDetailsAdapter.ViewHolder> {

    private var data :List<ProductImage>?= null
    private var context :Context? = null
    private  var listener:onItemClick? = null
    var selectedPosition = -1

    constructor(data1:List<ProductImage>, context: Context?, liste:onItemClick)
    {
        this.data = data1
        this.context = context
        listener = liste;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return data!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        if(selectedPosition == position){
            holder.imageView.setBackgroundResource(R.drawable.color)
        }else {
            holder.imageView.background = null
        }
        holder.imageView.setOnClickListener {
            listener?.onClicked(position)
            selectedPosition = position
            notifyDataSetChanged()
        }
        Picasso.get().load(data!!.get(position)?.image!!).into(holder.imageView)
    }

    class ViewHolder (itemView:View):RecyclerView.ViewHolder(itemView){

         val imageView = itemView.findViewById<ImageView>(R.id.imageView1)
    }
    interface onItemClick{

        fun onClicked(position: Int)
    }
}