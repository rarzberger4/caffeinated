package com.example.caffeinated.screens


const val DETAIL_ARGUMENT_KEY = "recipeID"

sealed class Screen(val route: String) {
    object HomeScreen : Screen("home")
    object InfoScreen : Screen("info")
    object DetailScreen : Screen("detail/{$DETAIL_ARGUMENT_KEY}") {
        fun withId(id: String): String {
            return this.route.replace(oldValue = "{$DETAIL_ARGUMENT_KEY}", newValue = id)
        }
    }

    object FavoriteScreen : Screen("favorite")

}