package com.farzin.kotlinandcomposetutorial.ui.coil_image

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.transform.BlurTransformation
import coil.transform.CircleCropTransformation
import coil.transform.GrayscaleTransformation
import coil.transform.RoundedCornersTransformation
import com.farzin.kotlinandcomposetutorial.R

@OptIn(ExperimentalCoilApi::class)
@ExperimentalMaterial3Api
@Composable
fun CoilImage(){
    Box (
        modifier = Modifier
            .height(150.dp)
            .width(150.dp),
        contentAlignment = Alignment.Center
    ){
        val painter = rememberImagePainter(
            data = "https://avatars.githubusercontent.com/u/14994036?v=4",
            builder = {
                placeholder(R.drawable.ic_launcher_background)
                crossfade(1000)
                transformations(
                    GrayscaleTransformation(),
                    CircleCropTransformation(),
                    RoundedCornersTransformation(50f),
                    BlurTransformation(LocalContext.current)
                )
                this.addHeader("Authorization", "Bearer token")
            }
        )

        val painterState = painter.state
        Image(painter = painter, contentDescription = "Logo image")
        if (painterState is ImagePainter.State.Loading){
            CircularProgressIndicator()
        }
    }
}