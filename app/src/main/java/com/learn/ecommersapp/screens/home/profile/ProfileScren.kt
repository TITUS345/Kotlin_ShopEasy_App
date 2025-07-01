package com.learn.ecommersapp.screens.home.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.learn.ecommersapp.model.UserProfile

@Composable
fun ProfileScreen(navController: NavController,
    onSignOut:()-> Unit){
    val userProfile=(
        UserProfile("22","Tarus","tarus@gmail.com")
    )
    Column (modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally){
        //Profile Header
        Text(text = "Your Profile", style = MaterialTheme.typography.headlineMedium)
        //Profile Image
        Box(modifier = Modifier.padding(16.dp).size(120.dp).clip(CircleShape).background(
            MaterialTheme.colorScheme.primaryContainer),
            contentAlignment = Alignment.Center,){
            Icon(imageVector = Icons.Default.Person,
                contentDescription = "Profile Image", modifier = Modifier.size(60.dp),
                tint = MaterialTheme.colorScheme.primary)
        }
        //User Name
        Text(text=userProfile.name, fontWeight = FontWeight.Bold,
            fontSize = 16.sp)

        //User Email
        Text(text = userProfile.email, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {onSignOut()}, modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.errorContainer)) {
            Text(text = "Sign Up", fontWeight = FontWeight.Bold, color = Color.Black )
        }


    }
}