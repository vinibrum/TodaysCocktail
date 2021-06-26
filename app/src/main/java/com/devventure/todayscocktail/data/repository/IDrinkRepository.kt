package com.devventure.todayscocktail.data.repository

import com.devventure.todayscocktail.data.model.Drink

interface IDrinkRepository {
    suspend fun getAllDrinks(): List<Drink>?
}