package com.farzin.kotlinandcomposetutorial.ui.navigation.srceens


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.farzin.kotlinandcomposetutorial.ui.navigation.util.Screen

@Composable
fun HomeScreen(
    navController: NavController
) {
    Box(
      modifier = Modifier.fillMaxSize(),
      contentAlignment = Alignment.Center
    ){
        Text(
            modifier = Modifier.clickable {
                navController.navigate(route = Screen.Detail.passId(1))
            },
            text = "Home",
            color = MaterialTheme.colorScheme.primary,
            fontSize = MaterialTheme.typography.headlineLarge.fontSize,
            fontWeight = FontWeight.Bold
        )
    }

}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}