package com.devventure.todayscocktail.data.repository

import com.devventure.todayscocktail.data.model.DrinkDetail

interface IDrinkDetailRepository {
    suspend fun getDrinkDetail(idDrink: String): List<DrinkDetail>?
}