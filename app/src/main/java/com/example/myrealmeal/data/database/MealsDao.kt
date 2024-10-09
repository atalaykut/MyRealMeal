package com.example.myrealmeal.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy


//Dao ist die SQL Abfrage für die Datenbank
@Dao
interface MealsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert (meals: Meals)
}






