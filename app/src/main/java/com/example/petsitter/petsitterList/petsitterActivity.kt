package com.example.petsitter.petsitterList

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.petsitter.R
import kotlinx.android.synthetic.main.activity_main.*

class PetsitterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var petsitterList = arrayListOf<petsitter>(
            petsitter("000", "3회 이상", "30,000원", "sample"),
            petsitter("000", "3회 이상", "30,000원", "sample"),
            petsitter("000", "3회 이상", "30,000원", "sample"),
            petsitter("000", "3회 이상", "30,000원", "sample"),
            petsitter("000", "3회 이상", "30,000원", "sample"),
        )

        val mAdapter = petsitterRVAdapter(this, petsitterList)
        pRecyclerView.adapter = mAdapter

        val lm = LinearLayoutManager(this)
        pRecyclerView.layoutManager = lm
        pRecyclerView.setHasFixedSize(true)

    }
}