package com.example.shoppingapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppingapp.network.Item

class CustomAdapter(private val items: MutableList<Item>) :
    RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val gridViewItem =
            LayoutInflater.from(parent.context).inflate(R.layout.grid_item, parent, false)
        return MyViewHolder(gridViewItem)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = items[position]

        holder.itemImage.setImageResource(item.image)
        holder.itemName.text = item.name
        holder.itemPrice.text = item.price


    }

    override fun getItemCount(): Int {
        return items.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val itemImage = itemView.findViewById(R.id.item_image) as ImageView
        val itemName = itemView.findViewById(R.id.item_name) as TextView
        val itemPrice = itemView.findViewById(R.id.item_price) as TextView

    }


}