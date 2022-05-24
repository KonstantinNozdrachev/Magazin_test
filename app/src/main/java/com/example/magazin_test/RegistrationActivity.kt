package com.example.magazin_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.KeyEvent
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //supportActionBar?.title=""




        val editTextPhone = findViewById<EditText>(R.id.editTextPhone)
        val Phone = editTextPhone.text



        val registerButton = findViewById<Button>(R.id.button) as Button

        registerButton.setOnClickListener {

        if (editTextPhone.getText().toString().equals(""))
        {
        val text = "Введите номер"
        val duration = Toast.LENGTH_LONG
        Toast.makeText(applicationContext, text, duration).show()


        }
        else {





            val intent = Intent(this, RegistrationCodeActivity::class.java)
            intent.putExtra("Phone", editTextPhone.text.toString())
            startActivity(intent)

            val apiInterface = ApiInterface.create().getPhone("$Phone")


            apiInterface.enqueue(object : Callback<Phone> {
                override fun onResponse(call: Call<Phone>?, response: Response<Phone>?) {
                    response?.body()?.successful?.let {


                    }

                }

                override fun onFailure(call: Call<Phone>?, t: Throwable?) {

                }

            })
        }

    }

    //override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //if (item.itemId == android.R.id.home) finish()
        //return true
    }
}






