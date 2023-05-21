package com.example.caffeinated.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
    }
}