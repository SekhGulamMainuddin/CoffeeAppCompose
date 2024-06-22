package com.sekhgmainuddin.coffeeapp.core.routes

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Routes(val route: String, val arguments: List<NamedNavArgument> = emptyList()) {
    data object HomeScreen : Routes("home-screen")
    data object CartScreen : Routes("cart-screen")
    data object OrderHistoryScreen : Routes("order-history-screen")
    data object FavouritesScreen : Routes("favourites-screen")
    data object CoffeeOrBeanDetailScreen :
        Routes(
            "product-details-screen/{productId}",
            arguments = listOf(
                navArgument("productId") { type = NavType.StringType }
            ),
        )

    data object PaymentScreen : Routes(
        "payment-screen/{totalAmount}",
        arguments = listOf(
            navArgument("totalAmount") { type = NavType.StringType }
        ),
    )
}