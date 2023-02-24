package com.example.caloriesmonitor.core.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.caloriesmonitor.core.database.models.NutritionNormEntity

@Dao
interface NutritionNormDao {

    @Insert(entity = NutritionNormEntity::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNutritionNorm(nutritionNormEntity: NutritionNormEntity)

    @Query("SELECT * FROM day_settings_table WHERE day = :day")
    suspend fun getNutritionNorm(day: Long): NutritionNormEntity?

    @Delete
    suspend fun deleteNutritionNorm(nutritionNormEntity: NutritionNormEntity)

    @Query("DELETE from day_settings_table WHERE day = :day")
    suspend fun deleteNutritionNorm(day: Long)

    suspend fun updateNutritionNorm(nutritionNormEntity: NutritionNormEntity): NutritionNormEntity {
        deleteNutritionNorm(nutritionNormEntity.day)
        insertNutritionNorm(nutritionNormEntity)
        return getNutritionNorm(nutritionNormEntity.day)!!
    }
}