package com.sekhgmainuddin.coffeeapp.core.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val defaultColorScheme = darkColorScheme(
    primary = PrimaryThemedColor,
    secondary = SecondaryThemedColor,
    tertiary = ThemedBlack,
    background = ThemedBlack,
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