package com.devventure.todayscocktail.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.devventure.todayscocktail.data.model.Drink

@Dao
interface DrinkDao {

    @Query("SELECT * FROM drinks_entity")
    suspend fun getAllDrinks(): List<Drink>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveDrinksToDB(drinks:List<Drink>)
}