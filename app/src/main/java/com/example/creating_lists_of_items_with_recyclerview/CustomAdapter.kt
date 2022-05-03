package com.example.creating_lists_of_items_with_recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val persons: List<Person>):
    RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textViewName: TextView = itemView.findViewById(R.id.textViewName)
        val textViewPhone: TextView = itemView.findViewById(R.id.textViewPhone)
        val imageViewSex: ImageView = itemView.findViewById(R.id.imageViewSex)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val person : Person = persons[position]
        holder.textViewName.text = person.name
        holder.textViewPhone.text = person.phoneNumber
        holder.imageViewSex.setImageResource(if(person.sex == "female") R.drawable.female
        else R.drawable.male)
    }

    override fun getItemCount() = persons.size
}