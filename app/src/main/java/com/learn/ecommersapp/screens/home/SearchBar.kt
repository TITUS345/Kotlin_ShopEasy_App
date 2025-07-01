package com.learn.ecommersapp.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SearchBar(
     query:String,
     onQueryChange:(String)-> Unit,
     onSearch:()-> Unit,
     modifier:Modifier=Modifier
){
     Box(modifier = modifier.height( 50.dp)
          .clip(RoundedCornerShape(25.dp))
          .background(Color.LightGray.copy(alpha = 0.2f)),
          contentAlignment = Alignment.CenterStart){

          Row(modifier=Modifier.fillMaxSize().padding(horizontal = 16.dp),
               verticalAlignment = Alignment.CenterVertically) {

               Icon(Icons.Default.Search,"Search", tint= Color.Gray)

               Spacer(modifier=Modifier.width(8.dp))

               TextField(
                    value=query,
                    onValueChange = onQueryChange,
                    singleLine = true,
                    modifier = modifier.fillMaxWidth(),
                    placeholder={
                         Text(text="Search products...",
                              color= Color.Gray, fontSize = 16.sp)
                    },

                    keyboardOptions = KeyboardOptions(
                         imeAction = ImeAction.Search
                    ),
                    keyboardActions = KeyboardActions(
                         onSearch = {onSearch()}
                    ),
                    colors = TextFieldDefaults.colors(
                         focusedContainerColor = Color.Transparent,
                         unfocusedContainerColor = Color.Transparent,
                         disabledContainerColor = Color.Transparent,
                         focusedIndicatorColor = Color.Transparent,
                         unfocusedLabelColor = Color.Transparent,
                         disabledIndicatorColor = Color.Transparent
                    )
               )


          }

     }
}