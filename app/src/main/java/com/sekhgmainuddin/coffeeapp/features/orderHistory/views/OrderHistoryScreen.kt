package com.sekhgmainuddin.coffeeapp.features.orderHistory.views

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sekhgmainuddin.coffeeapp.core.common.composables.PrimaryButton
import com.sekhgmainuddin.coffeeapp.core.tempData.TempData
import com.sekhgmainuddin.coffeeapp.features.cart.views.isScrollingUp

@Preview
@Composable
fun OrderHistoryScreen(modifier: Modifier = Modifier) {
    val scrollState = rememberLazyListState()
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 40.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            state = scrollState
        ) {
            items(TempData.orderHistory.size) {
                OrderHistoryItem()
            }
        }
        AnimatedVisibility(visible = scrollState.isScrollingUp().value, modifier = Modifier.align(Alignment.BottomCenter)) {
            PrimaryButton(
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp, bottom = 10.dp)
                    .fillMaxWidth(),
                text = "Download"
            )
        }
    }
}