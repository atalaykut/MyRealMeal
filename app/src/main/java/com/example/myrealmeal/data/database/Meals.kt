package com.example.myrealmeal.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Entity(tableName = "meals_table")
data class Meals(
    @PrimaryKey(autoGenerate = true) //Primary Key wird automatisch generiert
    val id: Int,

    val name: String = "",
    val ingredients: List<Ingredient> = emptyList(),
    val preparation: String = "",
    val image: String = "",
    val time: String = "",
    val calories: Double = 0.0,
    val carbs: Double = 0.0,
    val protein: Double = 0.0,
    val fat: Double = 0.0,
    val veggie: Boolean = false,
    val halal: Boolean = false,
    var favorite: Boolean = false
)

data class Ingredient(
    val name: String = "Mehl",
    val amount: Double = 0.0,
    val unit: String = "Kg"
)


class Converters {

    private val gson = Gson()

    @TypeConverter
    fun fromIngredientList(ingredients: List<Ingredient>): String {
        return gson.toJson(ingredients)
    }

    @TypeConverter
    fun toIngredientList(data: String): List<Ingredient> {
        val listType = object : TypeToken<List<Ingredient>>() {}.type
        return gson.fromJson(data, listType) ?: emptyList()
    }
}







