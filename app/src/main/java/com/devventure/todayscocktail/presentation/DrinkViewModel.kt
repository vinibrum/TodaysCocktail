package com.devventure.todayscocktail.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devventure.todayscocktail.data.model.Drink
import com.devventure.todayscocktail.data.model.DrinkDetail
import com.devventure.todayscocktail.data.repository.DrinkRepository
import com.devventure.todayscocktail.data.repository.DrinkDetailRepository
import kotlinx.coroutines.launch

class DrinkViewModel(private val drinkRepository: DrinkRepository, private val drinkDetailRepository: DrinkDetailRepository) : ViewModel() {

    private val _selectedDrink: MutableLiveData<Drink> = MutableLiveData()
    private val _drinkDetails: MutableLiveData<List<DrinkDetail>> = MutableLiveData()
    val selectedDrink: LiveData<Drink>
        get() = _selectedDrink
    val drinkDetails: LiveData<List<DrinkDetail>>
        get() = _drinkDetails

    private var drinks: MutableLiveData<List<Drink>> = MutableLiveData()

    fun getDrinks(): LiveData<List<Drink>> {
        viewModelScope.launch {
            val result = drinkRepository.getAllDrinks()
            drinks.postValue(result)
        }
        return drinks
    }

    fun setSelectedDrink(item: Drink) {
        _selectedDrink.value = item
        getDrinkDetail()
    }

    private fun getDrinkDetail() {
        viewModelScope.launch {
            val result = drinkDetailRepository.getDrinkDetail(selectedDrink.value?.id.toString())
            _drinkDetails.postValue(result)
        }
    }
}