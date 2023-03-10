package com.abhilash.myappread.navigation

enum class ReaderScreen {
    SplashScreen,
    LoginScreen,
    CreateAccountScreen,
    ReaderHomeScreen,
    SearchScreen,
    DetailScreen,
    UpdateScreen,
    ReaderStatScreen;
    companion object {
        fun fromRoute(route:String?):ReaderScreen
        =when(route?.substringBefore("/")){
            SplashScreen.name -> SplashScreen
            LoginScreen.name -> LoginScreen
            CreateAccountScreen.name -> CreateAccountScreen
            ReaderHomeScreen.name -> ReaderHomeScreen
            SearchScreen.name -> SearchScreen
            DetailScreen.name -> DetailScreen
            UpdateScreen.name -> UpdateScreen
            ReaderStatScreen.name -> ReaderStatScreen
            null -> ReaderHomeScreen
            else -> throw IllegalArgumentException("Route $route not recognised")

        }
    }



}