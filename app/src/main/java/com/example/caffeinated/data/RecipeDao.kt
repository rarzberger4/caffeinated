package com.example.caffeinated.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao {

    @Insert
    suspend fun add(recipe: Recipe)

    @Update
    suspend fun update(recipe: Recipe)

    @Delete
    fun delete(recipe: Recipe)

    @Query("SELECT * from recipe")
    fun getAll(): Flow<List<Recipe>>

    @Query("SELECT * from recipe WHERE isFavorite = 1")
    fun getFavorites(): Flow<List<Recipe>>

    @Query("SELECT * from recipe WHERE dbId =:id")
    fun get(id: Long): Flow<Recipe>

    @Query("DELETE from recipe")
    suspend fun deleteAll()
}