package com.example.caffeinated.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.caffeinated.repositories.RecipeRepo

class RecipiesViewModelFactory (private val repository: RecipeRepo): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(RecipiesViewModel::class.java)){
            return RecipiesViewModel(repository = repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}