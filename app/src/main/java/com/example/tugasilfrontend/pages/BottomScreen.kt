package com.example.tugasilfrontend.pages

import android.annotation.SuppressLint
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
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
import com.example.tugasilfrontend.datamodel.genre
import com.example.tugasilfrontend.datamodel.photos
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
    data object WishlistScreen :
        BottomNavigationScreen("Wishlist", Icons.Filled.Favorite, Icons.Outlined.Favorite)

    data object AccountScreen :
        BottomNavigationScreen("Account", Icons.Filled.AccountCircle, Icons.Outlined.AccountCircle)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottomScreen() {
    val navController = rememberNavController()
    val items = listOf(
        BottomNavigationScreen.HomeScreen,
        BottomNavigationScreen.WishlistScreen,
        BottomNavigationScreen.AccountScreen
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
                        imageId = photos,
                        titleHome = title,
                        genreHome = genre,
                        titleHome2 = title,
                        genreHome2 = genre,
                        navController
                    )
                }
                composable(BottomNavigationScreen.WishlistScreen.title) {
                    WishlistScreen(imageId2 = photos, titleAnimeWishlist = title, navController)
                }
                composable(BottomNavigationScreen.AccountScreen.title) {
                    AccountScreen(navController)
                }


                composable("${NavigationScreen.DetailScreenColumn.name}/{index}",
                    arguments = listOf(
                        navArgument(name = "index") {
                            type = NavType.IntType
                        }
                    )) { index ->
                    DetailScreenColumn(
                        itemIndex = index.arguments?.getInt("index"),
                        photos = photos,
                        titleanime = title,
                        description = description,
                        navController = navController
                    )
                }
                composable("${NavigationScreen.DetailScreenRow.name}/{index2}", arguments = listOf(
                    navArgument(name = "index2") {
                        type = NavType.IntType
                    }
                )) { index ->
                    DetailScreenRow(
                        itemIndex = index.arguments?.getInt("index2"),
                        photos2 = photos,
                        titleanime2 = title,
                        description2 = description,
                        navController
                    )
                }
                composable("${NavigationScreen.DetailScreenGrid.name}/{index3}", arguments = listOf(
                    navArgument(name = "index3") {
                        type = NavType.IntType
                    }
                )) { index ->
                    DetailScreenGrid(
                        itemIndex = index.arguments?.getInt("index3"),
                        photos3 = photos,
                        titleanime3 = title,
                        description3 = description,
                        navController
                    )
                }
            }
        }
    )
}