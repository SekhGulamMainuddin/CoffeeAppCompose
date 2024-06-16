package com.sekhgmainuddin.coffeeapp.features.payment.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sekhgmainuddin.coffeeapp.R
import com.sekhgmainuddin.coffeeapp.core.common.AppTextM14
import com.sekhgmainuddin.coffeeapp.core.common.AppTextM16
import com.sekhgmainuddin.coffeeapp.core.common.AppTextR10
import com.sekhgmainuddin.coffeeapp.core.common.AppTextS14
import com.sekhgmainuddin.coffeeapp.core.common.AppTextS16
import com.sekhgmainuddin.coffeeapp.core.common.AppTextStyles
import com.sekhgmainuddin.coffeeapp.core.common.composables.PriceComposable
import com.sekhgmainuddin.coffeeapp.core.theme.AppColors

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun CreditCardComposable(
    modifier: Modifier = Modifier,
    isSelected: Boolean = true,
    onClick: () -> Unit = {}
) {
    OutlinedButton(
        modifier = modifier
            .padding(20.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(25.dp),
        border = BorderStroke(
            width = if (isSelected) 2.dp else 0.dp,
            color = if (isSelected) AppColors.SecondaryThemedColor
            else
                Color.Transparent,
        ),
        contentPadding = PaddingValues(15.dp),
        onClick = { /*TODO*/ }) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            AppTextS14(
                text = "Credit Card",
            )
            Column(
                modifier = Modifier
                    .padding(top = 12.dp)
                    .fillMaxWidth()
                    .height(186.dp)
                    .clip(RoundedCornerShape(15.dp))
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
                            10.dp
                        ),
                    )
                    .padding(horizontal = 12.dp)
                    .padding(top = 15.dp, bottom = 10.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.sim_icon),
                        contentDescription = "",
                    )
                    Image(
                        painter = painterResource(id = R.drawable.visa_icon),
                        contentDescription = "",
                    )
                }
                AppTextS16(
                    text = "3897 8923 6745 4638"
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        AppTextR10(
                            text = "Card Holder Name",
                            color = AppColors.ThemedWhite.copy(alpha = 0.5f),
                        )
                        AppTextM16(
                            text = "Robert Evans",
                        )
                    }
                    Column {
                        AppTextR10(
                            text = "Expiry Date",
                            color = AppColors.ThemedWhite.copy(alpha = 0.5f),
                        )
                        AppTextM14(
                            text = "12/24",
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun PaymentOptionButton(
    modifier: Modifier = Modifier,
    iconId: Int = R.drawable.wallet_icon,
    text: String = "Wallet",
    balance: String? = null,
    isSelected: Boolean = false,
    onClick: () -> Unit = {},
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier
            .padding(horizontal = 20.dp)
            .padding(bottom = 10.dp)
            .fillMaxWidth()
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
                    25.dp
                ),
            ),
        border = BorderStroke(
            width = 2.dp,
            color = if (isSelected) AppColors.SecondaryThemedColor
            else
                AppColors.ThemedLightBlack,
        ),
        contentPadding = PaddingValues(15.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.size(22.dp),
                painter = painterResource(id = iconId),
                contentDescription = "",
            )
            AppTextS14(
                modifier = Modifier
                    .padding(horizontal = 15.dp)
                    .weight(1f),
                text = text,
            )
            balance?.let {
                PriceComposable(
                    textStyle = AppTextStyles.R14,
                    price = it,
                    currencyColor = AppColors.ThemedWhite
                )
            }
        }
    }
}