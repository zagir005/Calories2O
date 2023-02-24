package com.example.caloriesmonitor.core.extensions

import android.util.Log

fun Any?.logPrint(){
    Log.d("MYTAG",this.toString())
}

fun logPrint(msg: Any?, tag: String = "MYTAG"){
    Log.d(tag,msg.toString())
}

fun String.divideFoodName(): DividedFoodName {
    val name = substringBefore('[')
    val brand = substringAfter('[').substringBefore(']')
    return DividedFoodName(name,brand)
}

data class DividedFoodName(
    val name: String,
    val brand: String
)