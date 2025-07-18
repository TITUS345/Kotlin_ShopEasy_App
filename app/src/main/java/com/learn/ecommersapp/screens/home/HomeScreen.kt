package com.learn.ecommersapp.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.learn.ecommersapp.model.Category
import com.learn.ecommersapp.model.Product
import com.learn.ecommersapp.screens.home.navigation.Screens

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController,
               onProfileClick:()-> Unit,
               onCartClick:()-> Unit
               ){
    Scaffold(
        topBar= {MyTopAppBar(onCartClick,onProfileClick)},
        bottomBar={ BottomNavigationBar() }
    ){paddingValues->
        Column(modifier = Modifier.fillMaxSize().padding(paddingValues)) {
            //Search Section
            val  searchQuery= remember { mutableStateOf("") }
            val focusManager= LocalFocusManager.current

            SearchBar(
                query=searchQuery.value,
                onQueryChange = { searchQuery.value=it },
                onSearch={
                    /** Do the search Logic **/
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )


            //Searched  Result Section

            //Categories Section
            SectionTitle("Categories", "See All"){
                navController.navigate(Screens.CategoryList.route)
            }

            //Mock the categories Data

            val categories: List<Category> = listOf(
                Category(1,"Electronics","https://cdn-icons-png.flaticon.com/128/2777/2777142.png"),

                Category(2,"Clothing","https://cdn-icons-png.flaticon.com/128/2954/2954918.png")

            )
            val selectedCategory=remember { mutableStateOf(0) }

            //

            LazyRow(
                contentPadding = PaddingValues (horizontal=16.dp),
                horizontalArrangement = Arrangement.spacedBy (8.dp)) {
                items (categories.size){
                    CategoriesChip(
                        icon=categories[it].iconUrl,
                        text=categories[it].name,
                        isSelected = selectedCategory.value==it,
                        onClick ={
                            selectedCategory.value=it
                            /*Do some search logic*/                        }
                    )
                }
            }

            // Featured Products section
            SectionTitle("Featured",  "See All"){
                navController.navigate(Screens.ProductList.route)
                /*TODO() add actions*/
            }
            //Mock the Products Data

            val productsList= listOf<Product>(
                Product("1","SmartPhone",12000.00,"https://images.pexels.com/photos/404280/pexels-photo-404280.jpeg?auto=compress&cs=tinysrgb&w=300&h=300","1"),
                Product("2","TV",20000.00,"https://images.pexels.com/photos/6976094/pexels-photo-6976094.jpeg?auto=compress&cs=tinysrgb&w=300&h=300","1"))

            LazyRow(contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                items (productsList){products->
                    ProductsCard(products){
                        //Handle onClick Event

                    }
                }
            }

        }
    }
}