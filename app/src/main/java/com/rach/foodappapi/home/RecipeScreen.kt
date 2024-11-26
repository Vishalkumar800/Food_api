package com.rach.foodappapi.home

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.rach.foodappapi.dataClass.Category
import com.rach.foodappapi.viewModel.MainViewModel

@Composable
fun RecipeScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel,
    navigateToDetail: () -> Unit
) {

    val viewState by viewModel.categoriesState.collectAsState()
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        when {
            viewState.loading -> {
                CircularProgressIndicator()
            }

            viewState.error != null -> {
                Text(text = "Error Occurred")
            }

            else -> {
                CategoryScreen(viewModel = viewModel, navigateToDetail = { navigateToDetail() })
            }
        }
    }

}

@Composable
fun CategoryScreen(
    viewModel: MainViewModel,
    navigateToDetail: () -> Unit
) {

    val categoriesState by viewModel.categoriesState.collectAsState()

    LazyVerticalGrid(
        GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize()
    ) {
        items(categoriesState.list) { category ->
            CategoryItem(
                category = category,
                navigateToDetail = {
                    viewModel.selectCategory(category)
                    navigateToDetail()
                }
            )

        }
    }

}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CategoryItem(
    category: Category,
    navigateToDetail: () -> Unit
) {


    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
            .clickable { navigateToDetail() },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        GlideImage(
            model = category.strCategoryThumb,
            contentDescription = "bhjjh",
            modifier = Modifier
                .fillMaxSize()
                .aspectRatio(1f)
        )


        Text(
            text = category.strCategory,
            color = MaterialTheme.colorScheme.onBackground,
            style = TextStyle(
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Preview(name = "Light", uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Preview(name = "Dark", uiMode = UI_MODE_NIGHT_YES)
annotation class RecipeAppPreview

