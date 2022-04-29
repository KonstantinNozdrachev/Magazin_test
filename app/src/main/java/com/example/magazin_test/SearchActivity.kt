package com.example.magazin_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val magazinName = findViewById<EditText>(R.id.editTextTextPersonName)


        //String Phone = editTextPhone.getText().toString()


        //if (editTextPhone.getText().toString().equals(""))
        //{

        //}
        //else {


        val registerButton = findViewById<Button>(R.id.button2) as Button

        registerButton.setOnClickListener {


            val intent = Intent(this, SelectMagazinActivity::class.java)
            intent.putExtra("MagazinName", magazinName.text.toString())
            startActivity(intent)


        }

    }
}


