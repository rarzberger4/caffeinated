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
            manual = "Put Coffee in water and enjoy...",
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
        ),
        Recipe(
            id = "3",
            title = "Rezept 3",
            year = "2022",
            manual = "Mix milk, cocoa, and sugar. Heat and serve.",
            images = listOf("https://images.immediate.co.uk/production/volatile/sites/30/2020/08/hot-chocolate-1b8b262.jpg"),
            rating = 8.5,
            comments = listOf("Delicious hot chocolate recipe!")
        ),
        Recipe(
            id = "4",
            title = "Rezept 4",
            year = "2010",
            manual = "Blend fruits and yogurt to make a healthy smoothie.",
            images = listOf("https://images.immediate.co.uk/production/volatile/sites/30/2020/08/fruit-smoothie-350c52c.jpg"),
            rating = 7.2,
            comments = listOf("Refreshing smoothie recipe!")
        ),
        Recipe(
            id = "5",
            title = "Rezept 5",
            year = "2021",
            manual = "Grill the chicken and serve with veggies and sauce.",
            images = listOf("https://images.immediate.co.uk/production/volatile/sites/30/2020/08/grilled-chicken-1ef7f35.jpg"),
            rating = 9.0,
            comments = listOf("Perfectly grilled chicken!")
        ),
        Recipe(
            id = "6",
            title = "Rezept 6",
            year = "2015",
            manual = "Boil pasta, mix with sauce, and garnish with cheese.",
            images = listOf("https://images.immediate.co.uk/production/volatile/sites/30/2020/08/pasta-bolognese-9a058ad.jpg"),
            rating = 8.7,
            comments = listOf("Classic pasta recipe!")
        ),
        Recipe(
            id = "7",
            title = "Rezept 7",
            year = "2020",
            manual = "Bake the cake batter and frost with buttercream.",
            images = listOf("https://images.immediate.co.uk/production/volatile/sites/30/2020/08/victoria-sponge-0d6ce15.jpg"),
            rating = 9.5,
            comments = listOf("Moist and delicious cake recipe!")
        ),
        Recipe(
            id = "8",
            title = "Rezept 8",
            year = "2019",
            manual = "Marinate the steak and grill to perfection.",
            images = listOf("https://images.immediate.co.uk/production/volatile/sites/30/2020/08/steak-diane-5a180fe.jpg"),
            rating = 9.2,
            comments = listOf("Tender and juicy steak recipe!")
        ),
        Recipe(
            id = "9",
            title = "Rezept 9",
            year = "2022",
            manual = "Roast the vegetables and toss with dressing.",
            images = listOf("https://images.immediate.co.uk/production/volatile/sites/30/2020/08/roasted-vegetables-89ac8db.jpg"),
            rating = 8.8,
            comments = listOf("Healthy and flavorful vegetable recipe!")
        ),
        Recipe(
            id = "10",
            title = "Rezept 10",
            year = "2018",
            manual = "Make dough, add toppings, and bake the pizza.",
            images = listOf("https://images.immediate.co.uk/production/volatile/sites/30/2020/08/pizza-8b55650.jpg"),
            rating = 9.7,
            comments = listOf("Homemade pizza recipe!")
        )
    )
}