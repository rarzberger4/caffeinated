package com.example.caffeinated.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.caffeinated.models.Recipe
import com.example.caffeinated.repositories.RecipeRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch



class RecipiesViewModel(private val repository: RecipeRepo): ViewModel()  {
    private val _recipeListState = MutableStateFlow(listOf<Recipe>())
    val recipeListState: StateFlow<List<Recipe>> = _recipeListState.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getAllRecipes().distinctUntilChanged()
                .collect{listOfRecipes ->
                    if (listOfRecipes.isNullOrEmpty()){
                        Log.d("RecipesViewModel", "Empty Recipes")
                    }else{
                        _recipeListState.value = listOfRecipes
                    }

                }
        }
    }
}