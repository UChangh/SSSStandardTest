package com.example.standardtest.recycleradapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.standardtest.databinding.RecyclerItemsBinding
import com.example.standardtest.objects.RecyclerListAdapters

class MainRecyclerViewAdapter:RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    inner class Holder(binding: RecyclerItemsBinding): RecyclerView.ViewHolder(binding.root) {
        val rp = binding.recyclerPlaylists
        val rmnr = binding.recyclerMixNRecommend
        val rm = binding.recyclerMix
        val rmm = binding.recyclerMyMusics
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = RecyclerItemsBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val hold = holder as Holder
        hold.rp.adapter = RecyclerListAdapters.mp_rva
        hold.rmnr.adapter = RecyclerListAdapters.mnr_rva
        hold.rm.adapter = RecyclerListAdapters.m_rva
        hold.rmm.adapter = RecyclerListAdapters.mmp_rva
    }

    override fun getItemCount(): Int = 1
}
