package com.example.magazin_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Button
import android.widget.EditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val editTextPhone = findViewById<EditText>(R.id.editTextPhone)
        val Phone = editTextPhone.text


        //String Phone = editTextPhone.getText().toString()


        //if (editTextPhone.getText().toString().equals(""))
        //{

        //}
        //else {


        val registerButton = findViewById<Button>(R.id.button) as Button

        registerButton.setOnClickListener {


            val intent = Intent(this, RegistrationCodeActivity::class.java)
            intent.putExtra("Phone", editTextPhone.text.toString())
            startActivity(intent)

            val apiInterface = ApiInterface.create().getPhone("/$Phone")


            apiInterface.enqueue(object : Callback<Phone> {
                override fun onResponse(call: Call<Phone>?, response: Response<Phone>?) {
                    response?.body()?.successful?.let {


                    }
//
                }

                override fun onFailure(call: Call<Phone>?, t: Throwable?) {

                }

            })
        }

    }
}


//}



