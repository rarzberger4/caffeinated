package com.example.caffeinated.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.caffeinated.data.RecipeDatabase
import com.example.caffeinated.models.Recipe
import com.example.caffeinated.repositories.RecipeRepo
import com.example.caffeinated.ui.theme.CaffeinatedTheme
import com.example.caffeinated.viewmodels.RecipiesViewModel
import com.example.caffeinated.viewmodels.RecipiesViewModelFactory
import com.example.caffeinated.widgets.RecipeRow
import kotlinx.coroutines.launch

@Preview
@Composable
fun HomeScreen(navController: NavController = rememberNavController()) {
    CaffeinatedTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {

            val rr = RecipeRepo.getInstance(
                RecipeDatabase.getDatabase(LocalContext.current).recipeDao()
            )
            val factory = RecipiesViewModelFactory(rr)
            val viewModel: RecipiesViewModel = viewModel(factory = factory)
            val taskstate = viewModel.recipeListState.collectAsState()

            val coroutineScope = rememberCoroutineScope()
            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Row() {
                    Button(
                        onClick = { navController.navigate(Screen.InfoScreen.route) },
                        modifier = Modifier
                            .padding(bottom = 8.dp)
                            .fillMaxWidth()
                    ) {
                        Text("InfoScreen")
                    }
                }


                RecipeList(viewModel = viewModel, navController)
            }
        }
    }
}


@Composable
fun RecipeList(viewModel: RecipiesViewModel, navController: NavController) {
    val coroutineScope = rememberCoroutineScope()
    val recipeListState by viewModel.recipeListState.collectAsState()

    LazyColumn {
        items(items = recipeListState) { recipe ->
            RecipeRow(
                recipe = recipe,
                onRecipeRowClick = { recipeID ->
                    navController.navigate(Screen.DetailScreen.withId(recipeID))
                },
                onFavClick  = { recipe ->
                    coroutineScope.launch{
                        viewModel.updateFavoriteRecipe(recipe)
                    }

                }
            )








//            Column(
//                modifier = Modifier.padding(16.dp)
//            ) {
//                Text(
//                    text = recipe.title,
//                    style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp),
//                    modifier = Modifier.padding(bottom = 8.dp)
//
//
//                )
//                Text(
//                    text = "Year: ${recipe.year}",
//                    style = TextStyle(fontSize = 16.sp),
//                    modifier = Modifier.padding(bottom = 4.dp)
//                )
//                Text(
//                    text = "Rating: ${recipe.rating}",
//                    style = TextStyle(fontSize = 16.sp),
//                    modifier = Modifier.padding(bottom = 4.dp)
//                )
//                Text(
//                    text = "Manual: ${recipe.manual}",
//                    style = TextStyle(fontSize = 16.sp),
//                    modifier = Modifier.padding(bottom = 4.dp)
//                )
//            }
        }
    }
}