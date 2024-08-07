package com.example.nerkhearzapp.view.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.nerkhearzapp.databinding.RecyclerLayoutBinding
import com.example.nerkhearzapp.view.DataClass
import com.example.nerkhearzapp.view.activity.MainActivity


class MyAdapter(val titleList: MutableList<String> ,val priceList: MutableList<String>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: RecyclerLayoutBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MyViewHolder(RecyclerLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))


    override fun getItemCount(): Int {
        return titleList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.titleTextView.text = titleList[position]
        holder.binding.priceTextView.text = priceList[position]
    }

}