package com.example.magazin_test

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {
    @GET("search")
    fun getCampaigns(@Query("search_string") search: String): Call<Magazin>

    @GET("search")
    fun getPhoneObject(@Query("search_string") search: String): Call<PhoneObject>

    @GET("login_step1")
    fun getPhone(@Query("phone") phone: String): Call<Phone>

    @GET("login_step2")
    fun getCode(
        @Query("phone") phone: String,
        @Query("password") password: String
    ): Call<errorMessage>


    companion object {

        var BASE_URL = "https://utcoin.one/loyality/"

        fun create(): ApiInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)

        }
    }
}

