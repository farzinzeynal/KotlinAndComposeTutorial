package com.farzin.kotlinandcomposetutorial.ui.navigation.srceens

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.farzin.kotlinandcomposetutorial.ui.utils.ArgumentKeyNames


@Composable
fun DetailScreen(
    navController: NavController,
    id: Int? = null
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Toast.makeText(LocalContext.current, "$id", Toast.LENGTH_SHORT).show()
        Text(
            modifier = Modifier.clickable {
                navController.popBackStack()
            },
            text = "Detail",
            color = Color.Red,
            fontSize = MaterialTheme.typography.headlineLarge.fontSize,
            fontWeight = FontWeight.Bold
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    DetailScreen(
        navController = rememberNavController(),
    )
}