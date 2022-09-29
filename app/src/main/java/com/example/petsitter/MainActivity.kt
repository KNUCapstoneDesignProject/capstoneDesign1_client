package com.example.petsitter
import kotlinx.android.synthetic.main.activity_main.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import com.example.petsitter.petsitterList.petsitter
import com.example.petsitter.petsitterList.petsitterRVAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val input_id: TextView = findViewById(R.id.input_Id)
        val input_passward: TextView = findViewById(R.id.input_Passward)
        val login_btn: Button = findViewById(R.id.login_Btn)
        val signIn_btn: TextView = findViewById(R.id.signup_Btn)
        // Spinner
        val animalSizeSpinner = findViewById<Spinner>(R.id.signup_Aniaml_Size)
        //animalSizeSpinner.adapter=ArrayAdapter.createFromResource(this,R.array.Aniaml_Size,android.R.layout.simple_spinner_item)
        // val addAnimal =findViewById<>(R.id.Animal02)

        signIn_btn.setOnClickListener {
            setContentView(R.layout.activity_signup)
        }

//        login_btn.setOnClickListener {
//
//            //비밀번호 암호화
//            val passwordHashed = BCrypt.hashpw(input_passward.toString(), BCrypt.gensalt())
//            //비밀번호 맞는지 확인.
//            val isValidPassword = BCrypt.checkpw(input_passward.toString(), passwordHashed)
//            println(passwordHashed)
//            println(isValidPassword)
//        }
    }

}