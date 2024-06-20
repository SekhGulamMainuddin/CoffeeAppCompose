package com.sekhgmainuddin.coffeeapp.features.cart.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sekhgmainuddin.coffeeapp.core.common.composables.PriceAndPayComposable
import kotlin.random.Random

@Preview
@Composable
fun CardScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            items(20) {
                if(Random.nextBoolean()) {
                    CartItemViewTypeMultiple()
                } else {
                    CartItemViewTypeSingle()
                }
            }
        }
        PriceAndPayComposable(totalAmount = "10.40", payButtonText = "Pay") {

        }
    }
}