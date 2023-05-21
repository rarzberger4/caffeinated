package com.example.caffeinated

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.caffeinated.data.RecipeDatabase
import com.example.caffeinated.repositories.RecipeRepo
import com.example.caffeinated.ui.theme.CaffeinatedTheme
import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.caffeinated.viewmodels.RecipiesViewModel
import com.example.caffeinated.viewmodels.RecipiesViewModelFactory


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
        }
    }
}


@Composable
fun HomeScreen() {
    CaffeinatedTheme {
        // A surface container using the 'background' color from the theme
        Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
        ) {

            val rr = RecipeRepo.getInstance(RecipeDatabase.getDatabase(LocalContext.current).recipeDao())
            val factory = RecipiesViewModelFactory(rr)
            val viewModel: RecipiesViewModel = viewModel(factory = factory)
            val taskstate = viewModel.recipeListState.collectAsState()

            //val coroutineScope = rememberCoroutineScope()




            Greeting(taskstate.value.toString())
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
