package com.learn.ecommersapp.screens.home


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(){
    TopAppBar(
        title={ Text(text="ShopEasy",
            style=MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.Bold,
                color=MaterialTheme.colorScheme.onPrimary
            )) },
        colors=TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF1565c0),
            titleContentColor = Color.White
        ),
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "Cart",
                    tint = Color.White
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Profile",
                    tint = Color.White
                )
            }
        }
    )
}