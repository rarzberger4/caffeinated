package com.example.caffeinated.screens

import androidx.compose.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.caffeinated.ui.theme.CaffeinatedTheme
import com.pierfrancescosoffritti.*
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView


@Composable
fun InfoScreen(navController: NavController = rememberNavController()) {
    val youtubeVideoId = "dQw4w9WgXcQ"

    CaffeinatedTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            LazyColumn(
                modifier = Modifier.padding(16.dp)
            ) {
                item {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Button(
                            onClick = { navController.popBackStack() },
                            modifier = Modifier
                                .padding(bottom = 8.dp)
                                .fillMaxWidth()
                        ) {
                            Text("Back")
                        }
                    }
                }

                item {
                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Coffee and Its Origin",
                        style = MaterialTheme.typography.headlineMedium,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ut diam sed mauris ullamcorper aliquam. Aliquam efficitur feugiat ipsum, id placerat dolor consequat in. Sed efficitur pellentesque massa, eu tempus libero maximus eu. Sed lacinia fermentum diam a pellentesque. Nullam ut posuere neque. Nulla facilisi.",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .padding(8.dp),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 8.dp
                        )
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter("https://images.immediate.co.uk/production/volatile/sites/30/2020/08/cappucino-32dbfba.jpg"),
                            contentDescription = "Coffee Image 1",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .padding(8.dp),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 8.dp
                        )
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter("https://images.immediate.co.uk/production/volatile/sites/30/2020/08/flat-white-3402c4f.jpg"),
                            contentDescription = "Coffee Image 2",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()

                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))
                }

                item {
                    // Add spacing between the last image and YouTube video
                    Spacer(modifier = Modifier.height(32.dp))
                }

                item {
                    Column() {
                        Text(text = "History of Coffee",
                            style = MaterialTheme.typography.headlineSmall,
                            modifier = Modifier.padding(horizontal = 8.dp))

                        // Add YouTube video
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                        ) {
                            YoutubeScreen(
                                videoId = youtubeVideoId,
                                modifier = Modifier.fillMaxSize()
                            )
                        }

                    }

                }
            }
        }
    }
}


@Composable
fun YoutubeScreen(
    videoId: String,
    modifier: Modifier
) {
    val ctx = LocalContext.current
    AndroidView(factory = {
        var view = YouTubePlayerView(it)
        val fragment = view.addYouTubePlayerListener(
            object : AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    super.onReady(youTubePlayer)
                    youTubePlayer.cueVideo(videoId, 0f)
                }
            }
        )
        view
    })
}



