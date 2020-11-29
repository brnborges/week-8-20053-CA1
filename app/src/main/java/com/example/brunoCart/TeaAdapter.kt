package com.example.brunoCart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.tea_description_view.view.*

class TeaAdapter (var items: ArrayList<Tea>, var clickListner: OnTeaItemClickListener) : RecyclerView.Adapter<TeaViewHolder>() {
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeaViewHolder {
        return TeaViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.tea_description_view,parent,false)

        )

    }

    override fun onBindViewHolder(holder: TeaViewHolder, position: Int) {
        holder.initialize(items.get(position),clickListner)
    }
}



class TeaViewHolder (itemView:View) :RecyclerView.ViewHolder(itemView){
    var teaName = itemView.teaName
    var teaPrice = itemView.teaPrice
    var teaDescription = itemView.teadescription
    var teaLogo = itemView.tealogo

    fun initialize(item: Tea, action: OnTeaItemClickListener){
        teaName.text = item.name
        teaPrice.text = item.name
        teaDescription.text = item.name
        teaLogo.setImageResource(item.logo)

        itemView.setOnClickListener{
            action.onItemClick(item, adapterPosition)
        }
    }
}

interface OnTeaItemClickListener {
    fun onItemClick(item: Tea, position: Int)
}