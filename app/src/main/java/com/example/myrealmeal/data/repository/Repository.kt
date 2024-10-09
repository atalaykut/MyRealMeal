package com.example.myrealmeal.data.repository

import android.util.Log
import com.example.myrealmeal.data.database.Meals
import com.example.myrealmeal.data.database.MealsDB
import com.example.myrealmeal.data.remote.Api
import com.example.myrealmeal.data.remote.RecipesApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Repository(
    private val api: Api = RecipesApi.retrofitService,
    private val database: MealsDB
) {
    // lädt rezepte und speichert diese ein
    fun saveRecipes() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = api.getRecipesApi()
            response.meals.forEach {
                database.mealsDao.insert(it)
                Log.d("Repository", "saveRecipes: $it")
            }
        }
    }

    suspend fun getAll(): List<Meals> {
        return database.mealsDao.getAll()
    }

    suspend fun getVeggie(): List<Meals> {
        return database.mealsDao.getVeggie()
    }

    suspend fun getHalal(): List<Meals> {
        return database.mealsDao.getHalal()
    }

    suspend fun getFavorite(): List<Meals> {
        return database.mealsDao.getFavorite()
    }
    suspend fun insertFavorite(meal: Meals) {
        database.mealsDao.insert(meal)

    }

}