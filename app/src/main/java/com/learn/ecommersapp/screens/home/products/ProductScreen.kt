package com.learn.ecommersapp.screens.home.products

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.learn.ecommersapp.model.Product
import com.learn.ecommersapp.screens.home.navigation.Screens

@SuppressLint("SuspiciousIndentation")
@Composable
fun ProductScreen(
    categoryId:String,
    navController: NavController){
    //Fetch products from the viewModel


    // but currently mock the hard coded data
    val productItem=listOf<Product>(
        Product("6","SmartPhone",1012.12,"https://images.pexels.com/photos/404280/pexels-photo-404280.jpeg?auto=compress&cs=tinysrgb&w=100&h=100","2"),
        Product("2","TV",20000.09,"https://images.pexels.com/photos/6976094/pexels-photo-6976094.jpeg?auto=compress&cs=tinysrgb&w=300&h=300","1")
    )
    //here we display the products
        Column (modifier = Modifier.fillMaxSize().padding(16.dp)){
            //Title
            Text(modifier = Modifier.padding(top=20.dp
            ),
                text = "Product of Category ID:$categoryId",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold)


            if (productItem.isEmpty()){
                Column(modifier = Modifier.fillMaxSize().padding(16.dp),
                    verticalArrangement = Arrangement.Center,) {
                    Text(text="No Products Found!",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold)

//                    Spacer(modifier = Modifier.height(16.dp))
//
//                    //Redirecting Button
//                    Button(onClick = {}, modifier = Modifier.fillMaxWidth(), ) {
//                        Text(text="Add Products ", style = MaterialTheme.typography.titleMedium,
//                            fontWeight = FontWeight.Bold)
//                    }
                }
            }else{
                LazyColumn (modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,){
                    items  (productItem) {product->
                        ProductItem(
                            product=product,
                            onClick = {navController.navigate(Screens.ProductDetails.createRoute(product.id))},
                            onAddToCart = {
                                //Add Product to Cart
                                //Room database insertion function
                            }
                        )
                    }

                }

            }
        }



}