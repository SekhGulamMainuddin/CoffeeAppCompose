package com.sekhgmainuddin.coffeeapp.features.coffeeOrBeanDetails.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sekhgmainuddin.coffeeapp.R
import com.sekhgmainuddin.coffeeapp.core.common.AppTextR12
import com.sekhgmainuddin.coffeeapp.core.common.AppTextS14
import com.sekhgmainuddin.coffeeapp.core.common.composables.AppIconButton
import com.sekhgmainuddin.coffeeapp.core.common.composables.CoffeeOrBeanDetailComposable
import com.sekhgmainuddin.coffeeapp.core.common.composables.CustomTopAppBar
import com.sekhgmainuddin.coffeeapp.core.common.composables.PriceAndPayComposable
import com.sekhgmainuddin.coffeeapp.core.theme.AppColors

@Preview
@Composable
fun CoffeeOrBeanDetailsScreen(modifier: Modifier = Modifier) {

    var isSmallSelected by remember {
        mutableStateOf(false)
    }
    var isMediumSelected by remember {
        mutableStateOf(false)
    }
    var isLargeSelected by remember {
        mutableStateOf(false)
    }

    Scaffold(
        containerColor = AppColors.ThemedBlack,
        topBar = {
            CustomTopAppBar(
                actions = {
                    AppIconButton(
                        iconId = R.drawable.favourites_icon,
                        tint = AppColors.PrimaryThemedColor,
                        contentDescriptionId = R.string.favourites_icon,
                        onClick = { /* TODO: Open menu */ },
                    )
                },
            )
        },
        bottomBar = {
            PriceAndPayComposable(
                totalAmount = "10.50",
                payButtonText = "Add to Cart"
            ) {

            }
        }
    ) {
        it
        Column(
            modifier = modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
        ) {
            CoffeeOrBeanDetailComposable()
            Column(
                modifier = modifier.padding(
                    20.dp,
                ),
            ) {
                AppTextS14(
                    text = "Description",
                    color = AppColors.ThemedLightGrey
                )
                AppTextR12(
                    modifier = Modifier.padding(vertical = 15.dp),
                    text = "Arabica beans are by far the most popular type of coffee beans, making up about 60% of the world’s coffee. These tasty beans originated many centuries ago in the highlands of Ethiopia, and may even be the first coffee beans ever consumed!",
                )
                AppTextS14(
                    text = "Size",
                    color = AppColors.ThemedLightGrey
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(22.dp)
                ) {
                    SizeSelectButton(
                        modifier = Modifier.weight(1f),
                        text = "250gm",
                        isSelected = isSmallSelected
                    )
                    SizeSelectButton(
                        modifier = Modifier.weight(1f),
                        text = "500gm",
                        isSelected = isMediumSelected
                    )
                    SizeSelectButton(
                        modifier = Modifier.weight(1f),
                        text = "1000gm",
                        isSelected = isLargeSelected
                    )
                }
            }
        }
    }
}