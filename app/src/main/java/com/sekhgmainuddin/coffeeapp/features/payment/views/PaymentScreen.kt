package com.sekhgmainuddin.coffeeapp.features.payment.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sekhgmainuddin.coffeeapp.R
import com.sekhgmainuddin.coffeeapp.core.common.composables.CustomTopAppBar
import com.sekhgmainuddin.coffeeapp.core.common.composables.PriceAndPayComposable
import com.sekhgmainuddin.coffeeapp.core.theme.AppColors

@Preview
@Composable
fun PaymentScreen(totalAmount: String = "4.20") {
    val scrollState = rememberScrollState()
    Scaffold(
        containerColor = AppColors.ThemedBlack,
        topBar = {
            CustomTopAppBar(
                title = "Payment",
            )
        },
        bottomBar = {
            PriceAndPayComposable(
                totalAmount = totalAmount,
                payButtonText = "Pay from Credit Card"
            ) {

            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .padding(paddingValues = paddingValues)
        ) {
            CreditCardComposable(
                onClick = {

                }
            )
            PaymentOptionButton(
                iconId = R.drawable.wallet_icon,
                text = "Wallet",
                onClick = {

                }
            )
            PaymentOptionButton(
                iconId = R.drawable.google_pay,
                text = "Google Pay",
                onClick = {

                }
            )
            PaymentOptionButton(
                iconId = R.drawable.apple_pay,
                text = "Apple Pay",
                onClick = {

                }
            )
            PaymentOptionButton(
                iconId = R.drawable.amazon_pay,
                text = "Amazon Pay",
                onClick = {

                }
            )
        }
    }
}