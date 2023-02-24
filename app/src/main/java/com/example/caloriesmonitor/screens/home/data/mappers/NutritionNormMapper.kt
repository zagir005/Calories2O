package com.example.caloriesmonitor.screens.home.data.mappers

import com.example.caloriesmonitor.core.database.models.NutritionNormEntity
import com.example.caloriesmonitor.core.models.domainmodels.Nutrients
import com.example.caloriesmonitor.screens.home.domain.models.NutrientsNorm
import java.util.*

class NutritionNormMapper {
    fun mapToDomain(nutritionNormEntity: NutritionNormEntity): NutrientsNorm{
        return NutrientsNorm(
            Date(nutritionNormEntity.day),
            Nutrients(
                nutritionNormEntity.calories,
                nutritionNormEntity.fat,
                nutritionNormEntity.protein,
                nutritionNormEntity.carbohydrate
            )
        )
    }

    fun mapToData(nutrientsNorm: NutrientsNorm): NutritionNormEntity{
        return NutritionNormEntity(
            nutrientsNorm.date.time,
            nutrientsNorm.nutrientsStat.calories,
            nutrientsNorm.nutrientsStat.fat,
            nutrientsNorm.nutrientsStat.protein,
            nutrientsNorm.nutrientsStat.carbohydrate,
        )
    }
}