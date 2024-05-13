package com.example.tugasilfrontend.pages

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tugasilfrontend.R
import com.example.tugasilfrontend.ui.theme.fontprimary
import com.example.tugasilfrontend.ui.theme.grey
import com.example.tugasilfrontend.ui.theme.interBold
import com.example.tugasilfrontend.ui.theme.interRegular
import com.example.tugasilfrontend.ui.theme.interSemiBold

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AccountScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "My Profil",
                            fontSize = 20.sp,
                            color = fontprimary,
                            fontFamily = interBold
                        )
                    },
                    backgroundColor = grey

                )
            }
        )
        {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.Top,
            ) {
                Spacer(modifier = Modifier.height(150.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Image(
                        modifier = Modifier
                            .size(200.dp)
                            .clip(CircleShape),

                        painter = painterResource(id = R.drawable.my_profil),
                        contentDescription = null,
                        alignment = Alignment.Center,
                        contentScale = ContentScale.Crop
                    )
                }
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = "Nama",
                    fontSize = 20.sp,
                    color = fontprimary,
                    fontFamily = interSemiBold
                )
                Text(
                    text = "Ahmad Choirul Umam ALi Rozaqi",
                    fontSize = 18.sp,
                    color = fontprimary,
                    fontFamily = interRegular
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Email",
                    fontSize = 20.sp,
                    color = fontprimary,
                    fontFamily = interSemiBold
                )
                Text(
                    text = "ahmadzaqi98mmm@gmail.com",
                    fontSize = 18.sp,
                    color = fontprimary,
                    fontFamily = interRegular
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Perguruan Tinggi",
                    fontSize = 20.sp,
                    color = fontprimary,
                    fontFamily = interSemiBold
                )
                Text(
                    text = "Politeknik Negeri Jember",
                    fontSize = 18.sp,
                    color = fontprimary,
                    fontFamily = interRegular
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Jurusan",
                    fontSize = 20.sp,
                    color = fontprimary,
                    fontFamily = interSemiBold
                )
                Text(
                    text = "Teknologi informasi",
                    fontSize = 18.sp,
                    color = fontprimary,
                    fontFamily = interRegular
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Prodi",
                    fontSize = 20.sp,
                    color = fontprimary,
                    fontFamily = interSemiBold
                )
                Text(
                    text = "Teknik Informatika",
                    fontSize = 18.sp,
                    color = fontprimary,
                    fontFamily = interRegular
                )
            }
        }
    }
}

@Preview
@Composable
fun Preview69() {
    AccountScreen(navController = rememberNavController())
}