package com.farzin.kotlinandcomposetutorial.ui.navigation_bottom.srceens


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

import com.farzin.kotlinandcomposetutorial.ui.navigation_bottom.nav_host.BottomNavGraph
import com.farzin.kotlinandcomposetutorial.ui.navigation_bottom.util.BottomBarScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomBar(navContorller = navController) }
    ) {
        BottomNavGraph(navHostController = navController)
    }
}


@Composable
fun BottomBar(navContorller: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Profile,
        BottomBarScreen.Settings
    )
    val navBackStackEntry by navContorller.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation{
        screens.forEach {
            AddBottomItems(screen = it, currentDestination = currentDestination, navContorller = navContorller)
        }
    }
}


@Composable
fun RowScope.AddBottomItems(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navContorller: NavHostController
) {
    BottomNavigationItem(
        label = { Text(text = screen.title)} ,
        icon = { 
            Icon(imageVector = screen.icon, contentDescription = "Nav Icon")
        },
        selected = currentDestination?.hierarchy?.any{
            it.route == screen.route
        } == true,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navContorller.navigate(route = screen.route){
                popUpTo(navContorller.graph.findStartDestination().id)
                launchSingleTop = true
            }
        },
    )
}