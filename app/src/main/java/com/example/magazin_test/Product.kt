package com.example.magazin_test

data class Product(
    val actions: List<ActionX>,
    val campaignImageUrl: String,
    val campaignName: String,
    val cashback: String,
    val id: Int,
    val imageUrls: List<String>,
    val name: String,
    val paymentTime: String,
    val price: String
)