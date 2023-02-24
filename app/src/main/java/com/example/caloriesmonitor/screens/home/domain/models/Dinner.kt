package com.example.caloriesmonitor.screens.home.domain.models

import com.example.caloriesmonitor.core.models.domainmodels.Food
import java.util.Date

data class Dinner(
    val id: Int,
    val date: Date,
    val food: List<Food>
)
