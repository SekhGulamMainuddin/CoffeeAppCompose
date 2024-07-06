package com.sekhgmainuddin.coffeeapp.features.cart.views

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.sekhgmainuddin.coffeeapp.core.common.composables.PriceAndPayComposable
import com.sekhgmainuddin.coffeeapp.core.helpers.format
import com.sekhgmainuddin.coffeeapp.core.routes.Routes
import com.sekhgmainuddin.coffeeapp.core.tempData.TempData
import kotlin.random.Random

@Composable
fun CartScreen(modifier: Modifier = Modifier, navController: NavController) {
    var totalAmount = 0.0
    TempData.cartList.forEach {
        it.price.forEach { price ->
            totalAmount += price.price
        }
    }

    val scrollState = rememberLazyListState()
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(top = 20.dp, bottom = 100.dp, start = 20.dp, end = 20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            state = scrollState
        ) {
            items(TempData.cartList.size) {
                val cartItemData = TempData.cartList[it]
                if (cartItemData.price.size == 1) {
                    CartItemViewTypeSingle(
                        cartItemData = cartItemData,
                        index = it
                    )
                } else {
                    CartItemViewTypeMultiple(
                        cartItemData = cartItemData,
                        index = it
                    )
                }
            }
        }
        AnimatedVisibility(
            modifier = Modifier.align(Alignment.BottomCenter),
            visible = scrollState.isScrollingUp().value,
        ) {
            PriceAndPayComposable(totalAmount = totalAmount.format(2), payButtonText = "Pay") {
                navController.navigate("payment-screen/totalAmount=$totalAmount")
            }
        }
    }
}

@Composable
fun LazyListState.isScrollingUp(): State<Boolean> {
    return produceState(initialValue = true) {
        var lastIndex = 0
        var lastScroll = Int.MAX_VALUE
        snapshotFlow {
            firstVisibleItemIndex to firstVisibleItemScrollOffset
        }.collect { (currentIndex, currentScroll) ->
            if (currentIndex != lastIndex || currentScroll != lastScroll) {
                value = currentIndex < lastIndex ||
                        (currentIndex == lastIndex && currentScroll < lastScroll)
                lastIndex = currentIndex
                lastScroll = currentScroll
            }
        }
    }
}