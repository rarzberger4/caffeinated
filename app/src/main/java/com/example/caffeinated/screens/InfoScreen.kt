package com.example.caffeinated.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InfoScreen(navController: NavController = rememberNavController()) {



        Column(
                modifier = Modifier.fillMaxWidth()
        ) {
                Row(
                        modifier = Modifier.fillMaxWidth()
                ){
                        TopAppBar(
                                title = { Text(text = "Back") },
                                navigationIcon = {
                                        IconButton(onClick = { navController.popBackStack() }) {
                                                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                                        }
                                }
                        )
                }



                Spacer(modifier = Modifier.height(16.dp))

                Text(text = "Ok lets go")

                Spacer(modifier = Modifier.height(16.dp))
        }
}