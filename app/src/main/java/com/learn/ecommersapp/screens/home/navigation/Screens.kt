package com.learn.ecommersapp.screens.home.navigation

sealed class Screens(val route: String) {
    object Home: Screens("Home")
    object Cart:Screens("Cart")
    object Profile: Screens("Profile")


    object ProductDetails:Screens("productDetails/{productId}"){
        fun createRoute(productId: String)="productDetails/$productId"
    }

    object ProductList:Screens("productList/{categoryId}"){
        fun createRoute(categoryId:String)="productList/$categoryId"
    }
    object CategoryList:Screens("categoryList")

    object SignUp: Screens("SignUp")
    object Login: Screens("Login")


}