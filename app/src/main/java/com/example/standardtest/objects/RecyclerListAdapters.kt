package com.example.standardtest.objects

import com.example.standardtest.objects.DatasAdapter.mmp
import com.example.standardtest.objects.DatasAdapter.mnr
import com.example.standardtest.recycleradapters.MixNRecommendsRecyclerViewAdapter
import com.example.standardtest.recycleradapters.MixsRecyclerViewAdapter
import com.example.standardtest.recycleradapters.MyMusicsPlaylistsRecyclerViewAdapter
import com.example.standardtest.recycleradapters.MyPlaylistsRecyclerViewAdapter

object RecyclerListAdapters {   // val recyclerViewMixNRecommends = MixNRecommendsRecyclerViewAdapter(mnr.dataset) 와 같음
    val mp_rva = MyPlaylistsRecyclerViewAdapter(DatasAdapter.mp.dataset)
    val mnr_rva = MixNRecommendsRecyclerViewAdapter(mnr.dataset)
    val m_rva = MixsRecyclerViewAdapter(DatasAdapter.m.dataset)
    val mmp_rva = MyMusicsPlaylistsRecyclerViewAdapter(mmp.dataset)

    operator fun invoke(str:String):String = str
}