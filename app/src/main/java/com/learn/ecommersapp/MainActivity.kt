package com.learn.ecommersapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.learn.ecommersapp.model.Product
import com.learn.ecommersapp.model.UserProfile
import com.learn.ecommersapp.screens.home.HomeScreen
import com.learn.ecommersapp.screens.home.cart.CartItemCard
import com.learn.ecommersapp.screens.home.cart.CartScreen
import com.learn.ecommersapp.screens.home.profile.ProfileScreen
import com.learn.ecommersapp.ui.theme.ECommersAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ECommersAppTheme {
               // HomeScreen()
                //CartScreen()
                ProfileScreen(){

                }
            }
        }
    }
}

