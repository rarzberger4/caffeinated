package com.example.caffeinated.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.caffeinated.data.RecipeDatabase
import com.example.caffeinated.models.Recipe
import com.example.caffeinated.repositories.RecipeRepo
import com.example.caffeinated.viewmodels.RecipeDetailViewModel
import com.example.caffeinated.viewmodels.RecipeDetailViewModelFactory
import com.example.caffeinated.widgets.RecipeRow
import kotlinx.coroutines.launch

@Composable
fun DetailScreen(navController: NavController, recipeID: Long?) {

    recipeID?.let {
        val rr = RecipeRepo.getInstance(
            RecipeDatabase.getDatabase(LocalContext.current).recipeDao()
        )

        val factory = RecipeDetailViewModelFactory(rr, recipeID)
        val viewModel: RecipeDetailViewModel = viewModel(factory = factory)
        val recipe = viewModel.recipeState.collectAsState()
        val coroutineScope = rememberCoroutineScope()
        val scaffoldState = rememberScaffoldState() // this contains the `SnackbarHostState`

        Scaffold(
            scaffoldState = scaffoldState, // attaching `scaffoldState` to the `Scaffold`
            topBar = {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Button(
                        onClick = { navController.popBackStack() },
                        modifier = Modifier
                            .padding(bottom = 8.dp)
                            .fillMaxWidth()
                    ) {
                        androidx.compose.material3.Text("Back")
                    }
                }
            },
        ) { padding ->
            MainContent(
                Modifier.padding(padding),
                recipe.value
            ) { recipe: Recipe ->
                coroutineScope.launch {
                    viewModel.updateFavoriteRecipe(recipe)
                }
            }
        }
    }
}


@Composable
fun MainContent(
    modifier: Modifier = Modifier,
    recipe: Recipe,
    onFavClick: (Recipe) -> Unit
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            RecipeRow(
                recipe = recipe,
                onFavClick = { recipe ->
                    onFavClick(recipe)
                }
            )


            Spacer(modifier = Modifier.height(8.dp))

            Divider()

            Text(text = "Recipe Images", style = MaterialTheme.typography.h5)

            //HorizontalScrollableImageView(movie = movie)
        }
    }
}