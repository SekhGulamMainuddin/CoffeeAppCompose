package com.sekhgmainuddin.coffeeapp.features.home.views

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sekhgmainuddin.coffeeapp.R
import com.sekhgmainuddin.coffeeapp.core.common.AppTextS14
import com.sekhgmainuddin.coffeeapp.core.common.AppTextS16
import com.sekhgmainuddin.coffeeapp.core.common.AppTextS28
import com.sekhgmainuddin.coffeeapp.core.theme.AppColors

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    val homeScreenScrollState = rememberScrollState()
    val query = remember { mutableStateOf("aaa") }
    val scrollScope = rememberScrollState()
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
        SearchBar(
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
                .padding(horizontal = 25.dp)
                .clip(RoundedCornerShape(10.dp)),
            colors = SearchBarDefaults.colors(
                containerColor = AppColors.ThemedMidBlack,
                dividerColor = AppColors.ThemedLightGrey,
                inputFieldColors = TextFieldDefaults.colors(
                    focusedTextColor = AppColors.ThemedWhite,
                    unfocusedTextColor = AppColors.ThemedLightGrey,
                )
            ),
            placeholder = {
                Text(
                    text = stringResource(R.string.find_your_coffee),
                    color = AppColors.ThemedGrey,
                    style = MaterialTheme.typography.labelSmall.copy(
                        color = AppColors.ThemedGrey,
                    ),
                )
            },
            query = query.value,
            onQueryChange = {
                query.value = it
            },
            onSearch = {

            },
            active = true,
            onActiveChange = {

            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.search_icon),
                    contentDescription = stringResource(R.string.search_icon),
                    modifier = Modifier.size(20.dp),
                    tint = AppColors.ThemedGrey
                )
            },
            trailingIcon = {
                if (query.value.isNotEmpty()) {
                    IconButton(
                        onClick = {
                            query.value = ""
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
            }
        ) {
        }
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
                    Divider(
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .size(7.dp)
                            .clip(CircleShape),
                        color = AppColors.SecondaryThemedColor,
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
        Row(
            modifier = Modifier
                .horizontalScroll(scrollScope)
                .padding(start = 30.dp, end = 30.dp, top = 10.dp, bottom = 10.dp),
        ) {
            (0..10).forEach { _ ->
                CoffeeItem(modifier = Modifier.padding(end = 20.dp))
            }
        }
        AppTextS16(
            text = "Coffee beans",
            modifier = Modifier.padding(start = 30.dp, top = 10.dp, bottom = 20.dp),
        )
        LazyRow(
            contentPadding = PaddingValues(start = 30.dp, end = 30.dp),
        ) {
            items(10) {
                CoffeeItem(modifier = Modifier.padding(end = 20.dp))
            }
        }
    }
}