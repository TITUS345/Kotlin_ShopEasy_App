package com.learn.ecommersapp.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import coil3.compose.rememberAsyncImagePainter
import com.learn.ecommersapp.model.Product
import com.learn.ecommersapp.ui.theme.PrimaryColor

@Composable
fun ProductsCard(product:Product,onProductClick:()-> Unit){

    Card (
        onClick = onProductClick,
        modifier = Modifier.width(280.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Box{
            DiscountBadge(
                discountPercent = 5,
                modifier = Modifier.align(Alignment.TopStart)
                    .padding(8.dp)
                    .zIndex(2f)
            )
            Column (modifier = Modifier.padding(16.dp).zIndex(1f)){
                Image(
                    painter = rememberAsyncImagePainter(product.imageUrl),
                    contentDescription = product.name,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.fillMaxWidth().height(150.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text=product.name,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text="${product.price}",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.primary
                    )

                }
                Row(verticalAlignment = Alignment.CenterVertically){
                    Icon(
                        painter = rememberAsyncImagePainter(product.icon),
                        contentDescription = "Rating",
                        tint= PrimaryColor,
                        modifier = Modifier.size(16.dp)

                    )
                    Spacer(modifier = Modifier.width(4.dp))

                    Text(
                        text="${product.id}",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }
}
