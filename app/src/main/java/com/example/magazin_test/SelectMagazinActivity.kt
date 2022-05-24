package com.example.magazin_test


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SelectMagazinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_magazin)


        val magazinName = intent.extras?.getString("MagazinName").orEmpty()

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)


        recyclerview.layoutManager = GridLayoutManager(this, 2)


        val apiInterface = ApiInterface.create().getCampaigns(magazinName)





        apiInterface.enqueue(object : Callback<SearchResponse>, CustomAdapter.ItemClickListener {
            override fun onResponse(call: Call<SearchResponse>?, response: Response<SearchResponse>?) {

                val body = response?.body()
                val campaigns = body?.campaigns ?: emptyList()
                val products = body?.products ?: emptyList()
                val adapter = CustomAdapter(campaigns, products, this)


                recyclerview.adapter = adapter
            }

            override fun onFailure(call: Call<SearchResponse>?, t: Throwable?) {

            }

            override fun onItemClick(id: Int) {
                val intent = Intent(this@SelectMagazinActivity, ObjectActivity::class.java)
                intent.putExtra("id", id)
                startActivity(intent)

            }
        })

    }
}
