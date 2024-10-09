package com.example.myrealmeal.data.repository

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
    fun saveRecpies() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = api.getRecipesApi()
            response.meals.forEach {
                database.mealsDao.insert(it)
            }
        }
    }
}