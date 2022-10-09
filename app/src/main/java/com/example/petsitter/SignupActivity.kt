package com.example.petsitter

import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import androidx.core.widget.addTextChangedListener
import com.example.petsitter.databinding.ActivityLoginBinding
import com.example.petsitter.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
    private lateinit var  subinding: ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        subinding=ActivitySignupBinding.inflate(layoutInflater)
        setContentView(subinding.root)
        var animalplus=1
        //check Id



        //

        //add animal
        subinding.signupAddAnimal.setOnClickListener {
            if(animalplus==1){
                subinding.signupAnimal02.visibility=View.VISIBLE
                animalplus++
            }
            else if(animalplus==2){
                subinding.signupAnimal03.visibility= View.VISIBLE
                animalplus++
            }
            else if(animalplus==3){
                subinding.signupAnimal04.visibility= View.VISIBLE
                animalplus++
            }
            else if(animalplus==4){
                subinding.signupAnimal05.visibility= View.VISIBLE
                animalplus++
                subinding.signupAddAnimal.visibility = View.GONE
            }
            else{

            }
        }
        //animal size spinner
        val items: Array<Array<String>> = arrayOf(
            resources.getStringArray(R.array.Aniaml_Size)
        )
        val Adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items.get(0))
        subinding.signupAnimalSize.adapter=Adapter


        //signup_Btn
        subinding.signupLastBtn.setOnClickListener {
            //passward check(회원가입버튼 클릭 시)
            if(!validatePassword()){
                Log.d("password","unvalid")
                return@setOnClickListener
            }
            else{
                //Log.d("password","valid")
                val builder = AlertDialog.Builder(this)
                builder.setTitle("회원가입 완료!")
                    .setPositiveButton("확인",
                        DialogInterface.OnClickListener { dialog, which ->
                            Log.d("Alert","positive")
                            super.onBackPressed()
                        })
                // 다이얼로그를 띄워주기
                builder.create()
                builder.show()
            }
            //Post:: Allinfo
            {}
            // fail -> convert red message in failed place
            {}
            // success -> main_page

        }

    }
    //유효비밀번호 함수
    private fun validatePassword(): Boolean {
        val checkPassword: String = subinding.signupPasswordOverlapParent.editText?.text.toString()
        val password: String = subinding.signupPassword.text.toString()
        val passwordPattern ="""(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$"""
        return  if(!password.matches(passwordPattern.toRegex())){
            subinding.signupPasswordParent.error = "8자이상, 소문자, 대문자, 특수문자를 포함해야 합니다."
            false
        }
        else if (!checkPassword.equals(password)) {
            subinding.signupPasswordOverlapParent.error = "비밀번호가 같지 않습니다."
            false
        }
        else{
            true
        }
    }
}