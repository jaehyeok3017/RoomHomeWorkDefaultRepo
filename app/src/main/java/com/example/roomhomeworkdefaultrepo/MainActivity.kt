package com.example.roomhomeworkdefaultrepo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomhomeworkdefaultrepo.db.AppDataBase
import com.example.roomhomeworkdefaultrepo.db.PostData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var db : AppDataBase
    private lateinit var adapter: TextAdapter
    private lateinit var contentList : List<PostData>
    private lateinit var titleList : List<PostData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv: RecyclerView = findViewById(R.id.memoRecycler)

        // room을 정의하는 부분
        db = AppDataBase.getInstance(this)!!
        loadData()

        // save data button 클릭 시
        findViewById<Button>(R.id.saveDataButton).setOnClickListener {
            val title: String = findViewById<EditText>(R.id.titleEditText).text.toString()
            val content: String = findViewById<EditText>(R.id.contentEditText).text.toString()
            CoroutineScope(Dispatchers.IO).launch {
                db.memoDao().insertData(PostData(title, content))
                loadData()
            }
        }
    }

    private fun loadData() {
        CoroutineScope(Dispatchers.IO).launch {
            // 비동기코드 : Retrofit 서버 연동, 테이블 관련 작업들 (db)
            titleList = db.memoDao().getAll()
            contentList = db.memoDao().getAll()

            runOnUiThread {
                // 동기코드 : 앞에서 돌아가는 코드 ( view, 어댑터 설정, .setText, 뷰가 보이는지 등 )
                // RecyclerView.adapter =
            }
        }
    }
}