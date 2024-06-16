package com.sekhgmainuddin.coffeeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sekhgmainuddin.coffeeapp.core.common.composables.AppIconButton
import com.sekhgmainuddin.coffeeapp.core.common.composables.CustomTopAppBar
import com.sekhgmainuddin.coffeeapp.core.theme.AppColors
import com.sekhgmainuddin.coffeeapp.core.theme.CoffeeAppTheme
import com.sekhgmainuddin.coffeeapp.features.home.views.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainComposable()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun MainComposable(modifier: Modifier = Modifier) {
    var selectedBottomBarItem by remember {
        mutableIntStateOf(0)
    }

    CoffeeAppTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                CustomTopAppBar(
                    showBackButton = false,
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
                            onClick = { selectedBottomBarItem = index },
                        )
                    }
                }
            }
        ) { paddingValues ->
            Box(modifier = Modifier.padding(paddingValues)) {
                HomeScreen()
            }
        }
    }
}