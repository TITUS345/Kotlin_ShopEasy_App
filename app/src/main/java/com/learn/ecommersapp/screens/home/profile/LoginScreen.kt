package com.learn.ecommersapp.screens.home.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen(
    onNavigateToSignUp:()-> Unit,
    onLoginSuccess:()-> Unit
){
    var email by remember{ mutableStateOf("") }
    var password by remember{ mutableStateOf("") }

    //AuthState
    val authState=false

    if(authState){
        onLoginSuccess()
    }


    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("LogIn   Account",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 20.dp)
            )

        OutlinedTextField(
            value=email,
            onValueChange = {email=it},
            label = {Text(text="Email")},

            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)


        )
        OutlinedTextField(
            value=password,
            onValueChange = {password=it},
            label = {Text(text="Password")},

            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)


        )
        Spacer(Modifier.height(16.dp))

        Button(modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
            onClick = { /* Handle logIn Action*/ }) {
            //if login is not loading
            Text("LogIn", style = MaterialTheme.typography.bodyMedium)
            Spacer(Modifier.height(8.dp))

            TextButton(onClick = onNavigateToSignUp) {
                Text(text="Don't Have an account? Sign Up ")
            }

        }

    }

}