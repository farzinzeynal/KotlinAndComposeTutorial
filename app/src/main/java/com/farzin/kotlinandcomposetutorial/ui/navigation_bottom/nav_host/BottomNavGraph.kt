package com.farzin.kotlinandcomposetutorial.ui.navigation_bottom.nav_host

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.farzin.kotlinandcomposetutorial.ui.navigation_bottom.srceens.HomeScreen
import com.farzin.kotlinandcomposetutorial.ui.navigation_bottom.srceens.ProfileScreen
import com.farzin.kotlinandcomposetutorial.ui.navigation_bottom.srceens.SettingsScreen
import com.farzin.kotlinandcomposetutorial.ui.navigation_bottom.util.BottomBarScreen

@Composable
fun BottomNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route){
            HomeScreen(navController = navHostController)
        }

        composable(route = BottomBarScreen.Profile.route){
            ProfileScreen(navController = navHostController)
        }

        composable(route = BottomBarScreen.Settings.route){
            SettingsScreen(navController = navHostController)
        }


    }
}