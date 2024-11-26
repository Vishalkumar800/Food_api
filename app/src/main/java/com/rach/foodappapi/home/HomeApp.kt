package com.rach.foodappapi.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.rach.foodappapi.navigation.MyApp
import com.rach.foodappapi.viewModel.MainViewModel

@Composable
fun HomeApp() {
    val navController = rememberNavController()
    val viewModel: MainViewModel = viewModel()
    Scaffold(
        topBar = {
            GloballyTopAppBar(
                title = "Home",
                modifier = Modifier,
                onMenuIconClick = {}
            )
        }
    ) { paddingValues ->

        MyApp(
            navController = navController,
            viewModel = viewModel, paddingValues = paddingValues
        )

    }
}