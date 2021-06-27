package com.devventure.todayscocktail.data.repository

import com.devventure.todayscocktail.data.db.DrinkDetailDao
import com.devventure.todayscocktail.data.model.DrinkDetail
import com.devventure.todayscocktail.data.network.CocktailService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DrinkDetailRepository(private val dao: DrinkDetailDao) : IDrinkDetailRepository {

    override suspend fun getDrinkDetail(idDrink: String): List<DrinkDetail>? {
        return getDrinkDetailFromAPI(idDrink)
    }

    private suspend fun getDrinkDetailFromAPI(idDrink: String): List<DrinkDetail>? {
        return withContext(Dispatchers.IO) {
            val response = CocktailService.service.getCocktailDetail(idDrink)
            val drinkDetailList = response.body()?.drinkDetailList
            drinkDetailList
        }
    }
}