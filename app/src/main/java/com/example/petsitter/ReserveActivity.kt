package com.example.petsitter

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.graphics.Color
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.petsitter.databinding.ActivityDoReserveBinding

class ReserveActivity : AppCompatActivity() {
    var startDateString =""
    var endDateString =""
    private lateinit var  reserveBinding: ActivityDoReserveBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        reserveBinding = ActivityDoReserveBinding.inflate(layoutInflater)
        setContentView(reserveBinding.root)


        //시작날짜 선택 버튼
        reserveBinding.reserveStartDateBtn.setOnClickListener {
            SelectDate("start")
        }
        //시작시간 선택 버튼
        reserveBinding.reserveStartTimeBtn.setOnClickListener {
            SelectTime("start")
        }
        //종료날짜 선택 버튼
        reserveBinding.reserveEndDateBtn.setOnClickListener {
            SelectDate("end")
        }
        //종료시간 선택 버튼
        reserveBinding.reserveEndTimeBtn.setOnClickListener {
            SelectTime("end")
        }

        val alertAni: Animation = AnimationUtils.loadAnimation(applicationContext,R.anim.top_alert)
        //결제버튼 클릭시
        reserveBinding.reservePayBtn.setOnClickListener {
            val startList:ArrayList<String> = arrayListOf(
                startDateString.split('년').get(0),
                startDateString.split('년').get(1).split('월').get(0),
                startDateString.split('년').get(1).split("월 ").get(1).split('일').get(0)
            )
            val endList:ArrayList<String> = arrayListOf(
                endDateString.split('년').get(0),
                endDateString.split('년').get(1).split('월').get(0),
                endDateString.split('년').get(1).split("월 ").get(1).split('일').get(0)
            )
            Log.d("btntest" ,startList.toString()+endList.toString()+startList.get(2)+endList.get(2))
            if(endList.get(0)<startList.get(0)){
                reserveBinding.reserveAlertMessage.startAnimation(alertAni)
            }
            else if(endList.get(0)==startList.get(0))
            {
                Log.d("top alert","end0==start0")
                if(endList.get(1)<startList.get(1)){
                    Log.d("top alert","end1<start1")
                    reserveBinding.reserveAlertMessage.startAnimation(alertAni)
                }
                else if(endList.get(1)==startList.get(1))
                    Log.d("top alert","end1==start1")
                    if(endList.get(2).toInt() < startList.get(2).toInt()){
                        Log.d("top alert","endday<startday")
                        reserveBinding.reserveAlertMessage.startAnimation(alertAni)
                    }
            }
        }
        //washBtn click
        var washNum=0
        reserveBinding.reserveWashBtn.setOnClickListener {
            if(washNum%2==0){
                reserveBinding.reserveWashBtn.setBackgroundColor(232323)
                washNum++
            }
            else{
                washNum++
              //  reserveBinding.reserveWashBtn.setBackgroundColor(Color.)
            }

        }
    }

    /** select date fun*/
    fun SelectDate(Btn:String){
        val calendar = Calendar.getInstance() //캘린더뷰 만들기
        val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            if(Btn=="start"){
                startDateString = "${year}년 ${month+1}월 ${dayOfMonth}일"

                reserveBinding.reserveStartDateText.text = startDateString
            }
            else if(Btn=="end"){
                endDateString ="${year}년 ${month+1}월 ${dayOfMonth}일"
                reserveBinding.reserveEndDateText.text = endDateString
            }
        }
        DatePickerDialog(this, dateSetListener, calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show()
    }

    /** select time fun */
    fun SelectTime(Btn:String){
        val cal = Calendar.getInstance()
        val timeSetListener = TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
            if(Btn=="start"){
                reserveBinding.reserveStartTimeText.text = "${hourOfDay}시 ${minute}분"
            }
            else if(Btn=="end"){
                reserveBinding.reserveEndTimeText.text = "${hourOfDay}시 ${minute}분"
            }

        }
        TimePickerDialog(this, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE),true).show()
    }


}


/*//날짜spinner 구현
        val date_items: Array<Array<String>> = arrayOf(
            resources.getStringArray(R.array.Year),
            resources.getStringArray(R.array.Month),
            resources.getStringArray(R.array.Day)
        )
        val yearAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, date_items.get(0))
        val monthAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,date_items.get(1) )
        val dayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,date_items.get(2) )
        //시간 spinner 구현
        val time_items: Array<Array<String>> = arrayOf(
            resources.getStringArray(R.array.AmPm),
            resources.getStringArray(R.array.Hour),
            resources.getStringArray(R.array.Minutes)
        )
        val amPmAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, time_items.get(0))
        val hourAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,time_items.get(1) )
        val minutesAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,time_items.get(2) ) */