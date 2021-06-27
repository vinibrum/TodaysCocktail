package com.devventure.todayscocktail.data.model

import com.google.gson.annotations.SerializedName

data class DrinkDetailList(
    @SerializedName("drinks")
    val drinkDetailList: List<DrinkDetail>
)