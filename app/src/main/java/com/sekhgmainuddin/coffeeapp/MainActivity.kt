package com.sekhgmainuddin.coffeeapp

import android.content.res.AssetManager
import android.content.res.loader.AssetsProvider
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.LocalMinimumInteractiveComponentEnforcement
import androidx.compose.material3.LocalMinimumTouchTargetEnforcement
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.sekhgmainuddin.coffeeapp.core.theme.CoffeeAppTheme
import com.sekhgmainuddin.coffeeapp.core.theme.ThemedBlack
import com.sekhgmainuddin.coffeeapp.core.theme.ThemedDarkGrey
import com.sekhgmainuddin.coffeeapp.core.theme.ThemedGrey
import com.sekhgmainuddin.coffeeapp.core.theme.ThemedLightBlack
import com.sekhgmainuddin.coffeeapp.core.theme.ThemedLightGrey
import com.sekhgmainuddin.coffeeapp.core.theme.ThemedWhite

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainComposable()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun MainComposable(modifier: Modifier = Modifier) {

    CoffeeAppTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = ThemedBlack,
                    ),
                    title = {
                        IconButton(
                            onClick = { /*TODO*/ },
                        ) {
                            Icon(
                                tint = ThemedWhite.copy(alpha = 0.18f),
                                painter = painterResource(id = R.drawable.menu_icon),
                                contentDescription = stringResource(R.string.menu_icon),
                                modifier = Modifier
                                    .size(35.dp)
                                    .background(
                                        brush = Brush.linearGradient(
                                            colors = listOf(
                                                ThemedDarkGrey.copy(alpha = 0.1f),
                                                ThemedDarkGrey
                                            ),
                                            start = Offset(100f, 100f),
                                            end = Offset(0f, 0f)
                                        ),
                                        shape = RoundedCornerShape(
                                            corner = CornerSize(10.dp),
                                        ),
                                    )
                                    .border(
                                        border = BorderStroke(
                                            color = ThemedDarkGrey,
                                            width = 1.dp,
                                        ),
                                        shape = RoundedCornerShape(corner = CornerSize(10.dp)),
                                    )
                                    .padding(10.dp),
                            )
                        }
                    },
                    actions = {
                        OutlinedIconButton(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .padding(end = 25.dp)
                                .size(35.dp),
                            shape = RoundedCornerShape(10.dp),
                            border = BorderStroke(
                                width = 1.dp,
                                color = ThemedDarkGrey,
                            ),
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.profile_icon),
                                contentDescription = stringResource(R.string.profile_image),
                                contentScale = ContentScale.Fit,
                            )
                        }
                    },
                )
            },
        ) {

        }
    }
}