package com.sekhgmainuddin.coffeeapp.features.orderHistory.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sekhgmainuddin.coffeeapp.R
import com.sekhgmainuddin.coffeeapp.core.common.AppTextM10
import com.sekhgmainuddin.coffeeapp.core.common.AppTextM16
import com.sekhgmainuddin.coffeeapp.core.common.AppTextR10
import com.sekhgmainuddin.coffeeapp.core.common.AppTextR14
import com.sekhgmainuddin.coffeeapp.core.common.AppTextR16
import com.sekhgmainuddin.coffeeapp.core.common.AppTextS14
import com.sekhgmainuddin.coffeeapp.core.common.AppTextS16
import com.sekhgmainuddin.coffeeapp.core.common.AppTextStyles
import com.sekhgmainuddin.coffeeapp.core.common.composables.PriceComposable
import com.sekhgmainuddin.coffeeapp.core.theme.AppColors
import kotlin.random.Random

@Preview
@Composable
fun OrderHistoryItem(modifier: Modifier = Modifier) {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            AppTextS14(
                text = "Order Date"
            )
            AppTextS14(
                text = "Total Amount"
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            AppTextR14(
                text = "20th March 16:23"
            )
            AppTextR14(
                text = "\$ 74.40",
                color = AppColors.SecondaryThemedColor
            )
        }
        IntArray(Random.nextInt(1, 3)).asList().forEach {
            Column(
                modifier = modifier
                    .padding(top = 20.dp)
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
                    .padding(horizontal = 20.dp, vertical = 16.dp)
            ) {
                Row(
                    modifier = Modifier
                        .padding(bottom = 2.dp)
                        .fillMaxWidth()
                        .height(IntrinsicSize.Min),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier
                            .size(60.dp)
                            .clip(
                                RoundedCornerShape(16.dp)
                            ),
                        painter = painterResource(id = R.drawable.cappuchino),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                    )
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 20.dp)
                    ) {
                        AppTextR16(text = "Cappuccino")
                        AppTextR10(
                            modifier = Modifier.padding(top = 4.dp),
                            text = "With Steamed Milk",
                            color = AppColors.ThemedLightGrey,
                        )
                    }
                    PriceComposable(
                        price = "37.20",
                        textStyle = AppTextStyles.S20,
                    )
                }
                IntArray(Random.nextInt(1, 3)).asList().forEach {
                    Row(
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Box(modifier = Modifier
                            .fillMaxWidth(fraction = 0.5f)
                            .clip(RoundedCornerShape(10.dp))
                            .background(color = AppColors.ThemedBlack),
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                if(Random.nextBoolean()) {
                                    AppTextM16(
                                        modifier = Modifier.fillMaxWidth(0.4f),
                                        text = "S",
                                        textAlign = TextAlign.Center,
                                        maxLines = 1
                                    )
                                } else {
                                    AppTextM10(
                                        modifier = Modifier.fillMaxWidth(0.4f),
                                        text = "250gm",
                                        textAlign = TextAlign.Center,
                                        maxLines = 1,
                                        color = AppColors.ThemedLightGrey
                                    )
                                }
                                VerticalDivider(
                                    modifier = Modifier.height(35.dp),
                                    color = AppColors.ThemedDarkGrey,
                                )
                                PriceComposable(
                                    modifier = Modifier.fillMaxWidth(),
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                        Text(
                            modifier = modifier,
                            text = buildAnnotatedString {
                                pushStyle(
                                    AppTextStyles.S16.copy(color = AppColors.SecondaryThemedColor)
                                        .toSpanStyle()
                                )
                                append("X")
                                pop()
                                append(" ${Random.nextInt(10)}")
                            },
                            style = AppTextStyles.S16,
                        )
                        AppTextS16(
                            text = String.format("%.2f", Random.nextDouble(12.5)),
                            color = AppColors.SecondaryThemedColor
                        )
                    }
                }
            }
        }
    }
}