package com.sekhgmainuddin.coffeeapp.features.home.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.sekhgmainuddin.coffeeapp.R
import com.sekhgmainuddin.coffeeapp.core.common.AppTextM10
import com.sekhgmainuddin.coffeeapp.core.common.AppTextS14
import com.sekhgmainuddin.coffeeapp.core.common.AppTextS16
import com.sekhgmainuddin.coffeeapp.core.common.AppTextS28
import com.sekhgmainuddin.coffeeapp.core.common.AppTextStyles
import com.sekhgmainuddin.coffeeapp.core.routes.Routes
import com.sekhgmainuddin.coffeeapp.core.tempData.ItemType
import com.sekhgmainuddin.coffeeapp.core.tempData.TempData
import com.sekhgmainuddin.coffeeapp.core.theme.AppColors

@Composable
fun HomeScreen(
    bottomNavController: NavController,
    mainNavController: NavController,
) {
    val homeScreenScrollState = rememberScrollState()
    var query by remember { mutableStateOf("") }
    val tabs = listOf("All", "Cappuccino", "Espresso", "Americano", "Macchiato")
    var tabIndex by remember { mutableIntStateOf(0) }
    val keyboardController = LocalSoftwareKeyboardController.current

    return Column(modifier = Modifier.verticalScroll(homeScreenScrollState)) {
        AppTextS28(
            text = "Find the best coffee for you",
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(horizontal = 25.dp)
                .padding(top = 15.dp, bottom = 25.dp),
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
                .padding(horizontal = 25.dp),
            value = query,
            onValueChange = { query = it },
            singleLine = true,
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.search_icon),
                    contentDescription = stringResource(R.string.search_icon),
                    modifier = Modifier.size(20.dp),
                    tint = AppColors.ThemedGrey
                )
            },
            textStyle = AppTextStyles.M10,
            shape = RoundedCornerShape(10.dp),
            trailingIcon = {
                if (query.isNotEmpty()) {
                    IconButton(
                        onClick = {
                            query = ""
                            keyboardController?.hide()
                        },
                        modifier = Modifier.size(20.dp),
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.close_icon),
                            contentDescription = stringResource(R.string.close_icon),
                            modifier = Modifier.size(20.dp),
                            tint = AppColors.ThemedGrey
                        )
                    }
                }
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = AppColors.ThemedMidBlack,
                unfocusedContainerColor = AppColors.ThemedMidBlack,
                focusedTextColor = AppColors.ThemedWhite,
                unfocusedTextColor = AppColors.ThemedLightGrey,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            placeholder = {
                AppTextM10(
                    text = stringResource(R.string.find_your_coffee),
                    color = AppColors.ThemedGrey,
                )
            },
        )
        ScrollableTabRow(
            selectedTabIndex = tabIndex,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            containerColor = Color.Transparent,
            edgePadding = 10.dp,
            divider = {

            },
            indicator = { tabPositions ->
                Box(modifier = Modifier.tabIndicatorOffset(tabPositions[tabIndex])) {
                    HorizontalDivider(
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .size(7.dp)
                            .clip(CircleShape),
                        color = AppColors.SecondaryThemedColor
                    )
                }
            }
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    text = {
                        AppTextS14(
                            text = title,
                            color = if (tabIndex == index) AppColors.SecondaryThemedColor else AppColors.ThemedGrey
                        )
                    },
                    selected = tabIndex == index,
                    onClick = { tabIndex = index },
                )
            }
        }
        LazyRow(
            contentPadding = PaddingValues(
                start = 30.dp, end = 30.dp, top = 10.dp, bottom = 10.dp
            ),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            itemsIndexed(TempData.coffeeList) { _, item ->
                CoffeeItem(
                    onClick = {
                        mainNavController.navigate("product-details-screen/productId=" + item.id + "&itemType=${ItemType.COFFEE.name}")
                    },
                )
            }
        }
        AppTextS16(
            text = "Coffee beans",
            modifier = Modifier.padding(start = 30.dp, top = 10.dp, bottom = 20.dp),
        )
        LazyRow(
            contentPadding = PaddingValues(start = 30.dp, end = 30.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            itemsIndexed(TempData.beanList) { _, item ->
                CoffeeItem(
                    onClick = {
                        mainNavController.navigate("product-details-screen/"+ "productId=" + item.id + "&itemType=${ItemType.COFFEE_BEAN.name}")
                    },
                )
            }
        }
    }
}