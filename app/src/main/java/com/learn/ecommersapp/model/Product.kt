package com.learn.ecommersapp.model

data class Product(
    val id:String,
    val name:String,
    val price: Double=0.0,
    val imageUrl: String,
    val categoryId:String,
    val icon: String="https://cdn-icons-png.flaticon.com/128/1828/1828884.png"

)
