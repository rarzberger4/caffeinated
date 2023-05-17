package com.example.caffeinated.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Recipe(
    @PrimaryKey(autoGenerate = true)
    val dbId: Long = 0,
    @ColumnInfo(name = "original_id")
    val id: String = UUID.randomUUID().toString(),
    val title: String = "",
    val year: String = "",
    val manual: String = "No plot available",
    val images: List<String> = listOf(),
    val rating: Double = 0.0,
    val comments: List<String>,
    var isFavorite: Boolean = false
){
    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }
    //var isFavorite by mutableStateOf(initialIsFavorite)
}


fun getRecipes(): List<Recipe> {
    return listOf(
        Recipe(
            id = "1",
            title = "Rezept 1",
            year = "2023",
            manual = "Put Coffee in water and enjoy",
            images = listOf("https://images.immediate.co.uk/production/volatile/sites/30/2020/08/cappucino-32dbfba.jpg"),
            rating = 9.9,
            comments = listOf("This is a Comment")
        ),
        Recipe(
            id = "2",
            title = "Rezept 2",
            year = "1998",
            manual = "Take the beans and eat them with water",
            images = listOf("https://images.immediate.co.uk/production/volatile/sites/30/2020/08/flat-white-3402c4f.jpg"),
            rating = 0.1,
            comments = listOf("This is another Comment")
        )
    )
}