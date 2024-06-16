package com.sekhgmainuddin.coffeeapp.features.coffeeOrBeanDetails.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sekhgmainuddin.coffeeapp.R
import com.sekhgmainuddin.coffeeapp.core.common.AppTextM10
import com.sekhgmainuddin.coffeeapp.core.common.AppTextM12
import com.sekhgmainuddin.coffeeapp.core.theme.AppColors

@Preview
@Composable
fun CoffeeBeanCharacteristics(
    modifier: Modifier = Modifier,
    iconId: Int = R.drawable.bean,
    text: String = "Bean",
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(AppColors.ThemedMidBlack)
            .size(56.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = "",
            tint = AppColors.SecondaryThemedColor,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        AppTextM10(
            text = text,
            color = AppColors.ThemedLightGrey,
        )
    }
}

@Preview
@Composable
fun SizeSelectButton(
    modifier: Modifier = Modifier,
    text: String = "250gm",
    isSelected: Boolean = false,
) {
    OutlinedButton(
        onClick = { /*TODO*/ },
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = AppColors.ThemedMidBlack,
        ),
        modifier = modifier,
        border = BorderStroke(
            width = if(isSelected) 2.dp else 0.dp,
            color = if(isSelected) AppColors.SecondaryThemedColor else Color.Transparent
        )
    ) {
        AppTextM12(
            text = text,
            color = if (isSelected) AppColors.SecondaryThemedColor else AppColors.ThemedLightGrey,
        )
    }
}