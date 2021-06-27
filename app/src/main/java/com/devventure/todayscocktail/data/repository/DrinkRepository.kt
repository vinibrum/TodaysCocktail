package com.devventure.todayscocktail.data.repository

import com.devventure.todayscocktail.data.db.DrinkDao
import com.devventure.todayscocktail.data.model.Drink
import com.devventure.todayscocktail.data.network.CocktailService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DrinkRepository(private val dao: DrinkDao) : IDrinkRepository {

    /**
     * Recupera os dados do banco, se não existirem irá requisitar para a API
     */
    override suspend fun getAllDrinks(): List<Drink>? {
        return getDrinksFromDB()
    }

    private suspend fun getDrinksFromDB(): List<Drink>? {
        var drinks: List<Drink>? = dao.getAllDrinks()
        if (drinks.isNullOrEmpty())
            drinks = getDrinksFromAPI()
        return drinks
    }

    private suspend fun getDrinksFromAPI(): List<Drink>? {
        return withContext(Dispatchers.IO) {
            val response = CocktailService.service.getCocktail()
            val drinkList =  response.body()?.drinks
            drinkList?.let {dao.saveDrinksToDB(it)}
            drinkList
        }
    }

}