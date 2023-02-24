package com.example.caloriesmonitor.screens.home.domain.repository

import com.example.caloriesmonitor.core.reaction.Reaction
import com.example.caloriesmonitor.screens.home.domain.models.Dinner
import com.example.caloriesmonitor.screens.home.domain.models.NutrientsNorm
import java.util.Date

interface HomeRepository {

    suspend fun getDinnersByDate(date: Date): Reaction<List<Dinner>>

    suspend fun getNutritionNormByDate(date: Date): Reaction<NutrientsNorm>

    suspend fun insertNutritionNormByDate(nutrientsNorm: NutrientsNorm): Reaction<Unit>
}