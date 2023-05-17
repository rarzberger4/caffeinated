package com.example.caffeinated.screens

sealed class Screen(val route: String) {
    object HomeScreen : Screen("home")
    object InfoScreen : Screen("info")
}