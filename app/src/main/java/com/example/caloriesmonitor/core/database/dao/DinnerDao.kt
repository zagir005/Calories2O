package com.example.caloriesmonitor.core.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.caloriesmonitor.core.database.models.DinnerEntity

@Dao
interface DinnerDao {

    @Insert(entity = DinnerEntity::class)
    suspend fun insertDinner(dinnerEntity: DinnerEntity)

    @Insert(entity = DinnerEntity::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDinnersList(dinnerEntity: List<DinnerEntity>)

    @Query("SELECT * from dinner_table")
    suspend fun getAllDinners(): List<DinnerEntity>

    @Query("SELECT * from dinner_table WHERE day =:day")
    suspend fun getDinnersByDay(day:Long): List<DinnerEntity>

    @Delete
    suspend fun deleteDinner(dinnerEntity: DinnerEntity)

}