package com.learn.ecommersapp.screens.home.cart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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

@Composable
fun CartScreen(navController: NavController){
    val cartItems=listOf(
      Product("6","SmartPhone",1012.12,"https://images.pexels.com/photos/404280/pexels-photo-404280.jpeg","2"),
        Product("6","SmartPhone",1012.12,"https://images.pexels.com/photos/404280/pexels-photo-404280.jpeg","2")

    )
    Column (modifier = Modifier.fillMaxSize().padding(top = 16.dp)){
        Text(text = "Your Cart", style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold)


        if (cartItems.isEmpty()){
            Column (modifier = Modifier.fillMaxSize().padding(16.dp),
                verticalArrangement =Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally){
                Text(text = "Your Cart is Empty", style = MaterialTheme.typography.titleMedium)

                Spacer(modifier = Modifier.height(16.dp))

                Button(onClick = {/*Handle Button Click*/}, modifier = Modifier.fillMaxWidth()
                    .padding(8.dp)) {
                    Text(text = "Continue Shopping", fontWeight = FontWeight.Bold)
                }
            }
        }else{
            LazyColumn(modifier = Modifier.weight(1f)) {
                items  (cartItems){item->

                    CartItemCard(
                        item=item,
                        onItemRemove ={/*Handle Remove Item*/}
                    )
                }
            }
        }




        Column(modifier = Modifier.fillMaxWidth().padding(16.dp)){
            Row (modifier = Modifier.fillMaxWidth() ,horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text="Total:", style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold)

                Text(text = "...$", style = MaterialTheme.typography.bodyMedium)
            }
            Button(onClick = {}, modifier = Modifier.fillMaxWidth()) {
                Text("Shop Easy")
            }
        }
    }
}