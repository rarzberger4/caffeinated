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
            title = "Caffe Caturra ",
            year = "1900",
            manual = "1. rind El Salvador coffee beans to your desired consistency.\n" +
                    "2. Boil water and let it cool slightly to around 200°F (93°C).\n" +
                    "3. Place the ground coffee into a coffee maker or a French press.\n" +
                    "4. Pour hot water over the coffee and let it steep for about 4-5 minutes.\n" +
                    "5. Press or strain the coffee to separate the grounds",
            images = listOf("https://cdn.shopify.com/s/files/1/0013/2510/5212/articles/8.22-COLUMBIAN-COFFEE.jpg?v=1566456985"),
            rating = 0,
            comments = listOf("This coffee tastes great"),
            roastinglvl = 3,
            origin = "Colombia",
            ingredients = listOf("Coffee beans", "Water", "Sugar")
        ),

        Recipe(
            id = "2",
            title = "Mundo Novo",
            year = "1950",
            manual = "\n1. Grind Mundo Novo coffee beans to a medium-fine consistency.\n" +
                    "2. Bring water to a boil in a kettle or saucepan.\n" +
                    "3. Let the coffee steep for about 4-5 minutes.\n" +
                    "4. Pour the brewed coffee into cups or mugs.",
            images = listOf("https://cdn.shopify.com/s/files/1/0629/0328/8043/files/kc-blog-mundonovo-brunch-1024x634.jpg"),
            rating = 2,
            comments = listOf(""),
            roastinglvl = 2,
            origin = "Brazil",
            ingredients = listOf("Coffee beans", "Water")
        ),

        Recipe(
            id = "3",
            title = "Egg Coffee",
            year = "202",
            manual = "\n1. add eggs yolks + condensed milk to a cup and mix them\n" +
                    "2. Place phin on your mug and add coffee grounds.\n" +
                    "3. Fill up phin with boliong water and let coffee brew it.\n" +
                    "4. Mix everything together until smooth.",
            images = listOf("https://afoodieworld.com/wp-content/uploads/2023/04/egg_coffee_nfrwfr.jpg"),
            rating = 3,
            comments = listOf(""),
            roastinglvl = 2,
            origin = "Vietnam",
            ingredients = listOf("Coffee", "Milk", "Cocoa", "Sugar")
        ),

        Recipe(
            id = "4",
            title = "Cappuccino",
            year = "1920",
            manual = "\n1. Brew a shot of espresso using an espresso machine or a moka pot.\n" +
                    "2. While the espresso is brewing, heat the milk in a saucepan or using a milk.\n" +
                    "3. If desired, add sugar to the heated milk and stir until dissolved.\n" +
                    "4. Serve the cappuccino immediately while it's still hot.\n",
            images = listOf("https://upload.wikimedia.org/wikipedia/commons/c/c8/Cappuccino_at_Sightglass_Coffee.jpg"),
            rating = 4,
            comments = listOf(""),
            roastinglvl = 2,
            origin = "Italy",
            ingredients = listOf("Coffee", "Fruits", "Yogurt")
        ),

        Recipe(
            id = "5",
            title = "Espresso",
            year = "1930",
            manual = "\n1. Grind the coffee beans to a fine consistency.\n" +
                    "2. Measure approximately 18-20 grams of coffee grounds for a double shot of espresso.\n" +
                    "3. Lock the portafilter into the espresso machine.\n" +
                    "4. The espresso should begin flowing into the cups in a steady stream.\n" +
                    "5. Serve the espresso immediately while it's hot.",
            images = listOf("https://www.thespruceeats.com/thmb/HJrjMfXdLGHbgMhnM0fMkDx9XPQ=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/what-is-espresso-765702-hero-03_cropped-ffbc0c7cf45a46ff846843040c8f370c.jpg"),
            rating = 5,
            comments = listOf("Perfectly brewed coffee recipe!"),
            roastinglvl = 3,
            origin = "Italy",
            ingredients = listOf("Coffee beans", "Water", "Milk", "Sugar")
        ),

        Recipe(
            id = "6",
            title = "Bourbon",
            year = "2000",
            manual = "\n1. Grind the Bourbon coffee beans to a medium consistency.\n" +
                    "2. Measure the desired amount of coffee grounds\n" +
                    "3. Stir the coffee grounds and water gently to ensure even extraction.\n" +
                    "4. Let the coffee steep for about 4-5 minutes.\n" +
                    "5. Optionally, add sugar, milk,ice or other flavorings according to your preference.",
            images = listOf("https://jamiegeller.com/.image/t_share/MTY1NTI0OTQ1ODY5MzUwNDM4/coffee-bourbon-cocktail-horizontal.jpg"),
            rating = 4,
            comments = listOf(""),
            roastinglvl = 3,
            origin = "Italy",
            ingredients = listOf("Coffee", "Water", "Pasta", "Sauce", "Cheese")
        ),

        Recipe(
            id = "7",
            title = "Pacas",
            year = "2001",
            manual = "\n1. Grind the Bourbon coffee beans to a medium consistency.\n" +
                    "2. Measure the desired amount of coffee grounds\n" +
                    "3. Stir the coffee grounds and water gently to ensure even extraction.\n" +
                    "4. Let the coffee steep for about 4-5 minutes.\n" +
                    "5. Optionally, add sugar, milk or other flavorings according to your preference.",
            images = listOf("https://walmartsv.vtexassets.com/arquivos/ids/224134/Cafe-Pacas-Gourmet-Molido-454-Gr-1-3620.jpg?v=637805686087300000"),
            rating = 3,
            comments = listOf(""),
            roastinglvl = 1,
            origin = "El Salvador",
            ingredients = listOf("Coffee", "Flour", "Sugar", "Butter", "Eggs", "Baking powder")
        ),

        Recipe(
            id = "8",
            title = "Typica",
            year = "2000",
            manual = "\n1. Grind the Bourbon coffee beans to a medium consistency.\n" +
                    "2. Measure the desired amount of coffee grounds\n" +
                    "3. Stir the coffee grounds and water gently to ensure even extraction.\n" +
                    "4. Let the coffee steep for about 4-5 minutes.\n" +
                    "5. Optionally, add sugar, milk or other flavorings according to your preference.",
            images = listOf("https://assets1.phonebooky.com/listings/assets/000/036/428/original/coffee4.jpg"),
            rating = 2,
            comments = listOf(""),
            roastinglvl = 4,
            origin = "Guatemala",
            ingredients = listOf("Coffee", "Steak", "Salt", "Pepper", "Garlic powder", "Olive oil")
        )
    )
}