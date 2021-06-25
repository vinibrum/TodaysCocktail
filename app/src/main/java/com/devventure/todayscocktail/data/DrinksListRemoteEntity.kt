package com.devventure.todayscocktail.data

import com.google.gson.annotations.SerializedName

data class DrinksListRemoteEntity(
    @SerializedName("drinks")
    val drinkRemoteEntities: List<DrinkRemoteEntity>
)