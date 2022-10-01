package com.example.petsitter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.petsitter.R
import com.example.petsitter.databinding.ActivityDoReserveBinding
import com.example.petsitter.databinding.ActivitySignupBinding


class ReserveActivity : AppCompatActivity() {
    private lateinit var  reserveBinding: ActivityDoReserveBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        reserveBinding= ActivityDoReserveBinding.inflate(layoutInflater)
        setContentView(reserveBinding.root)

        //날짜spinner 구현
        val date_items: Array<Array<String>> = arrayOf(
            resources.getStringArray(R.array.Year),
            resources.getStringArray(R.array.Month),
            resources.getStringArray(R.array.Day)
        )
        val yearAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, date_items.get(0))
        val monthAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,date_items.get(1) )
        val dayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,date_items.get(2) )

        reserveBinding.reserveSpinnerYear.adapter=yearAdapter
        reserveBinding.reserveSpinnerMonth.adapter=monthAdapter
        reserveBinding.reserveSpinnerDay.adapter=dayAdapter
        //시간 spinner 구현
        val time_items: Array<Array<String>> = arrayOf(
            resources.getStringArray(R.array.AmPm),
            resources.getStringArray(R.array.Hour),
            resources.getStringArray(R.array.Minutes)
        )
        val amPmAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, time_items.get(0))
        val hourAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,time_items.get(1) )
        val minutesAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,time_items.get(2) )
        reserveBinding.reserveSpinnerAmpm.adapter=amPmAdapter
        reserveBinding.reserveSpinnerHour.adapter=hourAdapter
        reserveBinding.reserveSpinnerMinutes.adapter=minutesAdapter
    }
}
