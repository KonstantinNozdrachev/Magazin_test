package com.example.magazin_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer

import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.view.inputmethod.InputMethodManager




class RegistrationCodeActivity : AppCompatActivity() {

    private var timer:CountDownTimer?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration_code)

        val editTextCode = findViewById<EditText>(R.id.editTextPhone)
        val code = editTextCode.text

        val phone = intent.extras?.getString("Phone")

        val textview = findViewById<TextView>(R.id.textView3)
        textview.text = phone







        val registerButton = findViewById<Button>(R.id.button) as Button

        registerButton.setOnClickListener {


            

       if (editTextCode.getText().toString().equals("")) {
            val text = "Введите код"
            val duration = Toast.LENGTH_LONG
            Toast.makeText(applicationContext, text, duration).show()


        }
        else {
           try {
               val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
               imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
           } catch (e: Exception) {

           }

                registerButton.setVisibility(View.GONE)




                val intent = Intent(this, SearchActivity::class.java)


                val apiInterface = ApiInterface.create().getCode("$phone", "$code")


                apiInterface.enqueue(object : Callback<errorMessage> {
                    override fun onResponse(
                        call: Call<errorMessage>?,
                        response: Response<errorMessage>?
                    ) {

                        val successful = response?.body()?.successful
                        if(successful?.equals(true)!!){
                            //  не response?.body()?.successful?.let {
                                startActivity(intent)
                        }
                        else {
                            val text = response.body()?.errorMessage
                            val duration = Toast.LENGTH_LONG



                            Toast.makeText(applicationContext, text, duration).show()
                            //Счётчик    //Thread.sleep(2000) // пауза на 1 мин

                            startTimer(60000)
                            if(timer?.equals("Отправить повторно?")!!) {


                            }
                        }





                    }

                    private fun startTimer(timeMillis:Long){


                        timer?.cancel()

                        timer = object : CountDownTimer(timeMillis,1) {
                            override fun onTick(timerM: Long) {
                                val timer = findViewById<TextView>(R.id.timer)
                                timer.text=timerM.toString()
                            }

                            override fun onFinish() {
                                val timer = findViewById<TextView>(R.id.timer)
                                timer.text = "Отправить повторно?"
                                registerButton.setVisibility(View.VISIBLE)
                            }

                        }.start()
                    }
                    override fun onFailure(call: Call<errorMessage>?, t: Throwable?) {

                    }

                })
            }


        }

    }


    }




