package com.example.standardtest.recycleradapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.standardtest.databinding.MusicAlbumsLayoutBinding
import com.example.standardtest.dataclasses.MixNRecommend

class MixNRecommendsRecyclerViewAdapter(private val recommends:Array<MixNRecommend>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    inner class Holder(binding: MusicAlbumsLayoutBinding):
        RecyclerView.ViewHolder(binding.root) {
            var image = binding.albumImage
            var artist = binding.albumArtist
            var name = binding.albumName
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = MusicAlbumsLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val hold = holder as Holder
        hold.image.setImageResource(recommends[position].image)
        hold.artist.text = recommends[position].artist
        hold.name.text = recommends[position].name
    }

    override fun getItemCount(): Int = 10   // 10개 보여주기
}