package com.example.caffeinated.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.caffeinated.screens.DETAIL_ARGUMENT_KEY
import com.example.caffeinated.screens.DetailScreen
import com.example.caffeinated.screens.HomeScreen
import com.example.caffeinated.screens.InfoScreen
import com.example.caffeinated.screens.Screen


@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController = navController)
        }
        composable(route = Screen.InfoScreen.route) {
            InfoScreen(navController = navController)
        }
        composable(route = Screen.SearchScreen.route) {
            InfoScreen(navController = navController)
        }
        composable(
            Screen.DetailScreen.route,
            arguments = listOf(navArgument(name = DETAIL_ARGUMENT_KEY) { type = NavType.LongType })
        ) { backStackEntry ->    // backstack contains all information from navhost
            DetailScreen(
                navController = navController,
                recipeID = backStackEntry.arguments?.getLong(DETAIL_ARGUMENT_KEY)
            )   // get the argument from navhost that will be passed
        }
    }
}

