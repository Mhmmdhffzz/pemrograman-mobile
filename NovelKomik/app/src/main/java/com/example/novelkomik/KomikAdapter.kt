package com.example.novelkomik

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class KomikAdapter(
    private val itemList: List<Komik>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<KomikAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(item: Komik)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemImage2: ImageView = itemView.findViewById(R.id.itemImage2)
        val itemName2: TextView = itemView.findViewById(R.id.itemName2)


        init {
            itemView.setOnClickListener {
                listener.onItemClick(itemList[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout2, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.itemImage2.setImageResource(currentItem.image)
        holder.itemName2.text = currentItem.name
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}