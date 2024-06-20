package com.sekhgmainuddin.coffeeapp.core.common.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sekhgmainuddin.coffeeapp.core.common.AppTextM10
import com.sekhgmainuddin.coffeeapp.core.common.AppTextM12
import com.sekhgmainuddin.coffeeapp.core.common.AppTextStyles
import com.sekhgmainuddin.coffeeapp.core.theme.AppColors

@Preview
@Composable
fun PriceComposable(
    modifier: Modifier = Modifier,
    price: String = "4.99",
    textStyle: TextStyle = AppTextStyles.S16,
    currencyColor: Color? = null,
    textAlign: TextAlign = TextAlign.Start
) {
    Text(
        modifier = modifier,
        text = buildAnnotatedString {
            pushStyle(
                textStyle.copy(color = currencyColor ?: AppColors.SecondaryThemedColor)
                    .toSpanStyle()
            )
            append("$")
            pop()
            append(" $price")
        },
        style = textStyle,
        textAlign = textAlign
    )
}

@Composable
fun PriceAndPayComposable(
    modifier: Modifier = Modifier,
    totalAmount: String,
    payButtonText: String,
    onPayClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = 20.dp,
                vertical = 25.dp
            ),
        horizontalArrangement = Arrangement.spacedBy(50.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AppTextM12(
                text = "Price",
                color = AppColors.ThemedLightGrey
            )
            PriceComposable(
                price = totalAmount,
                textStyle = AppTextStyles.S20,
            )
        }
        PrimaryButton(
            modifier = Modifier.weight(1f),
            text = payButtonText,
            onClick = onPayClick
        )
    }
}

@Preview
@Composable
fun RoastedType(modifier: Modifier = Modifier, horizontalPadding: Int = 10) {
    Box(
        modifier = modifier
            .clip(
                RoundedCornerShape(10.dp)
            )
            .background(AppColors.ThemedBlack)
            .defaultMinSize(
                minWidth = 100.dp,
                minHeight = 40.dp
            )
            .padding(horizontal = horizontalPadding.dp),
    ) {
        AppTextM10(
            modifier = Modifier.align(Alignment.Center),
            text = "Medium Roasted",
            color = AppColors.ThemedLightGrey,
            textAlign = TextAlign.Center,
        )
    }
}