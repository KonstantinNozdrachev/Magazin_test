package com.example.magazin_test

data class errorMessage(
    val errorMessage: String,
    val errorMessageCode: String,
    val sessionId: String,
    val settings: Settings,
    val successful: Boolean
)