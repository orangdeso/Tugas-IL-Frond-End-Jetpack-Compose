package com.example.tugasilfrontend.navigation

enum class NavigationScreen {
    SplashScreen,
    BottomScreen,
    HomeScreen,
    DetailScreenColumn,
    DetailScreenRow,
    DetailScreenGrid,
    WishlistScreen;


    fun fromRoute(route: String): NavigationScreen =
        when (route.substringBefore("/")) {
            SplashScreen.name -> SplashScreen
            BottomScreen.name -> BottomScreen
            HomeScreen.name -> HomeScreen
            DetailScreenColumn.name -> DetailScreenColumn
            DetailScreenRow.name -> DetailScreenRow
            DetailScreenGrid.name -> DetailScreenGrid
            WishlistScreen.name -> WishlistScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
}