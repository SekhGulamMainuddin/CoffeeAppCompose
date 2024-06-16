package com.sekhgmainuddin.coffeeapp.core.common.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sekhgmainuddin.coffeeapp.R
import com.sekhgmainuddin.coffeeapp.core.common.AppTextStyles
import com.sekhgmainuddin.coffeeapp.core.theme.AppColors

@Preview()
@Composable
fun AppIconButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    iconId: Int = R.drawable.menu_icon,
    tint: Color = AppColors.ThemedGrey,
    contentDescriptionId: Int = R.string.menu_icon,
) {
    IconButton(
        onClick = onClick,
    ) {
        Icon(
            tint = tint,
            painter = painterResource(id = iconId),
            contentDescription = stringResource(contentDescriptionId),
            modifier = modifier
                .size(35.dp)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            AppColors.ThemedMidGrey,
                            AppColors.ThemedDarkGrey
                        ),
                        start = Offset(100f, 100f),
                        end = Offset(0f, 0f)
                    ),
                    shape = RoundedCornerShape(
                        10.dp
                    ),
                )
                .border(
                    border = BorderStroke(
                        color = AppColors.ThemedDarkGrey,
                        width = 1.dp,
                    ),
                    shape = RoundedCornerShape(10.dp),
                )
                .padding(10.dp),
        )
    }
}

@Composable
fun PriceComposable(
    modifier: Modifier = Modifier,
    price: String = "4.99",
    textStyle: TextStyle = AppTextStyles.S16,
) {
    Text(
        modifier = modifier,
        text = buildAnnotatedString {
            pushStyle(
                textStyle.copy(color = AppColors.SecondaryThemedColor)
                    .toSpanStyle()
            )
            append("$")
            pop()
            append(" $price")
        },
        style = textStyle,
    )
}