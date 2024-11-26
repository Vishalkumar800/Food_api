package com.rach.foodappapi.api

import com.rach.foodappapi.dataClass.CategoriesResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

// service or end points
private val retrofit = Retrofit.Builder().baseUrl("https://www.themealdb.com/api/json/v1/1/")
    .addConverterFactory(GsonConverterFactory.create()) // jo mil rha hai usko json se convert krna hai kotlin object me
    .build()

val recipeService = retrofit.create(ApiService::class.java)

interface ApiService {
    // end points
    @GET("categories.php")
    suspend fun getCategories(): CategoriesResponse
}