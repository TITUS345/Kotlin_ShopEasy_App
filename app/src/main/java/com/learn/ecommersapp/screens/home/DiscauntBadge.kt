package com.learn.ecommersapp.screens.home


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable

fun DiscountBadge(discountPercent:Int, modifier: Modifier= Modifier){
    Box (modifier = Modifier.clip(RoundedCornerShape(4.dp)).background(Color.Red)){
        Text(text = "${discountPercent} OFF",
            color= Color.White,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 4.dp))
    }

}