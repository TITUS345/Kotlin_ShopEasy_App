package com.learn.ecommersapp.screens.home.categories

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.learn.ecommersapp.model.Category
import com.learn.ecommersapp.screens.home.navigation.Screens

@Composable
fun CategoryScreen(
    navController: NavController
){
    val categories: List<Category> = listOf(
        Category(1,"Electronics","https://cdn-icons-png.flaticon.com/128/2777/2777142.png"),

        Category(2,"Clothing","https://cdn-icons-png.flaticon.com/128/2954/2954918.png")

    )

    Column {
        if(categories.isEmpty()){
            Box(modifier = Modifier.fillMaxSize().padding(16.dp)){
                Text(text="No Categories Found",
                    style = MaterialTheme.typography.bodyLarge)
            }
        }else{
            //Categories Title
            Text(text="Categories ",
                style=MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(top=30.dp))
            //Categories Grid

            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                contentPadding = PaddingValues(8.dp),
                verticalArrangement = Arrangement.spacedBy (12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp)
            ) {
                items (categories){ category->
                    CategoryItem(
                        category=category,
                        onClick = {
                            //.navigate(
                                /*Handle Click Event on categories*/
                            //)
                            navController.navigate(
                                Screens.ProductList.createRoute(category.id.toString())
                            )
                        }
                    )
                }
            }
        }
    }

}