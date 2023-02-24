package com.example.caloriesmonitor.core.network.models

import com.google.gson.annotations.SerializedName

data class FoodSearch(
    val result: Result,
    val success: Int,
    val error: String
)
data class Result(
    @SerializedName("list") val foodList: List<FoodInfo>
)
data class FoodInfo(
    val food: Food
)
data class Food(
    @SerializedName("local_id") val id: String,
    val name: String,
    @SerializedName("nutrientsShort") val nutrients: ApiNutrients
)

data class ApiNutrients(
    @SerializedName("11") val calorie: String?,
    @SerializedName("13") val protein: String?,
    @SerializedName("14") val fat : String?,
    @SerializedName("15") val carbohydrates: String?,
)
