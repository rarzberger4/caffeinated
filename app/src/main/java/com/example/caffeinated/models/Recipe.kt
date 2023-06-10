package com.example.caffeinated.models

import android.media.Rating
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

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
    var rating: Int = 0,
    var comments: List<String> = listOf(),
    var isFavorite: Boolean = false,
    val roastinglvl: Int = 0,
    val origin: String = "",
    val ingredients: List<String> = listOf()
) {
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
            rating = 0,
            comments = listOf("This is a Comment", "Second Comment"),
            roastinglvl = 3,
            origin = "Colombia",
            ingredients = listOf("Coffee beans", "Water", "Sugar")
        ),

        Recipe(
            id = "2",
            title = "Rezept 2",
            year = "1998",
            manual = "Take the beans and eat them with water",
            images = listOf("https://images.immediate.co.uk/production/volatile/sites/30/2020/08/flat-white-3402c4f.jpg"),
            rating = 2,
            comments = listOf("This is another Comment"),
            roastinglvl = 2,
            origin = "Brazil",
            ingredients = listOf("Coffee beans", "Water")
        ),

        Recipe(
            id = "3",
            title = "Rezept 3",
            year = "2022",
            manual = "Mix coffee, milk, cocoa, and sugar. Heat and serve.",
            images = listOf("https://images.immediate.co.uk/production/volatile/sites/30/2020/08/hot-chocolate-1b8b262.jpg"),
            rating = 3,
            comments = listOf("Delicious coffee hot chocolate recipe!"),
            roastinglvl = 1,
            origin = "Switzerland",
            ingredients = listOf("Coffee", "Milk", "Cocoa", "Sugar")
        ),

        Recipe(
            id = "4",
            title = "Rezept 4",
            year = "2010",
            manual = "Blend coffee, fruits, and yogurt to make a healthy smoothie.",
            images = listOf("https://images.immediate.co.uk/production/volatile/sites/30/2020/08/fruit-smoothie-350c52c.jpg"),
            rating = 4,
            comments = listOf("Refreshing coffee smoothie recipe!"),
            roastinglvl = 2,
            origin = "Unknown",
            ingredients = listOf("Coffee", "Fruits", "Yogurt")
        ),

        Recipe(
            id = "5",
            title = "Rezept 5",
            year = "2021",
            manual = "Grind coffee beans, brew, and serve with milk and sugar.",
            images = listOf("https://images.immediate.co.uk/production/volatile/sites/30/2020/08/grilled-chicken-1ef7f35.jpg"),
            rating = 5,
            comments = listOf("Perfectly brewed coffee recipe!"),
            roastinglvl = 3,
            origin = "Unknown",
            ingredients = listOf("Coffee beans", "Water", "Milk", "Sugar")
        ),

        Recipe(
            id = "6",
            title = "Rezept 6",
            year = "2015",
            manual = "Boil coffee-infused water, add pasta, mix with sauce, and garnish with cheese.",
            images = listOf("https://images.immediate.co.uk/production/volatile/sites/30/2020/08/pasta-bolognese-9a058ad.jpg"),
            rating = 4,
            comments = listOf("Classic coffee-infused pasta recipe!"),
            roastinglvl = 1,
            origin = "Italy",
            ingredients = listOf("Coffee", "Water", "Pasta", "Sauce", "Cheese")
        ),

        Recipe(
            id = "7",
            title = "Rezept 7",
            year = "2020",
            manual = "Bake coffee-infused cake batter and frost with coffee-flavored buttercream.",
            images = listOf("https://images.immediate.co.uk/production/volatile/sites/30/2020/08/victoria-sponge-0d6ce15.jpg"),
            rating = 3,
            comments = listOf("Moist and delicious coffee cake recipe!"),
            roastinglvl = 2,
            origin = "Unknown",
            ingredients = listOf("Coffee", "Flour", "Sugar", "Butter", "Eggs", "Baking powder")
        ),

        Recipe(
            id = "8",
            title = "Rezept 8",
            year = "2019",
            manual = "Marinate steak with coffee-infused seasoning and grill to perfection.",
            images = listOf("https://images.immediate.co.uk/production/volatile/sites/30/2020/08/steak-diane-5a180fe.jpg"),
            rating = 2,
            comments = listOf("Tender and flavorful coffee-infused steak recipe!"),
            roastinglvl = 3,
            origin = "Unknown",
            ingredients = listOf("Coffee", "Steak", "Salt", "Pepper", "Garlic powder", "Olive oil")
        ),

        Recipe(
            id = "9",
            title = "Rezept 9",
            year = "2022",
            manual = "Roast coffee-infused vegetables and toss with dressing.",
            images = listOf("https://images.immediate.co.uk/production/volatile/sites/30/2020/08/roasted-vegetables-89ac8db.jpg"),
            rating = 1,
            comments = listOf("Healthy and flavorful coffee-infused vegetable recipe!"),
            roastinglvl = 2,
            origin = "Unknown",
            ingredients = listOf("Coffee", "Vegetables", "Olive oil", "Salt", "Pepper", "Herbs")
        ),

        Recipe(
            id = "10",
            title = "Rezept 10",
            year = "2018",
            manual = "Make coffee-infused dough, add toppings, and bake the pizza.",
            images = listOf("https://images.immediate.co.uk/production/volatile/sites/30/2020/08/pizza-8b55650.jpg"),
            rating = 3,
            comments = listOf("Homemade coffee-infused pizza recipe!"),
            roastinglvl = 2,
            origin = "Italy",
            ingredients = listOf(
                "Coffee",
                "Flour",
                "Yeast",
                "Water",
                "Salt",
                "Olive oil",
                "Pizza toppings"
            )
        )
    )
}