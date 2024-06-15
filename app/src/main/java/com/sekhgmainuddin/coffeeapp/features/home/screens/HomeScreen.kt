package com.sekhgmainuddin.coffeeapp.features.home.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.sekhgmainuddin.coffeeapp.R
import com.sekhgmainuddin.coffeeapp.core.theme.ThemedGrey
import com.sekhgmainuddin.coffeeapp.core.theme.ThemedLightBlack
import com.sekhgmainuddin.coffeeapp.core.theme.ThemedLightGrey

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val query = remember { mutableStateOf("") }
    return Column(modifier = modifier) {
        Text(
            text = "Find the best coffee for you",
            modifier = modifier
                .fillMaxWidth(0.8f)
                .padding(horizontal = 30.dp, vertical = 15.dp),
        )
        SearchBar(
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
                .padding(horizontal = 30.dp)
                .clip(RoundedCornerShape(10.dp)),
            colors = SearchBarDefaults.colors(
                containerColor = ThemedLightBlack,
                dividerColor = ThemedLightGrey,
            ),
            placeholder = {
                Text(
                    text = stringResource(R.string.find_your_coffee),
                    color = ThemedGrey,
                    style = MaterialTheme.typography.labelSmall.copy(
                        color = ThemedGrey,
                    ),
                )
            },
            query = query.value,
            onQueryChange = {
                query.value = it
            },
            onSearch = {

            },
            active = true,
            onActiveChange = {

            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.search_icon),
                    contentDescription = stringResource(R.string.search_icon),
                    modifier = Modifier.size(20.dp),
                    tint = ThemedGrey
                )
            },
            trailingIcon = {
                if (query.value.isNotEmpty()) {
                    IconButton(
                        onClick = {
                            query.value = ""
                        },
                        modifier = Modifier.size(20.dp),
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.close_icon),
                            contentDescription = stringResource(R.string.close_icon),
                            modifier = Modifier.size(20.dp),
                            tint = ThemedGrey
                        )
                    }
                }
            }
        ) {

        }
    }
}