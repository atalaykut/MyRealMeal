package com.example.myrealmeal.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Meals::class], version = 1)
abstract class MealsDB : RoomDatabase() {
    abstract val mealsDao : MealsDao


    companion object {private lateinit var database: MealsDB

        fun getDatabase(context: Context) : MealsDB {
            synchronized(this) {
                if (!this::database.isInitialized) {
                    database = Room.databaseBuilder(
                        context.applicationContext,
                        MealsDB::class.java,
                        "meals_database"
                    ).build()
                }
                return database
            }
        }
    }
}

