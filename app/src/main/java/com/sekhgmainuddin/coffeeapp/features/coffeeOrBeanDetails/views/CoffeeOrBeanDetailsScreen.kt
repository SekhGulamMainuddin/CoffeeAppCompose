package com.sekhgmainuddin.coffeeapp.features.coffeeOrBeanDetails.views

import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.sekhgmainuddin.coffeeapp.R
import com.sekhgmainuddin.coffeeapp.core.common.AppTextR12
import com.sekhgmainuddin.coffeeapp.core.common.AppTextS14
import com.sekhgmainuddin.coffeeapp.core.common.composables.AppIconButton
import com.sekhgmainuddin.coffeeapp.core.common.composables.CoffeeOrBeanDetailComposable
import com.sekhgmainuddin.coffeeapp.core.common.composables.CustomTopAppBar
import com.sekhgmainuddin.coffeeapp.core.common.composables.PriceAndPayComposable
import com.sekhgmainuddin.coffeeapp.core.helpers.format
import com.sekhgmainuddin.coffeeapp.core.tempData.CartItemData
import com.sekhgmainuddin.coffeeapp.core.tempData.ItemData
import com.sekhgmainuddin.coffeeapp.core.tempData.ItemType
import com.sekhgmainuddin.coffeeapp.core.tempData.Price
import com.sekhgmainuddin.coffeeapp.core.tempData.QuantityType
import com.sekhgmainuddin.coffeeapp.core.tempData.TempData
import com.sekhgmainuddin.coffeeapp.core.theme.AppColors
import java.util.UUID

@Composable
fun CoffeeOrBeanDetailsScreen(
    mainNavController: NavController,
    productId: String,
    itemType: ItemType
) {

    val context = LocalContext.current

    var isSmallSelected by remember {
        mutableStateOf(true)
    }
    var isMediumSelected by remember {
        mutableStateOf(false)
    }
    var isLargeSelected by remember {
        mutableStateOf(false)
    }

    lateinit var data: ItemData
    lateinit var quantityTypes: List<QuantityType>

    if (itemType == ItemType.COFFEE) {
        data = TempData.coffeeList.find {
            it.id == productId
        }!!
        quantityTypes = listOf(QuantityType.S, QuantityType.M, QuantityType.L)
    } else {
        data = TempData.beanList.find {
            it.id == productId
        }!!
        quantityTypes = listOf(QuantityType.GM250, QuantityType.GM500, QuantityType.GM1000)
    }

    var isFavourite by remember {
        mutableStateOf(TempData.favoriteList.find {
            it.id == productId
        } != null)
    }

    val price = mutableListOf<Price>()
    var totalAmount = 0.0
    if (isSmallSelected) {
        totalAmount += data.price[0]
        price.add(
            Price(
                if (itemType == ItemType.COFFEE) QuantityType.S else QuantityType.GM250,
                1,
                data.price[0]
            )
        )
    }
    if (isMediumSelected) {
        totalAmount += data.price[1]
        price.add(
            Price(
                if (itemType == ItemType.COFFEE) QuantityType.M else QuantityType.GM500,
                1,
                data.price[1]
            )
        )
    }
    if (isLargeSelected) {
        totalAmount += data.price[2]
        price.add(
            Price(
                if (itemType == ItemType.COFFEE) QuantityType.L else QuantityType.GM1000,
                1,
                data.price[2]
            )
        )
    }

    Scaffold(
        containerColor = AppColors.ThemedBlack,
        topBar = {
            CustomTopAppBar(
                actions = {
                    AppIconButton(
                        iconId = R.drawable.favourites_icon,
                        tint = if (isFavourite) AppColors.PrimaryThemedColor else AppColors.ThemedWhite,
                        contentDescriptionId = R.string.favourites_icon,
                        onClick = {
                            if(isFavourite) {
                                TempData.favoriteList.removeIf {
                                    it.id == productId
                                }
                            } else {
                                TempData.favoriteList.add(0, data)
                            }
                            Toast.makeText(context, if(isFavourite) "Item Removed from Favourites" else "Item Added to Favourites", Toast.LENGTH_SHORT)
                                .show()
                            isFavourite = !isFavourite
                        },
                    )
                },
                onBackPressed = {
                    mainNavController.popBackStack()
                }
            )
        },
        bottomBar = {
            PriceAndPayComposable(
                modifier = Modifier.padding(20.dp),
                totalAmount = totalAmount.format(2),
                payButtonText = "Add to Cart"
            ) {
                Toast.makeText(context, "Item Added to Cart", Toast.LENGTH_SHORT).show()
                TempData.cartList.add(
                    CartItemData(
                        UUID.randomUUID().toString(),
                        data,
                        price
                    )
                )
            }
        }
    ) {
        it
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
        ) {
            CoffeeOrBeanDetailComposable(data = data)
            Column(
                modifier = Modifier.padding(
                    20.dp,
                ),
            ) {
                AppTextS14(
                    text = "Description",
                    color = AppColors.ThemedLightGrey
                )
                AppTextR12(
                    modifier = Modifier.padding(vertical = 15.dp),
                    text = data.desc,
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
                        text = quantityTypes[0].displayName,
                        isSelected = isSmallSelected
                    ) {
                        isSmallSelected = !isSmallSelected
                    }
                    SizeSelectButton(
                        modifier = Modifier.weight(1f),
                        text = quantityTypes[1].displayName,
                        isSelected = isMediumSelected
                    ) {
                        isMediumSelected = !isMediumSelected
                    }
                    SizeSelectButton(
                        modifier = Modifier.weight(1f),
                        text = quantityTypes[2].displayName,
                        isSelected = isLargeSelected
                    ) {
                        isLargeSelected = !isLargeSelected
                    }
                }
            }
        }
    }
}