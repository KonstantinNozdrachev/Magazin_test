package com.example.magazin_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/*class SelectObjectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_object)




        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)


        recyclerview.layoutManager = GridLayoutManager(this,1)


        val data = ArrayList<ItemsViewModel2>()


        for (i in 1..20) {

            data.add(ItemsViewModel2(R.drawable.ic_launcher_background, "Item " + i))
        }



        val apiInterface = ApiInterface.create().getPhoneObject("aliexpress")





        apiInterface.enqueue(object : Callback<PhoneObject>, CustomAdapter.ItemClickListener {
            override fun onResponse(call: Call<PhoneObject>?, response: Response<PhoneObject>?) {
                response?.body()?.products?.let {
                    val adapter = CustomAdapter2(it,this)




                    recyclerview.adapter = adapter
                }

            }

            override fun onFailure(call: Call<PhoneObject>?, t: Throwable?) {

            }

            override fun onItemClick(id: Int) {
                val intent = Intent (this@SelectObjectActivity,ObjectActivity::class.java)
                intent.putExtra("id",id)
                startActivity(intent)

            }
        })

    }
}
*/