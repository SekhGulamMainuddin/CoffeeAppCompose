package com.sekhgmainuddin.coffeeapp.core.tempData

import androidx.annotation.DrawableRes
import com.sekhgmainuddin.coffeeapp.R
import java.util.UUID

data class ItemData(
    val id: String,
    val name: String,
    val shortDesc: String,
    val desc: String,
    val ratings: Double,
    val numberOrUsersRate: Int,
    val price: List<Double>,
    val type: ItemType,
    @DrawableRes val image: Int,
    val descTab: List<Pair<Int, String>>,
    val label: String,
)

enum class ItemType {
    COFFEE_BEAN,
    COFFEE
}

data class CartItemData(
    val id: String,
    val itemData: ItemData,
    val price: List<Price>,
)

data class Price(
    val quantityType: QuantityType,
    val quantity: Int,
    val price: Double,
)

enum class QuantityType {
    S,
    M,
    L,
    GM250,
    GM500,
    GM1000;

    val displayName
        get() = when (this) {
            S -> "S"
            M -> "M"
            L -> "L"
            GM250 -> "250gm"
            GM500 -> "500gm"
            GM1000 -> "1000gm"
        }
}

data class OrderHistoryItem(
    val id: String,
    val items: List<HistoryItem>
)

data class HistoryItem(
    val id: String,
    val itemData: ItemData,
    val quantityTypeAndQuantity: List<Pair<QuantityType, Int>>
)

object TempData {
    val coffeeList = mutableListOf(
        ItemData(
            UUID.randomUUID().toString(),
            "Cappuccino",
            "With Steamed Milk",
            "Cappuccino is a latte made with more foam than steamed milk, often with a sprinkle of cocoa powder or cinnamon on top.",
            ratings = 4.5,
            numberOrUsersRate = 6879,
            price = listOf(4.5, 8.0, 15.0),
            type = ItemType.COFFEE,
            image = R.drawable.cappuchino,
            descTab = listOf(
                Pair(
                    R.drawable.coffee,
                    "Coffee"
                ),
                Pair(
                    R.drawable.milk_icon,
                    "Milk"
                )
            ),
            label = "Medium Roasted"
        ),
        ItemData(
            UUID.randomUUID().toString(),
            "Cappuccino",
            "With Foam",
            "Cappuccino is a latte made with more foam than steamed milk, often with a sprinkle of cocoa powder or cinnamon on top.",
            ratings = 4.2,
            numberOrUsersRate = 7542,
            price = listOf(4.2, 7.5, 14.2),
            type = ItemType.COFFEE,
            image = R.drawable.cappuchino_2,
            descTab = listOf(
                Pair(
                    R.drawable.coffee,
                    "Coffee"
                ),
                Pair(
                    R.drawable.milk_icon,
                    "Milk"
                )
            ),
            label = "Medium Roasted"
        ),
        ItemData(
            UUID.randomUUID().toString(),
            "Cappuccino",
            "With Steamed Milk",
            "Cappuccino is a latte made with more foam than steamed milk, often with a sprinkle of cocoa powder or cinnamon on top.",
            ratings = 4.5,
            numberOrUsersRate = 6879,
            price = listOf(4.5, 8.0, 15.0),
            type = ItemType.COFFEE,
            image = R.drawable.cappuchino,
            descTab = listOf(
                Pair(
                    R.drawable.coffee,
                    "Coffee"
                ),
                Pair(
                    R.drawable.milk_icon,
                    "Milk"
                )
            ),
            label = "Medium Roasted"
        )
    )
    val beanList = mutableListOf(
        ItemData(
            UUID.randomUUID().toString(),
            "Robusta Beans",
            "From Africa",
            "Arabica beans are by far the most popular type of coffee beans, making up about 60% of the world’s coffee. These tasty beans originated many centuries ago in the highlands of Ethiopia, and may even be the first coffee beans ever consumed! ",
            ratings = 4.5,
            numberOrUsersRate = 2487,
            price = listOf(2.1, 3.8, 5.5),
            type = ItemType.COFFEE_BEAN,
            image = R.drawable.robusta_been,
            descTab = listOf(
                Pair(
                    R.drawable.bean,
                    "Bean"
                ),
                Pair(
                    R.drawable.location_icon,
                    "Africa"
                )
            ),
            label = "Medium Roasted"
        ),
        ItemData(
            UUID.randomUUID().toString(),
            "Cappuccino",
            "From America",
            "Cappuccino is a latte made with more foam than steamed milk, often with a sprinkle of cocoa powder or cinnamon on top.",
            ratings = 4.2,
            numberOrUsersRate = 7542,
            price = listOf(4.2, 7.5, 14.2),
            type = ItemType.COFFEE_BEAN,
            image = R.drawable.cappuchino_2,
            descTab = listOf(
                Pair(
                    R.drawable.bean,
                    "Bean"
                ),
                Pair(
                    R.drawable.location_icon,
                    "America"
                )
            ),
            label = "Medium Roasted"
        ),
        ItemData(
            UUID.randomUUID().toString(),
            "Liberica Coffee Beans",
            "From Liberia",
            "Liberica coffee beans, originating from West Africa and grown in Southeast Asia, are notable for their large, irregular shape and bold, full-bodied flavor with woody and smoky notes. Rare and less common than Arabica and Robusta, they offer a unique, robust coffee experience for enthusiasts seeking something distinct.",
            ratings = 4.8,
            numberOrUsersRate = 6179,
            price = listOf(4.5, 7.0, 11.0),
            type = ItemType.COFFEE_BEAN,
            image = R.drawable.liberica_coffee_beans,
            descTab = listOf(
                Pair(
                    R.drawable.bean,
                    "Bean"
                ),
                Pair(
                    R.drawable.location_icon,
                    "Liberia"
                )
            ),
            label = "Medium Roasted"
        )
    )
    val cartList = mutableListOf(
        CartItemData(
            UUID.randomUUID().toString(),
            coffeeList[0],
            listOf(
                Price(QuantityType.S, 1, coffeeList[0].price[0]),
                Price(QuantityType.M, 2, coffeeList[0].price[1]),
                Price(QuantityType.L, 1, coffeeList[0].price[2])
            ),
        ),
        CartItemData(
            UUID.randomUUID().toString(),
            beanList[0],
            listOf(
                Price(QuantityType.GM250, 1, beanList[0].price[0]),
            ),
        ),
        CartItemData(
            UUID.randomUUID().toString(),
            beanList[2],
            listOf(
                Price(QuantityType.GM250, 1, beanList[2].price[0]),
                Price(QuantityType.GM1000, 1, beanList[2].price[2]),
            ),
        ),
        CartItemData(
            UUID.randomUUID().toString(),
            coffeeList[1],
            listOf(
                Price(QuantityType.L, 2, coffeeList[1].price[2])
            ),
        ),
    )
    val favoriteList = mutableListOf(
        coffeeList[0],
        beanList[0],
        coffeeList[1],
        beanList[2]
    )
    val orderHistory = mutableListOf(
        OrderHistoryItem(
            UUID.randomUUID().toString(),
            listOf(
                HistoryItem(
                    UUID.randomUUID().toString(),
                    coffeeList[0],
                    listOf(
                        Pair(QuantityType.S, 1),
                        Pair(QuantityType.M, 2),
                    )
                ),
                HistoryItem(
                    UUID.randomUUID().toString(),
                    beanList[0],
                    listOf(
                        Pair(QuantityType.GM250, 1),
                    )
                ),
            )
        ),
        OrderHistoryItem(
            UUID.randomUUID().toString(),
            listOf(
                HistoryItem(
                    UUID.randomUUID().toString(),
                    coffeeList[1],
                    listOf(
                        Pair(QuantityType.L, 2),
                    )
                ),
                HistoryItem(
                    UUID.randomUUID().toString(),
                    beanList[2],
                    listOf(
                        Pair(QuantityType.GM250, 1),
                        Pair(QuantityType.GM1000, 1),
                    )
                ),
            )
        ),
        OrderHistoryItem(
            UUID.randomUUID().toString(),
            listOf(
                HistoryItem(
                    UUID.randomUUID().toString(),
                    coffeeList[0],
                    listOf(
                        Pair(QuantityType.S, 1),
                        Pair(QuantityType.M, 2),
                    )
                ),
                HistoryItem(
                    UUID.randomUUID().toString(),
                    beanList[0],
                    listOf(
                        Pair(QuantityType.GM250, 1),
                    )
                ),
            )
        ),
    )
}