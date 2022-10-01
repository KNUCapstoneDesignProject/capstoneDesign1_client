package com.example.petsitter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.petsitter.databinding.ActivityLoginBinding
import com.example.petsitter.databinding.ActivityMainBinding

/* 아마 스플래쉬 화면이 될 에정*/
class LoginActivity : AppCompatActivity() {
    private lateinit var lbinding:ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lbinding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(lbinding.root)

        //loginBtn Click!
        lbinding.loginBtn.setOnClickListener {
            //post:: Id, passward
            // success-> main_page
            // fail -> toast-> Re
        }
        // signupBtn Click!
        lbinding.signupBtn.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
    }
}