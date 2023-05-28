package com.example.caffeinated.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.caffeinated.repositories.RecipeRepo


class RecipeDetailViewModelFactory(private val repository: RecipeRepo, private val id: Long): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(RecipeDetailViewModel::class.java)){
            return RecipeDetailViewModel(repository = repository, id) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}