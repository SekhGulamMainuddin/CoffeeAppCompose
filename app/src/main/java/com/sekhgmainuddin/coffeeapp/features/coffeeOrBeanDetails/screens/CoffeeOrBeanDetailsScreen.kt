package com.sekhgmainuddin.coffeeapp.features.coffeeOrBeanDetails.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sekhgmainuddin.coffeeapp.R
import com.sekhgmainuddin.coffeeapp.core.common.AppTextM10
import com.sekhgmainuddin.coffeeapp.core.common.AppTextM12
import com.sekhgmainuddin.coffeeapp.core.common.AppTextR12
import com.sekhgmainuddin.coffeeapp.core.common.AppTextS14
import com.sekhgmainuddin.coffeeapp.core.common.AppTextS16
import com.sekhgmainuddin.coffeeapp.core.common.AppTextS20
import com.sekhgmainuddin.coffeeapp.core.common.AppTextStyles
import com.sekhgmainuddin.coffeeapp.core.common.composables.AppIconButton
import com.sekhgmainuddin.coffeeapp.core.common.composables.PriceComposable
import com.sekhgmainuddin.coffeeapp.core.theme.AppColors
import com.sekhgmainuddin.coffeeapp.features.coffeeOrBeanDetails.composables.CoffeeBeanCharacteristics
import com.sekhgmainuddin.coffeeapp.features.coffeeOrBeanDetails.composables.SizeSelectButton

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun CoffeeOrBeanDetailsScreen(modifier: Modifier = Modifier) {

    var isSmallSelected by remember {
        mutableStateOf(false)
    }
    var isMediumSelected by remember {
        mutableStateOf(false)
    }
    var isLargeSelected by remember {
        mutableStateOf(false)
    }

    val annotatedString = buildAnnotatedString {
        appendInlineContent(id = "startIcon")
        append("  4.5  ")
        withStyle(
            AppTextStyles.R10.copy(
                color = AppColors.ThemedLightGrey,
            ).toSpanStyle(),
        ) {
            append("(6,879)")
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

    Scaffold(
        containerColor = AppColors.ThemedBlack,
        topBar = {
            TopAppBar(
                modifier = modifier.padding(end = 10.dp),
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent,
                ),
                title = {
                    AppIconButton(
                        iconId = R.drawable.back_icon,
                        contentDescriptionId = R.string.back_icon,
                        onClick = { /* TODO: Navigate back */ },
                    )
                },
                actions = {
                    AppIconButton(
                        iconId = R.drawable.favourites_icon,
                        tint = AppColors.PrimaryThemedColor,
                        contentDescriptionId = R.string.favourites_icon,
                        onClick = { /* TODO: Open menu */ },
                    )
                }
            )
        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 20.dp,
                        vertical = 25.dp
                    ),
                horizontalArrangement = Arrangement.spacedBy(50.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AppTextM12(
                        text = "Price",
                        color = AppColors.ThemedLightGrey
                    )
                    PriceComposable(
                        price = "10.50",
                        textStyle = AppTextStyles.S20,
                    )
                }
                ElevatedButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.weight(1f).height(60.dp),
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.elevatedButtonColors(
                        containerColor = AppColors.SecondaryThemedColor,
                    ),
                ) {
                    AppTextS16(
                        text = "Add to Cart"
                    )
                }
            }
        }
    ) {
        it
        Column(
            modifier = modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
        ) {
            Box {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(500.dp),
                    painter = painterResource(id = R.drawable.cappuchino),
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
                                text = "Robusta Beans",
                            )
                            AppTextR12(
                                text = "From Africa",
                                color = AppColors.ThemedLightGrey,
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        CoffeeBeanCharacteristics(
                            modifier = Modifier.padding(end = 15.dp),
                            iconId = R.drawable.bean,
                            text = "Bean"
                        )
                        CoffeeBeanCharacteristics(
                            iconId = R.drawable.location_icon,
                            text = "Africa"
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
                        ElevatedButton(
                            onClick = { /*TODO*/ },
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.elevatedButtonColors(
                                containerColor = AppColors.ThemedMidBlack,
                            ),
                        ) {
                            AppTextM10(
                                text = "Medium Roasted",
                                color = AppColors.ThemedLightGrey,
                            )
                        }
                    }
                }
            }
            Column(
                modifier = modifier.padding(
                    20.dp,
                ),
            ) {
                AppTextS14(
                    text = "Description",
                    color = AppColors.ThemedLightGrey
                )
                AppTextR12(
                    modifier = Modifier.padding(vertical = 15.dp),
                    text = "Arabica beans are by far the most popular type of coffee beans, making up about 60% of the world’s coffee. These tasty beans originated many centuries ago in the highlands of Ethiopia, and may even be the first coffee beans ever consumed!",
                )
                AppTextS14(
                    text = "Size",
                    color = AppColors.ThemedLightGrey
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(22.dp)
                ) {
                    SizeSelectButton(
                        modifier = Modifier.weight(1f),
                        text = "250gm",
                        isSelected = isSmallSelected
                    )
                    SizeSelectButton(
                        modifier = Modifier.weight(1f),
                        text = "500gm",
                        isSelected = isMediumSelected
                    )
                    SizeSelectButton(
                        modifier = Modifier.weight(1f),
                        text = "1000gm",
                        isSelected = isLargeSelected
                    )
                }
            }
        }
    }
}