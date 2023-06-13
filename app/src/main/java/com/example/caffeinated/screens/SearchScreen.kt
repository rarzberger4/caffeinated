package com.example.caffeinated.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.TextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.caffeinated.data.RecipeDatabase
import com.example.caffeinated.repositories.RecipeRepo
import com.example.caffeinated.ui.theme.CaffeinatedTheme
import com.example.caffeinated.viewmodels.RecipiesViewModel
import com.example.caffeinated.viewmodels.RecipiesViewModelFactory
import com.example.caffeinated.widgets.RecipeRow
import kotlinx.coroutines.launch


@Composable
fun SearchScreen(navController: NavController = rememberNavController()) {
    val rr = RecipeRepo.getInstance(
        RecipeDatabase.getDatabase(LocalContext.current).recipeDao()
    )
    val factory = RecipiesViewModelFactory(rr)
    val viewModel: RecipiesViewModel = viewModel(factory = factory)

    CaffeinatedTheme() {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val roastinglvlinput = remember { mutableStateOf(TextFieldValue()) }
            val origininput = remember { mutableStateOf(TextFieldValue()) }

            Column(modifier = Modifier.padding(16.dp)) {

                Row(modifier = Modifier.fillMaxWidth()) {
                    androidx.compose.material3.Button(
                        onClick = { navController.popBackStack() },
                        modifier = Modifier
                            .padding(bottom = 8.dp)
                            .fillMaxWidth()
                    ) {
                        androidx.compose.material.Text("Back", color = Color.White)
                    }
                }



                TextField(
                    value = roastinglvlinput.value,
                    onValueChange = { roastinglvlinput.value = it },
                    label = { Text("Roasting Level") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
                TextField(
                    value = origininput.value,
                    onValueChange = { origininput.value = it },
                    label = { Text("Origin Country") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )


                if (roastinglvlinput.value.text != "" && origininput.value.text != "") {
                    performSearch(
                        viewModel,
                        navController,
                        roastinglvlinput.value.text.toInt(),
                        origininput.value.text
                    )
                }else if(roastinglvlinput.value.text == "" && origininput.value.text != ""){
                    performSearch(
                        viewModel,
                        navController,
                        0,
                        origininput.value.text
                    )
                }else if (roastinglvlinput.value.text != "" && origininput.value.text == ""){
                    performSearch(
                        viewModel,
                        navController,
                        roastinglvlinput.value.text.toInt(),
                        "0"
                    )
                }
            }
        }
    }
}


@Composable
private fun performSearch(
    viewModel: RecipiesViewModel,
    navController: NavController,
    roastingquery: Int,
    originquery: String

) {
    // Implement your search logic here
    // This is just a placeholder to demonstrate the search functionality
    val coroutineScope = rememberCoroutineScope()
    val recipeListState by viewModel.recipeListState.collectAsState()



    LazyColumn {
        items(items = recipeListState) { recipe ->

            if (recipe.roastinglvl == roastingquery && recipe.origin.equals(originquery,true)) {
                RecipeRow(
                    recipe = recipe,
                    onRecipeRowClick = { recipeID ->
                        navController.navigate(Screen.DetailScreen.withId(recipeID))
                    },
                    onFavClick = { recipe ->
                        coroutineScope.launch {
                            viewModel.updateFavoriteRecipe(recipe)
                        }
                    }
                )
            }else if(roastingquery == 0 && recipe.origin.equals(originquery,true)){
                RecipeRow(
                    recipe = recipe,
                    onRecipeRowClick = { recipeID ->
                        navController.navigate(Screen.DetailScreen.withId(recipeID))
                    },
                    onFavClick = { recipe ->
                        coroutineScope.launch {
                            viewModel.updateFavoriteRecipe(recipe)
                        }
                    }
                )
            }else if(recipe.roastinglvl == roastingquery && originquery == "0"){
                RecipeRow(
                    recipe = recipe,
                    onRecipeRowClick = { recipeID ->
                        navController.navigate(Screen.DetailScreen.withId(recipeID))
                    },
                    onFavClick = { recipe ->
                        coroutineScope.launch {
                            viewModel.updateFavoriteRecipe(recipe)
                        }
                    }
                )
            }
        }

    }
}