package com.example.caloriesmonitor.core.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user_food_table")
data class UserFoodEntity(
    @ColumnInfo val name: String,
    @ColumnInfo val calorie: Float,
    @ColumnInfo val protein: Float,
    @ColumnInfo val fat : Float,
    @ColumnInfo val carbohydrates: Float,
    @PrimaryKey(autoGenerate = true) val myId: Int = 0
)