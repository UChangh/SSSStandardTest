package com.example.standardtest.recycleradapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.standardtest.databinding.MixsLayoutBinding
import com.example.standardtest.dataclasses.Mixs

class MixsRecyclerViewAdapter(private val mixslist:Array<Mixs>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    inner class Holder(binding: MixsLayoutBinding):RecyclerView.ViewHolder(binding.root) {
        val image = binding.mixMusics
        val text = binding.mixDescription
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = MixsLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val hold = holder as Holder
        hold.image.setImageResource(mixslist[position].image)
        hold.text.text = mixslist[position].genre
    }

    override fun getItemCount(): Int = mixslist.size
}