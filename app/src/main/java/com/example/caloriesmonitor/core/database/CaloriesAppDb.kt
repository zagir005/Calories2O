package com.example.caloriesmonitor.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.caloriesmonitor.core.database.dao.NutritionNormDao
import com.example.caloriesmonitor.core.database.dao.DinnerDao
import com.example.caloriesmonitor.core.database.dao.UserFoodDao
import com.example.caloriesmonitor.core.database.models.NutritionNormEntity
import com.example.caloriesmonitor.core.database.models.DinnerEntity
import com.example.caloriesmonitor.core.database.models.UserFoodEntity

@Database(entities = [UserFoodEntity::class, DinnerEntity::class, NutritionNormEntity::class], version = 1)
abstract class CaloriesAppDb: RoomDatabase() {
    abstract fun getFoodDao(): UserFoodDao

    abstract fun getDinnerDao(): DinnerDao

    abstract fun getNutritionNormDao(): NutritionNormDao
}