package com.example.standardtest

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.standardtest.databinding.ActivityMainBinding
import com.example.standardtest.objects.Uris
import com.example.standardtest.recycleradapters.MixsNRecommendsRecyclerViewAdapter
import com.example.standardtest.recycleradapters.MyPlaylistsRecyclerViewAdapter
import com.example.standardtest.recyclerdatas.MixsNRecommends
import com.example.standardtest.recyclerdatas.MyPlaylists

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mp = MyPlaylists()
    private val mnr = MixsNRecommends()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        var viewMain = binding.root
        setContentView(viewMain)


        val recyclerViewMyPlaylists = MyPlaylistsRecyclerViewAdapter(mp.dataset)  // 어댑터 만들기(플레이리스트에 들어갈 내용들의 집합)
        val recyclerViewMyPlaylist = binding.recyclerPlaylists      // recycler view 만들기, 바인딩으로 연결할 데이터 = RecyclerView의 ID
        recyclerViewMyPlaylist.adapter = recyclerViewMyPlaylists                        // rv = 어댑터 연결

        val recyclerViewMixsNRecommends = MixsNRecommendsRecyclerViewAdapter(mnr.dataset)
        val recyclerViewMixNRecommend = binding.recyclerMixNRecommend
        recyclerViewMixNRecommend.adapter = recyclerViewMixsNRecommends
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
//        loadVideo(R.id.video_1, VideoList.get(0))
//        loadVideo(R.id.video_2, VideoList.get(1))
//        loadVideo(R.id.video_3, VideoList.get(2))
//        loadVideo(R.id.video_4, VideoList.get(3))
//        loadVideo(R.id.video_5, VideoList.get(4))
//    }

//    private fun loadVideo(layoutId: Int, video: Video) {
//        findViewById<ViewGroup>(layoutId)?.apply {
//            with(video) {
//                findViewById<ImageView>(R.id.main_image).also {
//                    Glide.with(it).load(thumbnail).into(it)
//                }
//
//                findViewById<TextView>(R.id.channel_name).apply {
//                    text = channelTitle
//                }
//
//                findViewById<TextView>(R.id.title).apply {
//                    text = title
//                }
//
//                findViewById<ImageView>(R.id.logo).apply {
//                    setImageResource(R.drawable.haelin)
//                }
//            }
//        }
//    }
//
//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.menu_main, menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return when (item.itemId) {
//            R.id.action_settings -> {
//                val intent = Intent(this, SettingActivity::class.java)
//                startActivity(intent)
//                true
//            }
//
//            R.id.action_dialog -> {
//                showDialog()
//                true
//            }
//
//            R.id.action_call -> {
//                call()
//                true
//            }
//
//            else -> super.onOptionsItemSelected(item)
//        }
//    }
//
//    private fun showDialog() {
//        val dialog = AlertDialog.Builder(this)
//            .setTitle("Dialog Title")
//            .setMessage("This is a dialog.")
//            .setPositiveButton("OK", null)
//            .create()
//
//        dialog.show()
//    }
//
//
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