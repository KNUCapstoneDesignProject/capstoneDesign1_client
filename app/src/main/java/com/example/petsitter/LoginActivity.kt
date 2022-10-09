package com.example.petsitter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.petsitter.databinding.ActivityLoginBinding

/* 아마 스플래쉬 화면이 될 에정*/
class LoginActivity : AppCompatActivity() {
    private lateinit var lbinding:ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lbinding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(lbinding.root)


        val alertAni:Animation=AnimationUtils.loadAnimation(applicationContext,R.anim.top_alert)
        //loginBtn Click!
        lbinding.loginBtn.setOnClickListener {
            //no id||password
            Log.d("login","login버튼눌림")
            if(lbinding.inputId.length()==0 || lbinding.inputPassward.length()==0){
                Log.d("login","login버튼눌림-idNull")
                lbinding.loginAlertMessage.startAnimation(alertAni)
            }
            else{
                Log.d("login","login버튼눌림-else")
            }
            //post:: Id, passward
            // success-> main_page
            // fail -> 로그인 실패! 아이디 또는 비밀번호가 잘못되었습니다
        }
        // signupBtn Click!
        lbinding.signupBtn.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
    }
}