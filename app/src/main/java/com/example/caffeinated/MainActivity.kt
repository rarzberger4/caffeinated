package com.example.caffeinated

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.caffeinated.data.RecipeDao
import com.example.caffeinated.data.RecipeDatabase
import com.example.caffeinated.repositories.RecipeRepo
import com.example.caffeinated.ui.theme.CaffeinatedTheme
import android.content.Context
import android.util.Log
import androidx.compose.ui.platform.LocalContext



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            HomeScreen()

        }
    }
}


@Composable
fun HomeScreen(){
    CaffeinatedTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {



//                        val rr = RecipeRepo.getInstance(RecipeDatabase.getDatabase(LocalContext.current).recipeDao())
//                        rr.getAllRecipes()
//
//                        Log.d("TEST", rr.getById(1).toString())
//
//                        LazyColumn(){
//                            rr.getById(1)
//                        }

            Greeting("Android")





        }
    }
}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CaffeinatedTheme {
        Greeting("Andr")
    }
}