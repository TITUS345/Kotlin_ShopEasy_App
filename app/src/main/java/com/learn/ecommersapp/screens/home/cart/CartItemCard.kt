package com.learn.ecommersapp.screens.home.cart


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter
import com.learn.ecommersapp.model.Product

@Composable
fun CartItemCard(item: Product, onItemRemove:()-> Unit){
    Card(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
        ){
        Row(modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center){
            Image(painter = rememberAsyncImagePainter(model = item.imageUrl),
                contentDescription = "Cart Item Image",
                modifier = Modifier.size(80.dp).clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop)

            Spacer(modifier = Modifier.width(8.dp))

            Column (modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally){
                Text(text = item.name, style= MaterialTheme.typography.titleMedium)

                Text(text = "${item.price}", style= MaterialTheme.typography.titleMedium)
            }

            Column (horizontalAlignment = Alignment.CenterHorizontally){
                Row(verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center){
                    Text(text = item.name, style = MaterialTheme.typography.titleMedium)
                }
                IconButton(onClick = onItemRemove) {
                    Icon(Icons.Default.Delete, contentDescription = "Delete",
                        modifier = Modifier.size(40.dp))
                }
            }


        }
    }
}