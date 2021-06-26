package com.devventure.todayscocktail.data.network

import com.devventure.todayscocktail.data.model.DrinkList
import retrofit2.Response
import retrofit2.http.GET

interface TheCocktailApi {
    @GET("filter.php?a=Alcoholic")
    suspend fun getCocktail(): Response<DrinkList>
}