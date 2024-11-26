package com.rach.foodappapi.home

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GloballyTopAppBar(
    title: String,
    modifier: Modifier,
    onMenuIconClick: () -> Unit
) {
    TopAppBar(
        modifier = Modifier.shadow(
            elevation = 4.dp, shape = RectangleShape,
            spotColor = MaterialTheme.colorScheme.primary
        ),
        title = {
            Text(
                text = title,
                fontWeight = FontWeight.SemiBold,
                modifier = modifier.padding(start = 18.dp)
            )
        },
        navigationIcon = {
            when {
                title == "Home" -> {
                    IconButton(onClick = { onMenuIconClick() }) {
                        Icon(imageVector = Icons.Default.Home, contentDescription = "menu icon",
                            modifier = Modifier.size(24.dp))

                    }
                }

                else ->
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Arrow Back icon"
                        )
                    }
            }
        }
    )
}