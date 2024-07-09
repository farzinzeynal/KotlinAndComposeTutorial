package com.farzin.kotlinandcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavHostController
import com.farzin.kotlinandcomposetutorial.ui.app_bar_and_search_widget.viewmodel.MainViewModel
import com.farzin.kotlinandcomposetutorial.ui.bottom_sheet_dialog.MyBottomSheet
import com.farzin.kotlinandcomposetutorial.ui.theme.KotlinAndComposeTutorialTheme

class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController
    private val mainViewModel: MainViewModel by viewModels()

    @ExperimentalMaterial3Api
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinAndComposeTutorialTheme {
                MyBottomSheet()
            }
        }
    }
}
