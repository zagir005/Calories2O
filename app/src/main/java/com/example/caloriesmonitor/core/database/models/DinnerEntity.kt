package com.example.caloriesmonitor.core.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dinner_table")
data class DinnerEntity(
    @ColumnInfo val name: String,
    @ColumnInfo val day: Long,
    @ColumnInfo val foodId: Int,
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
)
