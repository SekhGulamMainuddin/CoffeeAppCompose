package com.sekhgmainuddin.coffeeapp.core.common.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sekhgmainuddin.coffeeapp.R
import com.sekhgmainuddin.coffeeapp.core.common.AppTextM10
import com.sekhgmainuddin.coffeeapp.core.common.AppTextS16
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

@Preview()
@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    text: String = "Primary Button",
    onClick: () -> Unit = {},
) {
    ElevatedButton(
        onClick = onClick,
        modifier = modifier
            .height(60.dp),
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.elevatedButtonColors(
            containerColor = AppColors.SecondaryThemedColor,
        ),
    ) {
        AppTextS16(
            text = text
        )
    }
}

@Preview()
@Composable
fun SecondaryButton(
    modifier: Modifier = Modifier,
    text: String = "Secondary Button",
    onClick: () -> Unit = {},
) {
    ElevatedButton(
        modifier = modifier,
        onClick = onClick,
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.elevatedButtonColors(
            containerColor = AppColors.ThemedMidBlack,
        ),
    ) {
        AppTextM10(
            text = text,
            color = AppColors.ThemedLightGrey,
        )
    }
}