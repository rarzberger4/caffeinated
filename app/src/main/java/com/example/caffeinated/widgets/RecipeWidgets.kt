package com.example.caffeinated.widgets

import android.R.attr
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.example.caffeinated.R
import com.example.caffeinated.data.RecipeDatabase
import com.example.caffeinated.models.Recipe
import com.example.caffeinated.models.getRecipes
import com.example.caffeinated.repositories.RecipeRepo
import com.example.caffeinated.viewmodels.RecipeDetailViewModel
import com.example.caffeinated.viewmodels.RecipeDetailViewModelFactory
import com.example.caffeinated.viewmodels.RecipiesViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


@Composable
fun RecipeRow(
    recipe: Recipe = getRecipes()[0],
    modifier: Modifier = Modifier,
    onRecipeRowClick: (String) -> Unit = {},
    onFavClick: (Recipe) -> Unit = {}
) {
    Card(modifier = modifier
        .clickable {
            onRecipeRowClick(recipe.dbId.toString())
        }
        .fillMaxWidth()
        .padding(5.dp),
        elevation = 10.dp
    ) {
        Column {
            Box(
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                if (recipe.images.isNotEmpty()) {
                    RecipeImage(imageUrl = recipe.images[0])
                } else {
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = "Prev Image"
                    )
                }
                FavoriteIcon(recipe, onFavClick)
            }

            RecipeDetails(modifier = Modifier.padding(12.dp), recipe = recipe)
        }
    }
}


@Composable
fun RecipeImage(imageUrl: String) {
    SubcomposeAsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .crossfade(true)
            .build(),
        contentScale = ContentScale.Crop,
        contentDescription = stringResource(id = R.string.app_name),
        loading = {
            CircularProgressIndicator()
        }
    )
}

@Composable
fun FavoriteIcon(recipe: Recipe, onFavClick: (Recipe) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        contentAlignment = Alignment.TopEnd
    ) {
        Icon(
            tint = Color.Red,
            imageVector =
            if (recipe.isFavorite) {
                Icons.Default.Favorite
            } else {
                Icons.Default.FavoriteBorder
            },
            contentDescription = "Add to favorites",
            modifier = Modifier.clickable {
                onFavClick(recipe)
            }
        )
    }
}

@Composable
fun RecipeDetails(modifier: Modifier = Modifier, recipe: Recipe) {

    var expanded by remember {
        mutableStateOf(false)
    }

    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            recipe.title,
            modifier = Modifier.weight(6f),
            style = MaterialTheme.typography.h6
        )

        IconButton(
            modifier = Modifier.weight(1f),
            onClick = { expanded = !expanded }) {
            Icon(
                imageVector =
                if (expanded) Icons.Filled.KeyboardArrowUp
                else Icons.Filled.KeyboardArrowDown,
                contentDescription = "expand",
                modifier = Modifier
                    .size(25.dp),
                tint = Color.DarkGray
            )
        }
    }

    AnimatedVisibility(
        visible = expanded,
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        Column(modifier = modifier) {
            Text(text = "Origin: ${recipe.origin}", style = MaterialTheme.typography.caption)
            Text(
                text = "Roasting level: ${recipe.roastinglvl}",
                style = MaterialTheme.typography.caption
            )
            Text(text = "Manual: ${recipe.manual}", style = MaterialTheme.typography.caption)
            Text(text = "Released: ${recipe.year}", style = MaterialTheme.typography.caption)
            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.DarkGray, fontSize = 13.sp)) {
                        append("Comments: ")
                    }

                    for (comments in recipe.comments) {
                        append("$comments \n")
                    }
                },
                style = MaterialTheme.typography.caption
            )

            Divider(modifier = Modifier.padding(3.dp))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeComment(modifier: Modifier, recipeID: Long) {
    val rr = RecipeRepo.getInstance(
        RecipeDatabase.getDatabase(LocalContext.current).recipeDao()
    )

    val factory = RecipeDetailViewModelFactory(rr, recipeID)
    val viewModel: RecipeDetailViewModel = viewModel(factory = factory)
    val recipe = viewModel.recipeState.collectAsState()
    val coroutineScope = rememberCoroutineScope()

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        var text by remember { mutableStateOf("") }
        OutlinedTextField(
            value = text,
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    modifier = Modifier.clickable {
                        coroutineScope.launch {
                            viewModel.updateRecipeComment(recipe.value, text)
                            text = ""
                        }
                    })
            },
            onValueChange = {
                text = it
            },
            label = { Text(text = "Add a Comment") },
            placeholder = { Text(text = "Enter comment here") },
        )
    }
}

@Composable
fun RecipeRating(modifier: Modifier, recipe: Recipe, viewModel: RecipeDetailViewModel) {


    val coroutineScope = rememberCoroutineScope()


    val rating = recipe.rating


    Row {
        for (i in 1..5) {
            val starIcon = if (i <= rating) Icons.Outlined.Star else Icons.Outlined.Add
            val starContentDescription = "Star $i of 5"
            val iconModifier = Modifier
                .size(50.dp)
                .clickable {
                    coroutineScope.launch {
                        viewModel.updateRecipeRating(recipe, i)
                    }
                }
                .padding(4.dp)

            Icon(
                imageVector = starIcon,
                contentDescription = starContentDescription,
                modifier = iconModifier
            )
        }
    }
}