package com.example.magazin_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegistrationCodeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration_code)

        val editTextCode = findViewById<EditText>(R.id.editTextPhone)
        val code = editTextCode.text

        val phone = intent.extras?.getString("Phone")

        val textview = findViewById<TextView>(R.id.textView3)
        textview.text = phone


        //if (editTextPhone.getText().toString().equals(""))
        //{

        //}
        //else {


        val registerButton = findViewById<Button>(R.id.button) as Button

        registerButton.setOnClickListener {


            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)

            val apiInterface = ApiInterface.create().getCode("/$phone", "/$code")


            apiInterface.enqueue(object : Callback<errorMessage> {
                override fun onResponse(
                    call: Call<errorMessage>?,
                    response: Response<errorMessage>?
                ) {
                    response?.body()?.successful?.let {


                    }
//
                }

                override fun onFailure(call: Call<errorMessage>?, t: Throwable?) {

                }

            })
        }

    }
}

