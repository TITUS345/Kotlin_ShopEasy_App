package com.learn.ecommersapp.screens.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.learn.ecommersapp.ui.theme.CardChipColor
import androidx.compose.ui.layout.ContentScale
import coil3.compose.rememberAsyncImagePainter


@Composable
fun CategoriesChip(icon:String,text:String,isSelected:Boolean,onClick:()-> Unit){
    Card (shape = RoundedCornerShape(16.dp),
        colors=CardDefaults.cardColors(
            containerColor = if(isSelected) CardChipColor else Color.LightGray.copy(0.1f)
        ),
        border = BorderStroke(
            width = if (isSelected) 0.dp else 1.dp,
            color=Color.LightGray.copy(alpha = 0.3f)

        ),
        modifier = Modifier.clickable { onClick() }
    ){
        Row (modifier = Modifier.padding(vertical =12.dp, horizontal = 8.dp)){
            Image(
                rememberAsyncImagePainter(icon) ,
                contentDescription = text,
                modifier = Modifier.size(20.dp),
                contentScale = ContentScale.Fit // Optional, but helps with layout
            )


            Text(
                text = text,
                color = if(isSelected)Color.White else Color.Black,
                style=MaterialTheme.typography.bodyMedium,
                modifier=Modifier.padding(start = 8.dp)

            )
        }

    }
}