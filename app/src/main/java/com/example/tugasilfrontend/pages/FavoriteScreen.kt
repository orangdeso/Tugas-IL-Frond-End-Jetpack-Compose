package com.example.tugasilfrontend.pages

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tugasilfrontend.navigation.NavigationScreen
import com.example.tugasilfrontend.ui.theme.fontprimary
import com.example.tugasilfrontend.ui.theme.grey
import com.example.tugasilfrontend.ui.theme.interBold
import com.example.tugasilfrontend.ui.theme.interMedium

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun FavoriteScreen(
    imageId2: Array<Int>,
    titleDrakor: Array<String>,
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "My Favorite",
                        fontSize = 20.sp,
                        color = fontprimary,
                        fontFamily = interBold
                    )
                },
                backgroundColor = grey
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(bottom = 32.dp),
        ) {
            LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = Modifier.padding(16.dp)) {
                val itemCount = imageId2.size
                items(itemCount) {
                    GridItem(itemIndex3 = it, photosAnime = imageId2, titleAnime = titleDrakor, navController)
                }
            }
            PaddingValues(bottom = 20.dp, top = 20.dp)
//            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun GridItem(itemIndex3: Int, photosAnime: Array<Int>, titleAnime: Array<String>, navController: NavController) {
    Spacer(modifier = Modifier.width(10.dp))
    Column(
        modifier = Modifier.padding(8.dp).clickable { navController.navigate("${NavigationScreen.DetailRow.name}/$itemIndex3") },
        horizontalAlignment = Alignment.Start
    ) {
        Image(
            painter = painterResource(id = photosAnime[itemIndex3]),
            modifier = Modifier.size(200.dp),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = titleAnime[itemIndex3],
            fontSize = 16.sp,
            color = fontprimary,
            fontFamily = interMedium,
            textAlign = TextAlign.Left
        )
        Spacer(modifier = Modifier.height(16.dp))
    }
}


