package com.devventure.todayscocktail.data.db

import androidx.room.Dao
import androidx.room.Query
import com.devventure.todayscocktail.data.model.Drink

@Dao
interface DrinkDao {

    @Query("SELECT * FROM drinks_entity")
    suspend fun getAllDrinks(): List<Drink>
}