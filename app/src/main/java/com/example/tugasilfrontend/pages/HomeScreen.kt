package com.example.tugasilfrontend.pages

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tugasilfrontend.navigation.NavigationScreen
import com.example.tugasilfrontend.ui.theme.fontprimary
import com.example.tugasilfrontend.ui.theme.grey
import com.example.tugasilfrontend.ui.theme.interBold
import com.example.tugasilfrontend.ui.theme.interRegular
import com.example.tugasilfrontend.ui.theme.interSemiBold

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    // Column Parameter
    imageId: Array<Int>, titleHome: Array<String>, genreHome: Array<String>,

    // Row Parameter
    titleHome2: Array<String>, genreHome2: Array<String>,

    navController: NavController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Drakor Movie",
                        fontSize = 20.sp,
                        color = fontprimary,
                        fontFamily = interBold
                    )
                },
                backgroundColor = grey
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp)
            ) {
                Text(
                    text = "Lazy Row",
                    fontSize = 26.sp,
                    color = fontprimary,
                    fontFamily = interSemiBold
                )
                Spacer(modifier = Modifier.height(16.dp))
                LazyRow(
                ) {
                    val itemCount = imageId.size
                    items(itemCount) {
                        RowListItem(
                            itemIndex2 = it,
                            title2 = titleHome2,
                            genre2 = genreHome2,
                            navController
                        )
                    }
                }

                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    text = "Lazy Column",
                    fontSize = 26.sp,
                    color = fontprimary,
                    fontFamily = interSemiBold
                )
                Spacer(modifier = Modifier.height(16.dp))
                LazyColumn(
                ) {
                    val itemCount = imageId.size
                    items(itemCount) {
                        ColumnListItem(
                            itemIndex = it,
                            title = titleHome,
                            genre = genreHome,
                            navController
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun ColumnListItem(
    itemIndex: Int, title: Array<String>, genre: Array<String>, navController: NavController
) {
    Column(
        modifier = Modifier.clickable {
            navController.navigate("${NavigationScreen.DetailColumn.name}/$itemIndex") }
            .padding(bottom = 10.dp)
    ) {

        //Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = title[itemIndex], fontSize = 16.sp, color = fontprimary, fontFamily = interBold
        )
        Text(
            text = genre[itemIndex],
            fontSize = 14.sp,
            color = fontprimary,
            fontFamily = interRegular
        )
    }
}

@Composable
fun RowListItem(
    itemIndex2: Int, title2: Array<String>, genre2: Array<String>, navController: NavController
) {
    //Spacer(modifier = Modifier.width(0.dp))
    Column(
        modifier = Modifier.clickable {
            navController.navigate("${NavigationScreen.DetailRow.name}/$itemIndex2") }
            .padding(end = 20.dp)
    ) {
        Text(
            text = title2[itemIndex2], fontSize = 16.sp, color = fontprimary, fontFamily = interBold
        )
        Text(
            text = genre2[itemIndex2],
            fontSize = 14.sp,
            color = fontprimary,
            fontFamily = interRegular
        )
    }
}