package com.example.gamecarx

data class Card(val id_card:String, val name:String, val power:String, val keywords_raw:String, val description:String) {
    val keywords:List<String>
        get() = keywords_raw.split(",")
}
