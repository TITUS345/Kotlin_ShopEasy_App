package com.learn.ecommersapp.screens.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import coil3.compose.rememberAsyncImagePainter
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.learn.ecommersapp.model.Product
import com.learn.ecommersapp.ui.theme.PrimaryColor

@Composable
fun ProductsCard(product: Product, onProductClick: () -> Unit) {
    val context = LocalContext.current

    val imagePainter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(context)
            .data(product.imageUrl)
            .crossfade(true)
            .listener(
                onStart = { Log.d("ImageLoad", "Loading started: ${product.imageUrl}") },
                onSuccess = { _, _ -> Log.d("ImageLoad", "Loaded successfully") },
                onError = { _, result -> Log.e("ImageLoad", "Failed to load image", result.throwable) }
            )
            .build()
    )

    val iconPainter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(context)
            .data(product.icon)
            .crossfade(true)
            .listener(
                onError = { _, result ->
                    Log.e("ImageLoad", "Failed to load image", result.throwable)
                }
            )
            .build()
    )

    Card(
        onClick = onProductClick,
        modifier = Modifier.width(280.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Box {
            DiscountBadge(
                discountPercent = 5,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(8.dp)
                    .zIndex(2f)
            )
            Column(modifier = Modifier
                .padding(16.dp)
                .zIndex(1f)) {
                Image(
                    painter = imagePainter,
                    contentDescription = product.name,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = product.name,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "$${product.price}",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = iconPainter,
                        contentDescription = "Rating",
                        tint = PrimaryColor,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "${product.id}",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }
}