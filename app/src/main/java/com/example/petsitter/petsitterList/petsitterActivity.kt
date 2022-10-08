package com.example.petsitter.petsitterList

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.petsitter.R
import com.example.petsitter.home.FinishFragment
import com.example.petsitter.home.HomeFragment
import com.example.petsitter.home.IngFragment
import com.example.petsitter.home.MyPageFragment
import kotlinx.android.synthetic.main.activity_main.*

class PetsitterActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
}

