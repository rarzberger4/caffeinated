package com.example.caffeinated.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.example.caffeinated.R
import com.example.caffeinated.models.Recipe
import com.example.caffeinated.models.getRecipes

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

            MovieDetails(modifier = Modifier.padding(12.dp), recipe = recipe)
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
            tint = MaterialTheme.colors.secondary,
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
fun MovieDetails(modifier: Modifier = Modifier, recipe: Recipe) {

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
                if (expanded) Icons.Filled.KeyboardArrowDown
                else Icons.Filled.KeyboardArrowUp,
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
            Text(text = "Manual: ${recipe.manual}", style = MaterialTheme.typography.caption)
            Text(text = "Released: ${recipe.year}", style = MaterialTheme.typography.caption)
            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.DarkGray, fontSize = 13.sp)) {
                        append("Comments: ")
                    }

                    for (comments in recipe.comments) {
                        append("$comments ")
                    }
                },
                style = MaterialTheme.typography.caption
            )

            Divider(modifier = Modifier.padding(3.dp))
        }
    }
}