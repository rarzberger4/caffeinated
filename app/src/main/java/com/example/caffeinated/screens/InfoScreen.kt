package com.example.caffeinated.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun InfoScreen(navController: NavController = rememberNavController()) {
        Text(text = "This is a placeholder")
}