package com.sekhgmainuddin.coffeeapp.features.orderHistory.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sekhgmainuddin.coffeeapp.core.common.composables.PrimaryButton

@Preview
@Composable
fun OrderHistoryScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            items(20) {
                OrderHistoryItem()
            }
        }
        PrimaryButton(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp, bottom = 20.dp)
                .fillMaxWidth(),
            text = "Download"
        )
    }
}