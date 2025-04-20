package com.example.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.gson.Gson
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun FirstScreen(navController: NavHostController) {

    val user = User(name = "Aadnya", city= "Pune", contact = "9860346943", email = "aadnyadeshmukn@gmail.com")
    val userJson = Gson().toJson(user)
    val encodedUserJson = URLEncoder.encode(userJson, StandardCharsets.UTF_8.toString())

    Column (modifier = Modifier
        .fillMaxSize()
        .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        Button(
            onClick = {
                navController.navigate("second/Hello%20from%20FirstScreen")
            }
        ) {
            Text(text = "Click for Second screen for String")
        }


        Button(
            onClick = {
                navController.navigate(route = "third/$encodedUserJson")
            }
        ) {
            Text(text = "Click for Third screen for Object")
        }

    }




}