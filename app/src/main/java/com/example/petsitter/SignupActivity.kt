package com.example.petsitter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
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

        //passward check

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
            //Post:: Allinfo
            {}
            // fail -> convert red message in failed place
            {}
            // success -> main_page
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }


    }

}