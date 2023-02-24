package com.example.caloriesmonitor.core.models.domainmodels

import android.os.Parcelable
import com.example.caloriesmonitor.screens.home.domain.models.NutrientsNorm
import kotlinx.parcelize.Parcelize

@Parcelize
data class Nutrients(
    val calories: Float,
    val fat: Float,
    val protein: Float,
    val carbohydrate: Float,
):Parcelable{
    companion object{
        fun getEmptyNutrients() =
            Nutrients(0f,0f,0f,0f)


    }
}
