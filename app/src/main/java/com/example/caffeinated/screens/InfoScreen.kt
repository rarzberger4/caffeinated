package com.example.caffeinated.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.caffeinated.ui.theme.CaffeinatedTheme

@Composable
fun InfoScreen(navController: NavController = rememberNavController()) {
    CaffeinatedTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Row() {
                    Button(
                        onClick = { navController.popBackStack() },
                        modifier = Modifier.padding(bottom = 8.dp).fillMaxWidth()
                    ) {
                        Text("Back")
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Coffee and Its Origin",
                    style = MaterialTheme.typography.headlineMedium
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ut diam sed mauris ullamcorper aliquam. Aliquam efficitur feugiat ipsum, id placerat dolor consequat in. Sed efficitur pellentesque massa, eu tempus libero maximus eu. Sed lacinia fermentum diam a pellentesque. Nullam ut posuere neque. Nulla facilisi.",
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(modifier = Modifier.height(16.dp))

                Image(
                    painter = rememberAsyncImagePainter("https://images.immediate.co.uk/production/volatile/sites/30/2020/08/cappucino-32dbfba.jpg"),
                    contentDescription = "Coffee Image 1",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Image(
                    painter = rememberAsyncImagePainter("https://images.immediate.co.uk/production/volatile/sites/30/2020/08/flat-white-3402c4f.jpg"),
                    contentDescription = "Coffee Image 2",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )


                Spacer(modifier = Modifier.height(16.dp))

                // Add YouTube video

                Box(modifier = Modifier.aspectRatio(16f / 9f)) {
                    // Use a Composable for embedding the YouTube video player
                    // You can use a library like 'com.github.piasy:RxBinding:0.6.0' to handle YouTube video playback
                }
            }
        }
    }
}