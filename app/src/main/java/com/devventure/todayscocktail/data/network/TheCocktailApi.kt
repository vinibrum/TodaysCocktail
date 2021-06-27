package com.devventure.todayscocktail.data.network

import com.devventure.todayscocktail.data.model.DrinkDetailList
import com.devventure.todayscocktail.data.model.DrinkList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TheCocktailApi {
    @GET("filter.php?a=Alcoholic")
    suspend fun getCocktail(): Response<DrinkList>

    @GET("lookup.php")
    suspend fun getCocktailDetail(@Query("i") idDrink: String): Response<DrinkDetailList>
}