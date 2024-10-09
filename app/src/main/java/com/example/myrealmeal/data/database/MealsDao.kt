package com.example.myrealmeal.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


//Dao ist die SQL Abfrage für die Datenbank
@Dao
interface MealsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert (meals: Meals)

    @Query("SELECT * FROM meals_table")
    suspend fun getAll(): List<Meals>

    @Query("SELECT * FROM meals_table WHERE veggie is 1")
    suspend fun getVeggie(): List<Meals>

    @Query("SELECT * FROM meals_table WHERE halal is 1")
    suspend fun getHalal(): List<Meals>

    @Query("SELECT * FROM meals_table WHERE favorite is 1")
    suspend fun getFavorite(): List<Meals>


}






