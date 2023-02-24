package com.example.caloriesmonitor.core.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "day_settings_table")
data class NutritionNormEntity(
    @PrimaryKey val day: Long,
    @ColumnInfo val calories: Float = 0f,
    @ColumnInfo val fat: Float = 0f,
    @ColumnInfo val protein: Float = 0f,
    @ColumnInfo val carbohydrate: Float = 0f,
)
