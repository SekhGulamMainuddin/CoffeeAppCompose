package com.sekhgmainuddin.coffeeapp.core.common.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sekhgmainuddin.coffeeapp.R
import com.sekhgmainuddin.coffeeapp.core.common.AppTextM10
import com.sekhgmainuddin.coffeeapp.core.common.AppTextR12
import com.sekhgmainuddin.coffeeapp.core.common.AppTextS20
import com.sekhgmainuddin.coffeeapp.core.common.AppTextStyles
import com.sekhgmainuddin.coffeeapp.core.tempData.ItemData
import com.sekhgmainuddin.coffeeapp.core.theme.AppColors
import com.sekhgmainuddin.coffeeapp.features.coffeeOrBeanDetails.views.CoffeeBeanCharacteristics

@Composable
fun CoffeeOrBeanDetailComposable(modifier: Modifier = Modifier, data: ItemData) {
    val annotatedString = buildAnnotatedString {
        appendInlineContent(id = "startIcon")
        append("  ${data.ratings}  ")
        withStyle(
            AppTextStyles.R10.copy(
                color = AppColors.ThemedLightGrey,
            ).toSpanStyle(),
        ) {
            append("(${"%,d".format(data.numberOrUsersRate)})")
        }
    }
    val inlineContentMap = mapOf(
        "startIcon" to InlineTextContent(
            Placeholder(20.sp, 20.sp, PlaceholderVerticalAlign.TextCenter)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.star_icon),
                modifier = Modifier.size(22.dp),
                contentDescription = "",
                tint = AppColors.SecondaryThemedColor
            )
        }
    )

    Box {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp),
            painter = painterResource(id = data.image),
            contentDescription = "",
            contentScale = ContentScale.Crop,
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .background(
                    color = AppColors.ThemedBlack.copy(
                        alpha = 0.5f,
                    ),
                    shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp)
                )
                .padding(horizontal = 20.dp)
                .padding(top = 20.dp)
        ) {
            Row {
                Column {
                    AppTextS20(
                        text = data.name,
                    )
                    AppTextR12(
                        text = data.shortDesc,
                        color = AppColors.ThemedLightGrey,
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                CoffeeBeanCharacteristics(
                    modifier = Modifier.padding(end = 15.dp),
                    iconId = data.descTab[0].first,
                    text = data.descTab[0].second
                )
                CoffeeBeanCharacteristics(
                    iconId = data.descTab[1].first,
                    text = data.descTab[1].second
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 10.dp,
                        bottom = 10.dp
                    ),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = annotatedString,
                    inlineContent = inlineContentMap,
                    style = AppTextStyles.S16,
                )
            }
        }
    }
}