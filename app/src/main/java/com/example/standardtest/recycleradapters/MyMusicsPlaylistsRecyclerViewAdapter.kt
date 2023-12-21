package com.example.standardtest.recycleradapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.standardtest.databinding.MyMusicsLayoutBinding
import com.example.standardtest.dataclasses.MyMusics

class MyMusicsPlaylistsRecyclerViewAdapter(private val musics:Array<MyMusics>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    inner class Holder(binding: MyMusicsLayoutBinding): RecyclerView.ViewHolder(binding.root) {
        val img = binding.myMusicPlaylists
        val name = binding.myMusicName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = MyMusicsLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val hold = holder as Holder
        hold.img.setImageResource(musics[position].image)
        hold.name.text = musics[position].imgName
    }

    override fun getItemCount(): Int = 5
    // 플레이리스트, 지금 내가 좋아하는 곡, 추억에 잠길 수 있는 곡, 전에 즐겨듣던 곡, 좋아요 컬렉션
}