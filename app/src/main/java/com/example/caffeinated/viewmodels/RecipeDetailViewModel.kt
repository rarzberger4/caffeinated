package com.example.caffeinated.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.caffeinated.models.Recipe
import com.example.caffeinated.repositories.RecipeRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

// inherit from ViewModel class
class RecipeDetailViewModel(private val repository: RecipeRepo, private val id: Long): ViewModel() {
    val recipeState = MutableStateFlow(Recipe())
    //val movieListState: StateFlow<List<Movie>> = _movieListState.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getById(id)
                .collect{ recipe ->
                    recipe?.let {
                        recipeState.value = recipe
                    }
                }
        }
    }

    suspend fun updateFavoriteRecipe(recipe: Recipe) {
        recipe.isFavorite = !recipe.isFavorite
        repository.updateRecipe(recipe)
    }
}