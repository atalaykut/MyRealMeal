package com.example.myrealmeal.data.remote

import com.example.myrealmeal.data.database.RecipeResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


const val BASE_URL = "https://aykutatalay.mlm4u.eu"

private val logger = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}

private val client = OkHttpClient.Builder()
    .addInterceptor(logger)
    .build()

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .client(client)
    .build()

interface Api {

    @GET("api/recipes.json")
    suspend fun getRecipesApi(): RecipeResponse
}

object RecipesApi {
    val retrofitService: Api by lazy {
        retrofit.create(Api::class.java)
    }
}