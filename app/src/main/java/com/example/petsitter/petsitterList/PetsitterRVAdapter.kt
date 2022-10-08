package com.example.petsitter.petsitterList

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.petsitter.R

class petsitterRVAdapter (val context: Context, val petsitterList: ArrayList<petsitter>) :
    RecyclerView.Adapter<petsitterRVAdapter.Holder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
            val view = LayoutInflater.from(context).inflate(R.layout.petsitter_service_list, parent, false)
            return Holder(view)
        }

        override fun getItemCount(): Int {
            return petsitterList.size
        }

        override fun onBindViewHolder(holder: Holder, position: Int) {
            holder?.bind(petsitterList[position], context)
        }

        inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
            val petsitterPhoto = itemView?.findViewById<ImageView>(R.id.petsitterPhotoImg)
            val petsitterName = itemView?.findViewById<TextView>(R.id.petsitterNameTV)
            val petsitterCareer = itemView?.findViewById<TextView>(R.id.petsitterCareerTV)
            val petsitterPrice = itemView?.findViewById<TextView>(R.id.petsitterPriceTV)
            val petsitterSpecial = itemView?.findViewById<TextView>(R.id.petsitterSpecialTV)

            fun bind (petsitter: petsitter, context: Context) {
                /* dogPhoto의 setImageResource에 들어갈 이미지의 id를 파일명(String)으로 찾고,
                이미지가 없는 경우 안드로이드 기본 아이콘을 표시한다.*/
                if (petsitter.photo != "") {
                    val resourceId = context.resources.getIdentifier(petsitter.photo, "drawable", context.packageName)
                    petsitterPhoto?.setImageResource(resourceId)
                } else {
                    petsitterPhoto?.setImageResource(R.mipmap.ic_launcher)
                }
                /* 나머지 TextView와 String 데이터를 연결한다. */
                petsitterName?.text = petsitter.name
                petsitterCareer?.text = petsitter.career
                petsitterPrice?.text = petsitter.price
                petsitterSpecial?.text = petsitter.special.toString()
            }
        }
    }