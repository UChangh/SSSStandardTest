package com.example.standardtest.recycleradapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.standardtest.databinding.PlaylistLayoutBinding
import com.example.standardtest.dataclasses.PlaylistName

class MyPlaylistsRecyclerViewAdapter(private val playlist:Array<PlaylistName>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    inner class Holder(binding: PlaylistLayoutBinding):
        RecyclerView.ViewHolder(binding.root) { // rv를 구성할 아이템 세팅(linear)
        // 바인딩은 자동으로 xml파일이나 내부의 아이템들을 각각의 ID로 바인딩을 함
        var image = binding.playlistImg // playlist_img 라는 아이템을 image라는 변수에 묶어서 담는다
        var text = binding.playlistName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder { // 아이템 생성
        val binding = PlaylistLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        // LayoutInflater -> LayoutBinding /
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {  // 아이템을 데이터랑 연결
        val hold = holder as Holder
        hold.text.text = playlist[position].name    // rv 아이템에 미리 지정된 인덱스 값을 position으로 가져오는 식
        hold.image.setImageResource(playlist[position].img)
    }

    override fun getItemCount(): Int = 8            // rv에 보여줄 아이템 개수
}
// 어댑터는 한개만 있어도 됨
