package com.sekhgmainuddin.coffeeapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sekhgmainuddin.coffeeapp.core.common.composables.AppIconButton
import com.sekhgmainuddin.coffeeapp.core.common.composables.CustomTopAppBar
import com.sekhgmainuddin.coffeeapp.core.routes.Routes
import com.sekhgmainuddin.coffeeapp.core.theme.AppColors
import com.sekhgmainuddin.coffeeapp.core.theme.CoffeeAppTheme
import com.sekhgmainuddin.coffeeapp.features.cart.views.CartScreen
import com.sekhgmainuddin.coffeeapp.features.coffeeOrBeanDetails.views.CoffeeOrBeanDetailsScreen
import com.sekhgmainuddin.coffeeapp.features.favourites.views.FavouritesScreen
import com.sekhgmainuddin.coffeeapp.features.home.views.HomeScreen
import com.sekhgmainuddin.coffeeapp.features.orderHistory.views.OrderHistoryScreen
import com.sekhgmainuddin.coffeeapp.features.payment.views.PaymentScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val mainNavController = rememberNavController()
            CoffeeAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(
                        navController = mainNavController,
                        startDestination = Routes.HomeScreen.route
                    ) {
                        composable(Routes.HomeScreen.route) {
                            MainComposable(mainNavController)
                        }
                        composable(
                            Routes.CoffeeOrBeanDetailScreen.route,
                            arguments = Routes.CoffeeOrBeanDetailScreen.arguments,
                        ) {
                            CoffeeOrBeanDetailsScreen(
                                mainNavController,
                                it.arguments?.getString("productId") ?:""
                            )
                        }
                        composable(
                            Routes.PaymentScreen.route,
                            arguments = Routes.PaymentScreen.arguments,
                        ) {
                            PaymentScreen(
                                it.arguments?.getString("totalAmount")!!
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MainComposable(mainNavController: NavController) {
    var selectedBottomBarItem by remember {
        mutableIntStateOf(0)
    }
    val appBarTitle = when (selectedBottomBarItem) {
        0 -> ""
        1 -> stringResource(R.string.cart_screen)
        2 -> stringResource(R.string.favourites_screen)
        3 -> stringResource(R.string.order_history_screen)
        else -> ""
    }
    val bottomNavigationNavController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CustomTopAppBar(
                showBackButton = false,
                title = appBarTitle,
                navigationItems = {
                    AppIconButton(
                        onClick = { /*TODO*/ },
                        iconId = R.drawable.menu_icon,
                        contentDescriptionId = R.string.menu_icon,
                    )
                },
                actions = {
                    OutlinedIconButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .padding(end = 5.dp)
                            .size(35.dp),
                        shape = RoundedCornerShape(10.dp),
                        border = BorderStroke(
                            width = 1.dp,
                            color = AppColors.ThemedDarkGrey,
                        ),
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.profile_icon),
                            contentDescription = stringResource(R.string.profile_image),
                            contentScale = ContentScale.Fit,
                        )
                    }
                },
            )
        },
        bottomBar = {
            NavigationBar(
                containerColor = Color.Transparent,
            ) {
                val bottomTabs = listOf(
                    Pair(
                        R.drawable.home,
                        R.string.home_screen,
                    ),
                    Pair(
                        R.drawable.cart_icon,
                        R.string.cart_screen,
                    ),
                    Pair(
                        R.drawable.favourites_icon,
                        R.string.favourites_screen,
                    ),
                    Pair(
                        R.drawable.notification_icon,
                        R.string.order_history_screen,
                    ),
                )

                bottomTabs.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = {
                            Icon(
                                painter = painterResource(id = item.first),
                                contentDescription = stringResource(item.second),
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = AppColors.SecondaryThemedColor,
                            unselectedIconColor = AppColors.ThemedGrey,
                            indicatorColor = AppColors.ThemedBlack,
                        ),
                        alwaysShowLabel = false,
                        selected = selectedBottomBarItem == index,
                        onClick = {
                            selectedBottomBarItem = index
                            val route = when (index) {
                                0 -> Routes.HomeScreen.route
                                1 -> Routes.CartScreen.route
                                2 -> Routes.FavouritesScreen.route
                                3 -> Routes.OrderHistoryScreen.route
                                else -> Routes.HomeScreen.route
                            }
                            bottomNavigationNavController.navigate(route)
                        },
                    )
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            modifier = Modifier.padding(paddingValues),
            navController = bottomNavigationNavController,
            startDestination = Routes.HomeScreen.route,
            enterTransition = { // you can change whatever you want transition
                EnterTransition.None
            },
            exitTransition = {
                ExitTransition.None
            }
        ) {
            composable(Routes.HomeScreen.route) {
                HomeScreen(
                    mainNavController = mainNavController,
                    bottomNavController = bottomNavigationNavController,
                )
            }
            composable(Routes.CartScreen.route) {
                CartScreen()
            }
            composable(Routes.FavouritesScreen.route) {
                FavouritesScreen()
            }
            composable(Routes.OrderHistoryScreen.route) {
                OrderHistoryScreen()
            }
        }
    }
}