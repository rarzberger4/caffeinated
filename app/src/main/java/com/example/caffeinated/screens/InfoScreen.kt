package com.example.caffeinated.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.caffeinated.ui.theme.CaffeinatedTheme
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView


@Composable
fun InfoScreen(navController: NavController = rememberNavController()) {
    val youtubeVideoId = "EJVbsCfLy-8"

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
                        text = "Coffee is a widely consumed beverage made from the roasted seeds of the Coffea plant. It is cultivated in various regions around the world and undergoes a complex process from harvesting to brewing. Here is an overview of the key aspects related to coffee origins, processing methods, and regional differences:\n" +
                                "\n" +
                                "Origins and Cultivation:\n" +
                                "\n" +
                                "Coffee plants are native to tropical regions, primarily found in Africa, Asia, and the Americas.\n" +
                                "The Coffea plant produces fruits called \"cherries\" that contain the coffee beans.\n" +
                                "Arabica and Robusta are the two main species of coffee cultivated for commercial consumption.\n" +
                                "Coffee cultivation requires specific climate conditions, including altitude, temperature, rainfall, and soil quality.\n" +
                                "Harvesting and Processing:\n" +
                                "\n" +
                                "Coffee cherries are harvested when they reach optimal ripeness, usually by handpicking or occasionally by machine.\n" +
                                "There are two primary processing methods: the dry (natural) process and the wet (washed) process.\n" +
                                "Dry process: In this method, the coffee cherries are laid out to dry in the sun, allowing the beans to ferment inside the fruit.\n" +
                                "Wet process: Here, the cherries undergo depulping to remove the outer skin, followed by fermentation and washing to separate the beans.\n" +
                                "After processing, the coffee beans are dried, hulled, and sorted to remove any defects or impurities.\n" +
                                "Regional Differences:\n" +
                                "\n" +
                                "Coffee beans grown in different regions exhibit unique flavors, characteristics, and profiles due to variations in soil, climate, altitude, and farming practices.\n" +
                                "Major coffee-producing regions include:\n" +
                                "Africa: Known for its bright acidity, fruity and floral flavors. Examples: Ethiopia, Kenya, and Tanzania.\n" +
                                "Central and South America: Offers a range of flavor profiles, including chocolatey, nutty, and balanced. Examples: Brazil, Colombia, and Costa Rica.\n" +
                                "Asia-Pacific: Often characterized by earthy, spicy, and full-bodied flavors. Examples: Indonesia, Vietnam, and India.\n" +
                                "Roasting:\n" +
                                "\n" +
                                "Roasting is a crucial step that transforms green coffee beans into the flavorful and aromatic beans used for brewing.\n" +
                                "Roasting levels can vary from light to dark, impacting the taste, aroma, and body of the coffee.\n" +
                                "Light roasts preserve the bean's original flavors, while dark roasts result in bolder and more robust flavors.\n" +
                                "Different roasting techniques and profiles are employed by coffee roasters to achieve desired taste profiles.\n" +
                                "It's important to note that this overview provides a general understanding, and coffee is a vast subject with many nuances and variations. Exploring and experiencing different coffees from various regions and processing methods can enhance your appreciation for this beloved beverage.",
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
                        Text(
                            text = "History of Coffee",
                            style = MaterialTheme.typography.headlineSmall,
                            modifier = Modifier.padding(horizontal = 8.dp)
                        )

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