package com.abhilash.myappread.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.abhilash.myappread.screen.ReaderSplashScreen
import com.abhilash.myappread.screen.home.Home
import com.abhilash.myappread.screen.login.ReaderLoginScreen

@Composable

fun ReaderNavigation (){
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = ReaderScreen.SplashScreen.name ){
        composable(ReaderScreen.SplashScreen.name){
          ReaderSplashScreen(navController=navController)
        }
        composable(ReaderScreen.LoginScreen.name){
            ReaderLoginScreen(navController)
        }
        composable(ReaderScreen.ReaderHomeScreen.name){
            Home(navController)
        }

    }
}