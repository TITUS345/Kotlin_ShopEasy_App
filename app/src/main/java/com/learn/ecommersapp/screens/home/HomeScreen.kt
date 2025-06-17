package com.learn.ecommersapp.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import com.learn.ecommersapp.model.Category

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(){
    Scaffold(
        topBar= {MyTopAppBar()},
        bottomBar={ BottomNavigationBar() }
    ){paddingValues->
        Column(modifier = Modifier.fillMaxSize().padding(paddingValues)) {
            //Search Section
            val searchQuery= remember { mutableStateOf("") }
            val focusManager= LocalFocusManager.current

            SearchBar(
                query = searchQuery.value,
                onQueryChange = {searchQuery.value=it},
                onSearch = {/** Do the search Logic**/},
                modifier = Modifier.fillMaxWidth().padding(16.dp)

            )


            //Searched  Result Section

            //Categories Section
            SectionTitle("Categories", "See All"){
                /* TODO() add actions  */
            }

            //Moke the categories Data

            val categories: List<Category> = listOf(
                Category(1,"Electronics","https://www.flaticon.com/free-icon/device_8990736"),

                Category(2,"Clothing","https://www.flaticon.com/free-icon/laundry_2946537")

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
                            /*Do some search logig*/                        }
                    )
                }
            }

            // Featured Products section
            SectionTitle("Featured",  "See All"){
                /*TODO() add actions*/
            }
        }
    }
}