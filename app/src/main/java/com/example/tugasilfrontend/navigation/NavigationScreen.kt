package com.example.tugasilfrontend.navigation

enum class NavigationScreen {
    SplashScreen,
    NavbarScreen,
    HomeScreen,
    DetailColumn,
    DetailRow,
    DetailGrid,
    FavoriteScreen;


    fun fromRoute(route: String): NavigationScreen =
        when (route.substringBefore("/")) {
            SplashScreen.name -> SplashScreen
            NavbarScreen.name -> NavbarScreen
            HomeScreen.name -> HomeScreen
            DetailColumn.name -> DetailColumn
            DetailRow.name -> DetailRow
            DetailGrid.name -> DetailGrid
            FavoriteScreen.name -> FavoriteScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
}