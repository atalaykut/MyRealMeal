package com.example.myrealmeal.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.myrealmeal.data.database.Meals
import com.example.myrealmeal.data.database.MealsDB
import com.example.myrealmeal.data.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = Repository(database = MealsDB.getDatabase(application.applicationContext))

    private val _recipes = MutableLiveData<List<Meals>>()
    val recipes: LiveData<List<Meals>>
        get() = _recipes


    private val _currentRecipe = MutableLiveData<Meals>()
    val currentRecipe: LiveData<Meals>
        get() = _currentRecipe

    init {
        repository.saveRecipes() // Jedes mal wenn ViewModel erstellt wird, ruft er die Daten ab und speichert diese ein
        getAll()
    }

    fun getVeggie() {
        viewModelScope.launch {
            _recipes.value = repository.getVeggie()
        }
    }

    fun getHalal() {
        viewModelScope.launch {
            _recipes.value = repository.getHalal()
        }
    }

    fun getAll() {
        viewModelScope.launch {
            _recipes.value = repository.getAll()
        }
    }

    fun getFavorites() {
        viewModelScope.launch {
            _recipes.value = repository.getFavorite()
        }

    }
    fun setCurrentRecipe(recipe: Meals) {
        _currentRecipe.value = recipe
    }

}
