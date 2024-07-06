package com.sekhgmainuddin.coffeeapp.features.payment.views

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.sekhgmainuddin.coffeeapp.R
import com.sekhgmainuddin.coffeeapp.core.common.composables.CustomTopAppBar
import com.sekhgmainuddin.coffeeapp.core.common.composables.PriceAndPayComposable
import com.sekhgmainuddin.coffeeapp.core.tempData.HistoryItem
import com.sekhgmainuddin.coffeeapp.core.tempData.OrderHistoryItem
import com.sekhgmainuddin.coffeeapp.core.tempData.TempData
import com.sekhgmainuddin.coffeeapp.core.theme.AppColors
import java.util.UUID

@Composable
fun PaymentScreen(navController: NavController, totalAmount: String) {
    val context = LocalContext.current
    var selectedPaymentOption by remember { mutableStateOf(SelectedPaymentOption.CreditCard) }
    val scrollState = rememberScrollState()
    Scaffold(
        containerColor = AppColors.ThemedBlack,
        topBar = {
            CustomTopAppBar(
                title = "Payment",
                onBackPressed = {
                    navController.popBackStack()
                }
            )
        },
        bottomBar = {
            PriceAndPayComposable(
                modifier = Modifier.navigationBarsPadding(),
                totalAmount = totalAmount,
                payButtonText = "Pay from $selectedPaymentOption",
            ) {
                TempData.orderHistory.add(
                    OrderHistoryItem(
                        UUID.randomUUID().toString(),
                        TempData.cartList.map {
                            HistoryItem(
                                it.id,
                                it.itemData,
                                it.price.map { p->
                                    Pair(p.quantityType, p.quantity)
                                },
                            )
                        }
                    )
                )
                TempData.cartList.clear()
                Toast.makeText(context, "Payment Successful", Toast.LENGTH_SHORT).show()
                navController.popBackStack()
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .padding(paddingValues = paddingValues)
        ) {
            CreditCardComposable(
                isSelected = selectedPaymentOption == SelectedPaymentOption.CreditCard,
                onClick = {
                    selectedPaymentOption = SelectedPaymentOption.CreditCard
                }
            )
            PaymentOptionButton(
                iconId = R.drawable.wallet_icon,
                text = "Wallet",
                isSelected = selectedPaymentOption == SelectedPaymentOption.Wallet,
                onClick = {
                    selectedPaymentOption = SelectedPaymentOption.Wallet
                }
            )
            PaymentOptionButton(
                iconId = R.drawable.google_pay,
                text = "Google Pay",
                isSelected = selectedPaymentOption == SelectedPaymentOption.GooglePay,
                onClick = {
                    selectedPaymentOption = SelectedPaymentOption.GooglePay
                }
            )
            PaymentOptionButton(
                iconId = R.drawable.apple_pay,
                text = "Apple Pay",
                isSelected = selectedPaymentOption == SelectedPaymentOption.ApplePay,
                onClick = {
                    selectedPaymentOption = SelectedPaymentOption.ApplePay
                }
            )
            PaymentOptionButton(
                iconId = R.drawable.amazon_pay,
                text = "Amazon Pay",
                isSelected = selectedPaymentOption == SelectedPaymentOption.AmazonPay,
                onClick = {
                    selectedPaymentOption = SelectedPaymentOption.AmazonPay
                }
            )
        }
    }
}

enum class SelectedPaymentOption {
    CreditCard,
    Wallet,
    GooglePay,
    ApplePay,
    AmazonPay;

    override fun toString(): String {
        return when (this) {
            CreditCard -> "Credit Card"
            Wallet -> "Wallet"
            GooglePay -> "Google Pay"
            ApplePay -> "Apple Pay"
            AmazonPay -> "Amazon Pay"
        }
    }
}