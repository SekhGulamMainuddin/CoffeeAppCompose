package com.sekhgmainuddin.coffeeapp.core.common.composables

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sekhgmainuddin.coffeeapp.R
import com.sekhgmainuddin.coffeeapp.core.common.AppTextS20

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(
    modifier: Modifier = Modifier,
    actions: @Composable RowScope.() -> Unit = {},
    showBackButton: Boolean = true,
    title: String? = null,
    navigationItems: @Composable () -> Unit = {}
) {
    CenterAlignedTopAppBar(
        modifier = modifier.padding(horizontal = 10.dp),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent,
        ),
        navigationIcon = {
            if (showBackButton)
                AppIconButton(
                    iconId = R.drawable.back_icon,
                    contentDescriptionId = R.string.back_icon,
                    onClick = { /* TODO: Navigate back */ },
                )
            navigationItems()
        },
        title = {
            if (title != null)
                AppTextS20(
                    text = title,
                )
        },
        actions = actions
    )
}