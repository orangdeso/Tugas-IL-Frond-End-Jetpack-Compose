package com.example.tugasilfrontend.pages

import android.annotation.SuppressLint
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tugasilfrontend.datamodel.description
import com.example.tugasilfrontend.datamodel.gambar
import com.example.tugasilfrontend.datamodel.genre
import com.example.tugasilfrontend.datamodel.title
import com.example.tugasilfrontend.navigation.NavigationScreen
import com.example.tugasilfrontend.ui.theme.grey
import com.example.tugasilfrontend.ui.theme.primary
import com.example.tugasilfrontend.ui.theme.primary2

sealed class BottomNavigationScreen(
    val title: String,
    val filledIcon: ImageVector,
    val outlinedIcon: ImageVector
) {
    data object HomeScreen : BottomNavigationScreen("Home", Icons.Filled.Home, Icons.Outlined.Home)
    data object FavoriteScreen :
        BottomNavigationScreen("Favorite", Icons.Filled.Favorite, Icons.Outlined.FavoriteBorder)

    data object ProfilScreen :
        BottomNavigationScreen("Profil", Icons.Filled.Person, Icons.Outlined.Person)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NavbarScreen() {
    val navController = rememberNavController()
    val items = listOf(
        BottomNavigationScreen.HomeScreen,
        BottomNavigationScreen.FavoriteScreen,
        BottomNavigationScreen.ProfilScreen
    )
    Scaffold(
        bottomBar = {
            BottomNavigation(
                backgroundColor = grey,
                elevation = 15.dp
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                items.forEach { screen ->
                    BottomNavigationItem(
                        selected = currentRoute == screen.title,
                        onClick = {
                            navController.navigate(screen.title) {
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                            }
                        },
                        icon = {
                            val selectedIcon =
                                if (currentRoute == screen.title) screen.filledIcon else screen.outlinedIcon
                            Icon(
                                selectedIcon, contentDescription = screen.title,
                                tint = if (currentRoute == screen.title) primary else primary2
                            )
                        },
                        label = {
                            Text(
                                text = screen.title,
                                color = if (currentRoute == screen.title)
                                    primary else primary2
                            )
                        },
                        alwaysShowLabel = false
                    )
                }
            }
        },
        content = {
            NavHost(
                navController = navController,
                startDestination = BottomNavigationScreen.HomeScreen.title
            ) {
                composable(BottomNavigationScreen.HomeScreen.title) {
                    HomeScreen(
                        imageId = gambar,
                        titleHome = title,
                        genreHome = genre,
                        titleHome2 = title,
                        genreHome2 = genre,
                        navController
                    )
                }
                composable(BottomNavigationScreen.FavoriteScreen.title) {
                    FavoriteScreen(imageId2 = gambar, titleDrakor = title, navController)
                }
                composable(BottomNavigationScreen.ProfilScreen.title) {
                    ProfilScreen(navController)
                }


                composable("${NavigationScreen.DetailColumn.name}/{index}",
                    arguments = listOf(
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
                composable("${NavigationScreen.DetailGrid.name}/{index3}", arguments = listOf(
                    navArgument(name = "index3") {
                        type = NavType.IntType
                    }
                )) { index ->
                    DetailGrid(
                        itemIndex = index.arguments?.getInt("index3"),
                        photos3 = gambar,
                        titleanime3 = title,
                        description3 = description,
                        navController
                    )
                }
            }
        }
    )
}