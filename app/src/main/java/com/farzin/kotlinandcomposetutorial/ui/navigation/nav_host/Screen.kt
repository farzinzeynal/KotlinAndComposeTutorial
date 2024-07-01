package com.farzin.kotlinandcomposetutorial.ui.navigation.nav_host

import com.farzin.kotlinandcomposetutorial.ui.utils.ArgumentKeyNames.DETAIL_ID_KEY

sealed class Screen(val route: String) {
    object Home: Screen("home_screen")
    object Detail: Screen("detail_screen/$DETAIL_ID_KEY"){
        fun passId(id: Int) : String{
            return "detail_screen/$id"
        }
    }
}