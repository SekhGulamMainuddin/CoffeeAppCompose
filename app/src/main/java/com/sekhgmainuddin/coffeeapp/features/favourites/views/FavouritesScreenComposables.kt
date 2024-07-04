package com.sekhgmainuddin.coffeeapp.features.favourites.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sekhgmainuddin.coffeeapp.R
import com.sekhgmainuddin.coffeeapp.core.common.AppTextStyles
import com.sekhgmainuddin.coffeeapp.core.common.composables.AppIconButton
import com.sekhgmainuddin.coffeeapp.core.common.composables.CoffeeOrBeanDetailComposable
import com.sekhgmainuddin.coffeeapp.core.tempData.ItemData
import com.sekhgmainuddin.coffeeapp.core.tempData.TempData
import com.sekhgmainuddin.coffeeapp.core.theme.AppColors

@Composable
fun FavouritesItem(modifier: Modifier = Modifier, item: ItemData) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(25.dp))
    ) {
        Column {
            CoffeeOrBeanDetailComposable(
                data = item,
            )
            Text(
                modifier = Modifier
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                AppColors.ThemedMidGrey,
                                AppColors.ThemedDarkGrey
                            ),
                            start = Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY),
                            end = Offset(0f, 0f)
                        ),
                    )
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(top = 10.dp, bottom = 20.dp),
                text = buildAnnotatedString {
                    withStyle(
                        style = AppTextStyles.S14.copy(
                            color = AppColors.ThemedLightGrey,
                            lineHeight = 20.sp,
                        ).toSpanStyle()
                    ) {
                        append("Description\n")
                    }
                    append(item.desc)
                },
                style = AppTextStyles.R12,
                maxLines = 4,
                overflow = TextOverflow.Ellipsis
            )
        }
        AppIconButton(
            modifier = Modifier.padding(
                top = 20.dp,
                end = 15.dp
            ).align(Alignment.TopEnd),
            onClick = {
                TempData.favoriteList.remove(item)
            },
            iconId = R.drawable.favourites_icon,
            tint = AppColors.PrimaryThemedColor
        )
    }
}