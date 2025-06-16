package com.learn.ecommersapp.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.learn.ecommersapp.ui.theme.PrimaryColor


@Composable
fun SectionTitle(title:String,textAction:String,onActionClick:()-> Unit){
    Row(modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween){

        Text(title, style = MaterialTheme.typography.titleMedium.copy(
            fontWeight = FontWeight.Bold
        ) )

        Text(textAction,style = MaterialTheme.typography.titleMedium.copy(
            color = PrimaryColor
        ),
            modifier = Modifier.clickable { onActionClick() }
            )
    }
}