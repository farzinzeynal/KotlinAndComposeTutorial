package com.farzin.kotlinandcomposetutorial.ui.navigation.nav_host

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.farzin.kotlinandcomposetutorial.ui.navigation.srceens.DetailScreen
import com.farzin.kotlinandcomposetutorial.ui.navigation.srceens.HomeScreen
import com.farzin.kotlinandcomposetutorial.ui.utils.ArgumentKeyNames.DETAIL_ID_KEY

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ){
        composable(
            route = Screen.Home.route,
            arguments = listOf(
                navArgument(DETAIL_ID_KEY){
                    type = NavType.IntType
                }
            )
        ){
            HomeScreen(navController)
        }
        composable(
            route = Screen.Detail.route,
        ){

            DetailScreen(navController,it.arguments?.getInt(DETAIL_ID_KEY) )
        }
    }
}