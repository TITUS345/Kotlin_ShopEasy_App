package com.learn.ecommersapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.learn.ecommersapp.screens.home.HomeScreen
import com.learn.ecommersapp.screens.home.cart.CartScreen
import com.learn.ecommersapp.screens.home.categories.CategoryScreen
import com.learn.ecommersapp.screens.home.navigation.Screens
import com.learn.ecommersapp.screens.home.products.ProductDetailsScreen
import com.learn.ecommersapp.screens.home.products.ProductScreen
import com.learn.ecommersapp.screens.home.profile.ProfileScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //Navigation System
            val navController=rememberNavController()

            //Nav Host: Manages Navigation btw Screens
            NavHost(
                navController = navController,
                startDestination = "Home"
            ) {
                composable(Screens.Home.route){
                    HomeScreen(navController=navController,
                        onProfileClick ={ navController.navigate(Screens.Profile.route)},
                        onCartClick = {navController.navigate(Screens.Cart.route)}
                    )

                }
                composable (Screens.Cart.route){
                    CartScreen(navController=navController)
                }
                composable (Screens.Profile.route){
                    ProfileScreen (
                        navController =navController,
                        onSignOut = {})
                }
                composable(Screens.CategoryList.route){
                    CategoryScreen(navController=navController)
                }
//                composable("ProductList"){
//                    ProductScreen(
//                        navController = navController
//                   )
//               }
                composable(Screens.ProductDetails.route){
                    val productId=it.arguments?.getString("productId")
                    if (productId !==null){
                        ProductDetailsScreen(productId)
                    }
                }
                composable (Screens.ProductList.route){
                    val categoryId=it.arguments?.getString("categoryId")
                    if (categoryId!==null){
                        ProductScreen(
                            categoryId,
                            navController = navController,
                        )
                    }
                }
            }

        }
    }
}

