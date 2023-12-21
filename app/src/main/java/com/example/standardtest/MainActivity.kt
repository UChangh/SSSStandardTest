package com.example.standardtest

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.standardtest.databinding.ActivityMainBinding
import com.example.standardtest.objects.Adapters.m
import com.example.standardtest.objects.Adapters.mmp
import com.example.standardtest.objects.Adapters.mnr
import com.example.standardtest.objects.Adapters.mp
import com.example.standardtest.objects.Uris
import com.example.standardtest.recycleradapters.MixNRecommendsRecyclerViewAdapter
import com.example.standardtest.recycleradapters.MixsRecyclerViewAdapter
import com.example.standardtest.recycleradapters.MyMusicsPlaylistsRecyclerViewAdapter
import com.example.standardtest.recycleradapters.MyPlaylistsRecyclerViewAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val viewMain = binding.root
        setContentView(viewMain)

        // Playlist 메뉴 구현 및 Recycler View 연결
        val recyclerViewMyPlaylists = MyPlaylistsRecyclerViewAdapter(mp.dataset)  // 어댑터 만들기(플레이리스트에 들어갈 내용들의 집합)
        val recyclerViewMyPlaylist = binding.recyclerPlaylists      // recycler view 만들기, 바인딩으로 연결할 데이터 = RecyclerView의 ID
        recyclerViewMyPlaylist.adapter = recyclerViewMyPlaylists                        // rv = 어댑터 연결

        // Mix & Recommends 메뉴 구현 및 Recycler View 연결
        val recyclerViewMixNRecommends = MixNRecommendsRecyclerViewAdapter(mnr.dataset)
        val recyclerViewMixNRecommend = binding.recyclerMixNRecommend
        recyclerViewMixNRecommend.adapter = recyclerViewMixNRecommends

        // My Musics(나만의 음악) 메뉴 구현 및 Recycler View 연결
        val rvMyMusicsPlaylists = MyMusicsPlaylistsRecyclerViewAdapter(mmp.dataset)
        val rvMyMusics = binding.recyclerMyMusics
        rvMyMusics.adapter = rvMyMusicsPlaylists

        // Mixs 메뉴 구현 및 Recycler View 연결
        val rvMixslists = MixsRecyclerViewAdapter(m.dataset)
        val rvMixs = binding.recyclerMix
        rvMixs.adapter = rvMixslists
    }


    fun titleButton(view: View) {
        when(view) {
            binding.btnAccount -> toast("아직 아무것도 없어요!!!")
            binding.btnMain -> toast("짜잔!")
            binding.btnMusic -> music(Uris.MUSIC_URL)
            binding.btnPodcast -> call(Uris.phone_number)
            binding.btnEvent -> showDialog()
        }
    }

    private fun call(phoneNum:String) {
        val phone = "tel:$phoneNum"
        val intent = Intent(Intent.ACTION_DIAL, Uri.parse(phone))
        startActivity(intent)
    }

    private fun toast(text:String) {
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show()
    }

    private fun music(link:String) {
        val music = link
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(music))
        startActivity(intent)
    }

    private fun showDialog() {
        val dialog = AlertDialog.Builder(this)
            .setTitle("짜잔!")
            .setMessage("짜잔!")
            .setPositiveButton("짠!", null)
            .create()
        dialog.show()
    }
}


//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

//        findViewById<Toolbar>(R.id.toolbar).apply {
//            setSupportActionBar(this)
//        }
//    private fun call() {
//        // 권한 확인
//        if (ContextCompat.checkSelfPermission(
//                this,
//                android.Manifest.permission.CALL_PHONE
//            ) != PackageManager.PERMISSION_GRANTED
//        ) {
//            ActivityCompat.requestPermissions(
//                this,
//                arrayOf(android.Manifest.permission.CALL_PHONE),
//                REQUEST_CALL
//            )
//        } else {
//            // Intent 설정
//            val callIntent = Intent(Intent.ACTION_CALL)
//            callIntent.data = Uri.parse("tel:012345567")
//            startActivity(callIntent)
//        }
//    }
//
//    // 권한 요청 결과 처리
//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<out String>,
//        grantResults: IntArray
//    ) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        if (requestCode == REQUEST_CALL) {
//            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                call() // 권한이 허용된 후 전화 걸기
//            } else {
//                Toast.makeText(applicationContext, "전화 걸기 권한이 없습니다.", Toast.LENGTH_LONG).show()
//            }
//        }
//    }
//
//    companion object {
//        private const val REQUEST_CALL = 1
//    }
//}