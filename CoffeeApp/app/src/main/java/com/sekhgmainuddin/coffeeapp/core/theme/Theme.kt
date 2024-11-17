package com.sekhgmainuddin.coffeeapp.core.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val defaultColorScheme = darkColorScheme(
    primary = AppColors.PrimaryThemedColor,
    secondary = AppColors.SecondaryThemedColor,
    tertiary = AppColors.ThemedBlack,
    background = AppColors.ThemedBlack,
)

@Composable
fun CoffeeAppTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = defaultColorScheme,
        typography = Typography,
        content = content,
    )
}