package com.example.petsitter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.petsitter.databinding.ActivityMainBinding
import org.mindrot.jbcrypt.BCrypt
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    // 전역 변수로 바인딩 객체 선언
    private lateinit var mbinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 자동 생성된 뷰 바인딩 클래스에서의 inflate라는 메서드를 활용해서
        // 액티비티에서 사용할 바인딩 클래스의 인스턴스 생성
        mbinding = ActivityMainBinding.inflate(layoutInflater)
        // getRoot 메서드로 레이아웃 내부의 최상위 위치 뷰의 인스턴스 활용하여 생성된 뷰를 액티비티에 표현
        setContentView(mbinding.root)
        // loginActivity 실행
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)

    }
}