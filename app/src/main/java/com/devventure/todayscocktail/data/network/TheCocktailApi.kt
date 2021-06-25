package com.devventure.todayscocktail.data.network

import com.devventure.todayscocktail.data.DrinksListRemoteEntity
import retrofit2.http.GET

interface TheCocktailApi {
    @GET("filter.php?a=Alcoholic")
    suspend fun getDrinks(): DrinksListRemoteEntity

    @GET("filter.php?a=Non_Alcoholic")
    suspend fun getDrinksNonAlcoholic(): DrinksListRemoteEntity
}