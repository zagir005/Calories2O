package com.example.caloriesmonitor.screens.home.domain.models

import com.example.caloriesmonitor.core.models.domainmodels.Nutrients
import java.io.Serializable
import java.util.Date


data class NutrientsNorm(
    val date: Date,
    val nutrientsStat: Nutrients
): Serializable
