package com.example.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun AppNavigation(){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "first") {

        composable("first") {
            FirstScreen(navController = navController)
        }

        composable(route= "second/{message}",
                    arguments = listOf(navArgument("message"){type = NavType.StringType})
        ){navBackStackEntry ->
            val message = navBackStackEntry.arguments?.getString("message")?:"Default Message"
            SecondScreen(message = message)
        }

        composable(route = "third/{userJson}",
                    arguments = listOf(navArgument(name = "userJson"){type = NavType.StringType})
            ){navBackStackEntry ->
            val jsonMessage = navBackStackEntry.arguments?.getString("userJson")?:"Default Message"
            ThirdScreen(userJson = jsonMessage)
        }
    }
}