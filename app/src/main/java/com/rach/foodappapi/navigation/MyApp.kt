package com.rach.foodappapi.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rach.foodappapi.dataClass.Category
import com.rach.foodappapi.home.CategoryDetailsScreen
import com.rach.foodappapi.home.RecipeScreen
import com.rach.foodappapi.viewModel.MainViewModel

@Composable
fun MyApp(navController: NavController, viewModel: MainViewModel, paddingValues: PaddingValues) {

    NavHost(
        navController = navController as NavHostController,
        modifier = Modifier.padding(paddingValues),
        startDestination = Screen.RecipeScreen.route
    ) {

        composable(Screen.RecipeScreen.route) {

            RecipeScreen(viewModel = viewModel) {
                navController.navigate(Screen.DetailScreen.route)
            }

        }

        composable(Screen.DetailScreen.route) {
            CategoryDetailsScreen(viewModel = viewModel)
        }
    }
}