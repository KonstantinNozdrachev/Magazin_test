package com.example.magazin_test

data class PhoneObject(
    val campaigns: List<Any>,
    val errorMessage: String,
    val errorMessageCode: String,
    val more: Boolean,
    val moreCampaigns: Boolean,
    val products: List<Product>,
    val settings: Any,
    val successful: Boolean
)