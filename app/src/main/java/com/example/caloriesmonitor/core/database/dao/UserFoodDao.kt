package com.example.caloriesmonitor.core.database.dao

import androidx.room.*
import com.example.caloriesmonitor.core.database.models.UserFoodEntity

@Dao
interface UserFoodDao {
    @Insert(entity = UserFoodEntity::class)
    suspend fun insertFood(vararg userFoodEntity: UserFoodEntity)

    @Insert(entity = UserFoodEntity::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFood(userFoodEntity: List<UserFoodEntity>)

    @Delete
    suspend fun deleteFood(userFoodEntity: UserFoodEntity)
}