package com.example.tugasilfrontend.pages

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tugasilfrontend.ui.theme.fontprimary
import com.example.tugasilfrontend.ui.theme.grey
import com.example.tugasilfrontend.ui.theme.interBold
import com.example.tugasilfrontend.ui.theme.interRegular

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailGrid(
    itemIndex: Int?,
    photos3: Array<Int>,
    titleanime3: Array<String>,
    description3: Array<String>,
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Detail Screen",
                        fontSize = 18.sp,
                        color = fontprimary,
                        fontFamily = interBold
                    )
                },
                backgroundColor = grey,
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.Filled.KeyboardArrowLeft, contentDescription = null)
                    }
                }
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier.fillMaxHeight()
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(295.dp),
                    painter = painterResource(id = photos3[itemIndex!!]),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.height(10.dp))
                Column(
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                    Text(
                        text = titleanime3[itemIndex],
                        fontSize = 24.sp,
                        color = fontprimary,
                        fontFamily = interBold
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = description3[itemIndex],
                        fontSize = 18.sp,
                        color = fontprimary,
                        fontFamily = interRegular
                    )
                }
            }
        }
    }
}