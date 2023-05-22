package com.example.caffeinated.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun InfoScreen(navController: NavController = rememberNavController()) {
        Column(
                modifier = Modifier.padding(16.dp)
        ) {
                Button(
                        onClick = { navController.popBackStack() },
                        modifier = Modifier.padding(bottom = 8.dp)
                ) {
                        Text("Back")
                }
        }
}