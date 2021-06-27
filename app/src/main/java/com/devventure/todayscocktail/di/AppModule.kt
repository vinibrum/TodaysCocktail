package com.devventure.todayscocktail.di

import com.devventure.todayscocktail.data.db.CocktailDatabase
import com.devventure.todayscocktail.data.repository.DrinkDetailRepository
import com.devventure.todayscocktail.data.repository.DrinkRepository
import com.devventure.todayscocktail.presentation.DrinkViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object AppModule {
    val module = module {
        factory {
            DrinkRepository(get())
        }
        factory {
            DrinkDetailRepository(get())
        }
        single {
            CocktailDatabase.getDatabase(context = get())
        }
        single {
            get<CocktailDatabase>().drinksDao()
        }
        single {
            get<CocktailDatabase>().drinkDetailDao()
        }
        viewModel{
            DrinkViewModel(get(), get())
        }
    }

}