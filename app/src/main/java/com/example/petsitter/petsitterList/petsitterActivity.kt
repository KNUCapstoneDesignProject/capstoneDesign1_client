package com.example.petsitter.petsitterList

import android.os.Bundle
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.petsitter.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class PetsitterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//    private val frame: RelativeLayout by lazy { // activity_main의 화면 부분
//        findViewById(R.id.body_container)
//    }
//    private val bottomNavigationView: BottomNavigationView by lazy { // 하단 네비게이션 바
//        findViewById(R.id.bottom_navigation)
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        // 애플리케이션 실행 후 첫 화면 설정
////        supportFragmentManager.beginTransaction()
////            .add(frame.id, HomeFragment()).commit()
//
//        // 하단 네비게이션 바 클릭 이벤트 설정
//        bottomNavigationView.setOnNavigationItemSelectedListener {item ->
//            when(item.itemId) {
//                R.id.nav_home -> {
//                    setContentView(R.layout.activity_main)
//                    true
//                }
//                R.id.nav_ing -> {
//                    replaceFragment(IngFragment())
//                    true
//                }
//                R.id.nav_finish -> {
//                    replaceFragment(FinishFragment())
//                    true
//                }
//                R.id.nav_mypage -> {
//                    replaceFragment(MyPageFragment())
//                    true
//                }
//                else -> false
//            }
//        }

        var petsitterList = arrayListOf<petsitter>(
            petsitter("000", "3회 이상", "30,000원", "sample", "소형견 / 포메라니안 / 낯가림 전문"),
            petsitter("000", "3회 이상", "30,000원", "sample", "소형견 / 포메라니안 / 낯가림 전문"),
            petsitter("000", "3회 이상", "30,000원", "sample", "소형견 / 포메라니안 / 낯가림 전문"),
            petsitter("000", "3회 이상", "30,000원", "sample", "소형견 / 포메라니안 / 낯가림 전문"),
            petsitter("000", "3회 이상", "30,000원", "sample", "소형견 / 포메라니안 / 낯가림 전문"),
        )

        val mAdapter = petsitterRVAdapter(this, petsitterList)
        pRecyclerView.adapter = mAdapter

        val lm = LinearLayoutManager(this)
        pRecyclerView.layoutManager = lm
        pRecyclerView.setHasFixedSize(true)

    }
    // 화면 전환 구현 메소드
//    private fun replaceFragment(fragment: Fragment) {
//        supportFragmentManager.beginTransaction().replace(frame.id, fragment).commit()
//    }
}

