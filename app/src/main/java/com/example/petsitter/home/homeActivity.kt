package com.example.petsitter.home

import android.app.Activity
import android.app.PendingIntent.getActivity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.petsitter.R
import com.example.petsitter.home.HomeFragment
import com.example.petsitter.petsitterList.PetsitterActivity
import com.example.petsitter.petsitterList.petsitter
import com.example.petsitter.petsitterList.petsitterRVAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val ingFragment = IngFragment()
        val finishFragment = FinishFragment()
        val myPageFragment = MyPageFragment()

        setCurrentFragment(homeFragment)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home->setCurrentFragment(homeFragment)
                R.id.nav_ing->setCurrentFragment(ingFragment)
                R.id.nav_finish->setCurrentFragment(finishFragment)
                R.id.nav_mypage->setCurrentFragment(myPageFragment)
            }
            true
        }


        fun setCurrentFragment(fragment:Fragment)=
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment,fragment)
                commit()
            }

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

    private fun setCurrentFragment(fragment:Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,fragment)
            commit()
        }

}