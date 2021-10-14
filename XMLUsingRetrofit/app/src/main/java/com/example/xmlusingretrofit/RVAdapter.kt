package com.example.xmlusingretrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row.view.*

class RVAdapter (private val mydata: ArrayList<myData>):  RecyclerView.Adapter<RVAdapter.ItemViewHolder>(){
    class ItemViewHolder (itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val list1 =mydata[position]

        holder.itemView.apply {
            tv1.text = "Title: \n${list1.title}"
            tv2.text = "Language: \n${list1.language}"
            tv3.text = "Generator \n${list1.generator}"
        }
    }

    override fun getItemCount() = mydata.size
}