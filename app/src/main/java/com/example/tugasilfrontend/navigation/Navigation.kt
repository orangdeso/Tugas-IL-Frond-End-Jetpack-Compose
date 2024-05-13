package com.example.tugasilfrontend.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tugasilfrontend.datamodel.description
import com.example.tugasilfrontend.datamodel.gambar
import com.example.tugasilfrontend.datamodel.genre
import com.example.tugasilfrontend.datamodel.title
import com.example.tugasilfrontend.pages.NavbarScreen
import com.example.tugasilfrontend.pages.DetailColumn
import com.example.tugasilfrontend.pages.DetailRow
import com.example.tugasilfrontend.pages.HomeScreen
import com.example.tugasilfrontend.pages.SplashScreen
import com.example.tugasilfrontend.pages.FavoriteScreen


@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavigationScreen.SplashScreen.name
    )
    {
        composable(NavigationScreen.SplashScreen.name) {
            SplashScreen(navController = navController)
        }
        composable(NavigationScreen.NavbarScreen.name) {
            NavbarScreen()
        }
        composable(NavigationScreen.HomeScreen.name) {
            HomeScreen(
                imageId = gambar,
                titleHome = title,
                genreHome = genre,
                titleHome2 = title,
                genreHome2 = genre,
                navController
            )
        }
        composable(NavigationScreen.FavoriteScreen.name) {
            FavoriteScreen(imageId2 = gambar, titleDrakor = title, navController)
        }
        composable("${NavigationScreen.DetailColumn.name}/{index}", arguments = listOf(
            navArgument(name = "index") {
                type = NavType.IntType
            }
        )) { index ->
            DetailColumn(
                itemIndex = index.arguments?.getInt("index"),
                photos = gambar,
                titleanime = title,
                description = description,
                navController = navController
            )
        }
        composable("${NavigationScreen.DetailRow.name}/{index2}", arguments = listOf(
            navArgument(name = "index2") {
                type = NavType.IntType
            }
        )) { index ->
            DetailRow(
                itemIndex = index.arguments?.getInt("index2"),
                photos2 = gambar,
                titleanime2 = title,
                description2 = description,
                navController
            )
        }
    }
}