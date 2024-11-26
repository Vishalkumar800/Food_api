package com.rach.foodappapi.navigation

sealed class Screen(
    val route:String
) {

    object RecipeScreen:Screen("recipeScreen")
    object DetailScreen:Screen("detailsScreen")

}