package com.rach.foodappapi.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.rach.foodappapi.viewModel.MainViewModel

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CategoryDetailsScreen(viewModel: MainViewModel) {

    val selectedCategory by viewModel.selectedCategory.collectAsState()

    selectedCategory?.let { category ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(text = category.strCategory, textAlign = TextAlign.Center)

            GlideImage(
                model = category.strCategoryThumb,
                contentDescription = "${category.strCategory} Thumbnail",
                modifier = Modifier
                    .wrapContentSize()
                    .aspectRatio(1f)
            )

            Text(
                text = category.strCategoryDescription,
                textAlign = TextAlign.Justify,
                modifier = Modifier.verticalScroll(rememberScrollState())
            )


        }

    }
}