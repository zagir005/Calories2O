package com.example.caloriesmonitor.screens.home.data.repository

import com.example.caloriesmonitor.core.database.CaloriesAppDb
import com.example.caloriesmonitor.core.reaction.Reaction
import com.example.caloriesmonitor.screens.home.data.mappers.NutritionNormMapper
import com.example.caloriesmonitor.screens.home.domain.models.Dinner
import com.example.caloriesmonitor.screens.home.domain.models.NutrientsNorm
import com.example.caloriesmonitor.screens.home.domain.repository.HomeRepository
import java.util.*

class HomeRepositoryImpl(
    private val caloriesAppDb: CaloriesAppDb
): HomeRepository {

    private val nutrientsMapper = NutritionNormMapper()
    private val nutrientsNormDao = caloriesAppDb.getNutritionNormDao()

    override suspend fun getDinnersByDate(date: Date): Reaction<List<Dinner>> {
        return Reaction.IsEmpty()
    }

    override suspend fun getNutritionNormByDate(date: Date): Reaction<NutrientsNorm> {
//        return try {
//            val nutrientsNorm = nutrientsNormDao.getNutritionNorm(date.time)
//            if (nutrientsNorm == null){
//                Reaction.OnSuccess(
//                    nutrientsMapper.map(setNutritionNormByDate(date))
//                )
//            }else{
//                Reaction.OnSuccess(
//                    nutrientsMapper.map(nutrientsNorm)
//                )
//            }
//        }catch (e: java.lang.Exception){
//            Reaction.OnError(e)
//        }
        return Reaction.IsEmpty()
    }

    override suspend fun insertNutritionNormByDate(nutrientsNorm: NutrientsNorm): Reaction<Unit> {

        nutrientsNormDao.insertNutritionNorm(nutrientsMapper.mapToData(nutrientsNorm))

    }
}
