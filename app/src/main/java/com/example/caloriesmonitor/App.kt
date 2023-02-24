package com.example.caloriesmonitor

import android.app.Application
import androidx.room.Room
import com.example.caloriesmonitor.core.database.CaloriesAppDb

class App: Application() {
    val caloriesAppDb: CaloriesAppDb by lazy {
        Room.databaseBuilder(
            this,
            CaloriesAppDb::class.java,
            "CaloriesAppDb"
        ).build()
    }
}