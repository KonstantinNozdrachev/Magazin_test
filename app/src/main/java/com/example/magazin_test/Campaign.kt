package com.example.magazin_test

data class Campaign(
    //val actions: Int,
    val cashback: String,
    val id: Int,
    val imageUrl: String,
    val name: String,
    val paymentTime: String
): ListItem {
    override fun getViewType(): Int {
        return CustomAdapter.CAMPAIGN
    }
}