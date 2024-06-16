package com.sekhgmainuddin.coffeeapp.features.home.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sekhgmainuddin.coffeeapp.R
import com.sekhgmainuddin.coffeeapp.core.common.AppTextR10
import com.sekhgmainuddin.coffeeapp.core.common.AppTextR14
import com.sekhgmainuddin.coffeeapp.core.common.AppTextS10
import com.sekhgmainuddin.coffeeapp.core.common.AppTextS16
import com.sekhgmainuddin.coffeeapp.core.common.AppTextStyles
import com.sekhgmainuddin.coffeeapp.core.common.composables.PriceComposable
import com.sekhgmainuddin.coffeeapp.core.theme.AppColors
import com.sekhgmainuddin.coffeeapp.core.theme.CoffeeAppTheme

@Preview
@Composable
fun CoffeeItem(modifier: Modifier = Modifier) {
    return CoffeeAppTheme {
        Box(
            modifier = modifier
                .height(245.dp)
                .width(150.dp)
                .clip(RoundedCornerShape(24.dp))
                .background(
                    brush = Brush.linearGradient(
                        start = Offset(0f, 0f),
                        end = Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY),
                        colors = listOf(
                            AppColors.ThemedLightBlack,
                            AppColors.ThemedBlack,
                        ),
                    ),
                )
                .padding(
                    12.dp,
                )
                .clickable { },
        ) {
            Column {
                Image(
                    painter = painterResource(id = R.drawable.cappuchino),
                    contentDescription = stringResource(
                        R.string.coffee_image
                    ),
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .height(125.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp)),
                )
                Column(
                    modifier = Modifier
                        .padding(
                            vertical = 10.dp,
                        )
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    AppTextR14(
                        text = "Robusta Bean",
                    )
                    AppTextR10(
                        text = "With Steamed Milk",
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        PriceComposable(
                            price = "4.99",
                        )
                        OutlinedIconButton(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .size(28.dp),
                            colors = IconButtonDefaults.iconButtonColors(
                                containerColor = AppColors.SecondaryThemedColor,
                            ),
                            shape = RoundedCornerShape(8.dp),
                        ) {
                            Icon(
                                modifier = Modifier.padding(
                                    7.dp
                                ),
                                imageVector = Icons.Default.Add,
                                tint = AppColors.ThemedWhite,
                                contentDescription = stringResource(R.string.add_item_icon),
                            )
                        }
                    }
                }
            }
            Row(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .clip(
                        RoundedCornerShape(
                            bottomStart = 26.dp,
                            topEnd = 16.dp,
                        )
                    )
                    .background(
                        color = AppColors.ThemedBlack.copy(alpha = 0.6f),
                    )
                    .padding(
                        start = 12.dp,
                        end = 12.dp,
                        top = 3.dp,
                        bottom = 5.dp,
                    ),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    modifier = Modifier.size(10.dp),
                    painter = painterResource(id = R.drawable.star_icon),
                    tint = AppColors.SecondaryThemedColor,
                    contentDescription = stringResource(
                        R.string.item_rating
                    )
                )
                AppTextS10(
                    text = "4.5",
                    modifier = Modifier.padding(
                        start = 4.dp,
                    ),
                )
            }
        }
    }
}