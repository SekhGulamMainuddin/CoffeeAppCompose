package com.sekhgmainuddin.coffeeapp.features.home.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sekhgmainuddin.coffeeapp.R
import com.sekhgmainuddin.coffeeapp.core.theme.CoffeeAppTheme
import com.sekhgmainuddin.coffeeapp.core.theme.ThemedBlack
import com.sekhgmainuddin.coffeeapp.core.theme.ThemedWhite

@Preview
@Composable
fun CoffeeItem(modifier: Modifier = Modifier) {
    return CoffeeAppTheme {
        Box(
            modifier = Modifier
                .height(245.dp)
                .width(150.dp)
                .clip(RoundedCornerShape(24.dp))
                .background(
                    brush = Brush.linearGradient(
                        start = Offset(0f, 0f),
                        end = Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY),
                        colors = listOf(
                            ThemedBlack.copy(alpha = 0.2f),
                            ThemedBlack,
                        ),
                    ),
                )
                .padding(
                    10.dp,
                )
                .padding(bottom = 20.dp),
        ) {
            Column {
                Image(
                    painter = painterResource(id = R.drawable.robusta_been),
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
                    Text(
                        text = "Robusta Bean",
                        color = ThemedWhite,
                        style = MaterialTheme.typography.labelLarge,
                    )
                    Text(
                        text = "Medium Roasted",
                        color = ThemedWhite,
                        style = MaterialTheme.typography.labelSmall,
                    )
                }
                Row {
                    buildAnnotatedString {
                        append("4.5")
                        withStyle(
                            MaterialTheme.typography.labelSmall.copy(color = ThemedWhite)
                                .toSpanStyle()
                        ) {
                            append(" (200)")
                        }
                        pop()
                    }
                }
            }
        }
    }
}