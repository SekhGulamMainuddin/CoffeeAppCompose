package com.sekhgmainuddin.coffeeapp.features.cart.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sekhgmainuddin.coffeeapp.R
import com.sekhgmainuddin.coffeeapp.core.common.AppTextM10
import com.sekhgmainuddin.coffeeapp.core.common.AppTextM16
import com.sekhgmainuddin.coffeeapp.core.common.AppTextR10
import com.sekhgmainuddin.coffeeapp.core.common.AppTextR16
import com.sekhgmainuddin.coffeeapp.core.common.AppTextS16
import com.sekhgmainuddin.coffeeapp.core.common.AppTextStyles
import com.sekhgmainuddin.coffeeapp.core.common.composables.PriceComposable
import com.sekhgmainuddin.coffeeapp.core.common.composables.RoastedType
import com.sekhgmainuddin.coffeeapp.core.helpers.format
import com.sekhgmainuddin.coffeeapp.core.tempData.CartItemData
import com.sekhgmainuddin.coffeeapp.core.tempData.QuantityTypeCategory
import com.sekhgmainuddin.coffeeapp.core.tempData.TempData
import com.sekhgmainuddin.coffeeapp.core.theme.AppColors

@Composable
fun CartItemViewTypeMultiple(
    modifier: Modifier = Modifier,
    cartItemData: CartItemData,
    index: Int,
) {
    val quantityType = cartItemData.price[0].quantityType.category
    val price = cartItemData.price

    Column(
        modifier = modifier
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        AppColors.ThemedMidGrey,
                        AppColors.ThemedDarkGrey
                    ),
                    start = Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY),
                    end = Offset(0f, 0f)
                ),
                shape = RoundedCornerShape(
                    24.dp
                ),
            )
            .padding(12.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(bottom = 2.dp)
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
        ) {
            Image(
                modifier = Modifier
                    .size(90.dp)
                    .clip(
                        RoundedCornerShape(16.dp)
                    ),
                painter = painterResource(id = R.drawable.cappuchino),
                contentDescription = "",
                contentScale = ContentScale.Crop,
            )
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(horizontal = 20.dp)
            ) {
                AppTextR16(text = "Cappuccino")
                AppTextR10(
                    modifier = Modifier.padding(top = 4.dp),
                    text = "With Steamed Milk",
                    color = AppColors.ThemedLightGrey,
                )
                Spacer(modifier = Modifier.weight(1f))
                RoastedType(
                    horizontalPadding = 15,
                    label = "Roasted",
                )
            }
        }
        price.forEachIndexed { index, it ->
            Row(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                QuantityTypeComposable(
                    quantityType = quantityType,
                    sizeOrWeight = it.quantityType.displayName
                )
                PriceComposable(
                    price = (it.price * it.quantity).format(2)
                )
                AddOrRemoveItem(
                    count = it.quantity,
                    onAdd = {

                    },
                    onRemove = {

                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun QuantityTypeComposable(
    modifier: Modifier = Modifier,
    quantityType: QuantityTypeCategory = QuantityTypeCategory.WEIGHT,
    sizeOrWeight: String = ""
) {
    Box(
        modifier = modifier
            .clip(
                RoundedCornerShape(10.dp)
            )
            .background(AppColors.ThemedBlack)
            .size(
                width = 75.dp,
                height = 35.dp
            ),
        contentAlignment = Alignment.Center
    ) {
        if (quantityType == QuantityTypeCategory.SIZE)
            AppTextM16(
                text = sizeOrWeight,
            )
        else AppTextM10(
            text = sizeOrWeight,
            color = AppColors.ThemedLightGrey
        )
    }
}

@Composable
fun CartItemViewTypeSingle(
    modifier: Modifier = Modifier,
    cartItemData: CartItemData,
    index: Int,
) {
    val quantityType = cartItemData.price[0].quantityType.category
    val sizeOrWeight = cartItemData.price[0].quantityType.displayName
    val quantity = cartItemData.price[0].quantity
    val price = cartItemData.price[0].price

    Column(
        modifier = modifier
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        AppColors.ThemedMidGrey,
                        AppColors.ThemedDarkGrey
                    ),
                    start = Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY),
                    end = Offset(0f, 0f)
                ),
                shape = RoundedCornerShape(
                    24.dp
                ),
            )
            .padding(12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
        ) {
            Image(
                modifier = Modifier
                    .size(110.dp)
                    .clip(
                        RoundedCornerShape(16.dp)
                    ),
                painter = painterResource(id = R.drawable.cappuchino),
                contentDescription = "",
                contentScale = ContentScale.Crop,
            )
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(horizontal = 20.dp)
            ) {
                AppTextR16(text = "Cappuccino")
                AppTextR10(
                    modifier = Modifier.padding(top = 4.dp),
                    text = "With Steamed Milk",
                    color = AppColors.ThemedLightGrey,
                )
                Spacer(modifier = Modifier.weight(1f))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    QuantityTypeComposable(
                        sizeOrWeight = sizeOrWeight,
                        quantityType = quantityType
                    )
                    PriceComposable(
                        price = (price * quantity).format(2),
                        textStyle = AppTextStyles.S20
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AddOrRemoveItem(
                        count = quantity,
                        onAdd = {
                            TempData.cartList[index] = cartItemData.copy(
                                price = cartItemData.price.map {
                                    it.copy(
                                        quantity = it.quantity + 1
                                    )
                                }
                            )
                        },
                        onRemove = {
                            if (quantity > 1) {
                                TempData.cartList[index] = cartItemData.copy(
                                    price = cartItemData.price.map {
                                        it.copy(
                                            quantity = it.quantity - 1
                                        )
                                    }
                                )
                            } else {
                                TempData.cartList.removeIf {
                                    it.id == cartItemData.id
                                }
                            }
                        }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun AddOrRemoveItem(
    count: Int = 1,
    onAdd: () -> Unit = {},
    onRemove: () -> Unit = {}
) {
    AddOrRemoveButton(
        iconId = R.drawable.subtract_icon,
        onClick = onRemove
    )
    Box(
        modifier = Modifier
            .size(width = 56.dp, height = 30.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(color = AppColors.ThemedBlack)
            .border(
                width = 1.dp,
                shape = RoundedCornerShape(8.dp),
                color = AppColors.SecondaryThemedColor
            )
    ) {
        AppTextS16(
            modifier = Modifier.align(Alignment.Center),
            text = "$count",
        )
    }
    AddOrRemoveButton(
        iconId = R.drawable.add_icon,
        onClick = onAdd
    )
}

@Preview
@Composable
fun AddOrRemoveButton(
    iconId: Int = R.drawable.add_icon,
    onClick: () -> Unit = {}
) {
    ElevatedButton(
        onClick = onClick,
        contentPadding = PaddingValues(0.dp),
        modifier = Modifier.size(30.dp),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.elevatedButtonColors(
            containerColor = AppColors.SecondaryThemedColor,
        )
    ) {
        Icon(
            modifier = Modifier.size(10.dp),
            painter = painterResource(iconId),
            contentDescription = "",
            tint = AppColors.ThemedWhite
        )
    }
}