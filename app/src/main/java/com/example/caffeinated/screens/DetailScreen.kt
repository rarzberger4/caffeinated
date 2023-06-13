package com.example.caffeinated.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.caffeinated.data.RecipeDatabase
import com.example.caffeinated.models.Recipe
import com.example.caffeinated.repositories.RecipeRepo
import com.example.caffeinated.ui.theme.CaffeinatedTheme
import com.example.caffeinated.viewmodels.RecipeDetailViewModel
import com.example.caffeinated.viewmodels.RecipeDetailViewModelFactory
import com.example.caffeinated.widgets.RecipeComment
import com.example.caffeinated.widgets.RecipeRating
import com.example.caffeinated.widgets.RecipeRow
import kotlinx.coroutines.launch

val myMaterial3 = androidx.compose.material3.MaterialTheme

@Composable
fun DetailScreen(navController: NavController = rememberNavController(), recipeID: Long?) {
    CaffeinatedTheme {
        recipeID?.let {
            val rr = RecipeRepo.getInstance(
                RecipeDatabase.getDatabase(LocalContext.current).recipeDao()
            )

            val factory = RecipeDetailViewModelFactory(rr, recipeID)
            val viewModel: RecipeDetailViewModel = viewModel(factory = factory)
            val recipe = viewModel.recipeState.collectAsState()
            val coroutineScope = rememberCoroutineScope()

            Surface(
                color = myMaterial3.colorScheme.background,
                modifier = Modifier.fillMaxSize()
            ) {

                Column(modifier = Modifier.padding(16.dp)) {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Button(
                            onClick = { navController.popBackStack() },
                            modifier = Modifier
                                .padding(bottom = 8.dp)
                                .fillMaxWidth()
                        ) {
                            Text("Back", color = Color.White)
                        }
                    }

                    MainContent(
                        recipeID = recipeID,
                        recipe = recipe.value,
                        onFavClick = { recipe ->
                            coroutineScope.launch {
                                viewModel.updateFavoriteRecipe(recipe)
                            }
                        },
                        viewModel = viewModel
                    )
                }
            }
        }
    }
}


@Composable
fun MainContent(
    recipeID: Long,
    modifier: Modifier = Modifier,
    recipe: Recipe,
    onFavClick: (Recipe) -> Unit,
    viewModel: RecipeDetailViewModel
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
                },
                expanded = true
            )


            Spacer(modifier = Modifier.height(8.dp))

            Divider()

            RecipeComment(modifier = modifier, recipeID = recipeID)

            Divider()

            Divider()

            RecipeRating(modifier = modifier, recipe = recipe, viewModel = viewModel)

            Text(text = "Recipe Images", style = MaterialTheme.typography.h5)

        }
    }
}