package com.farzin.kotlinandcomposetutorial.ui.lazy_column

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MyLazyColumn(){
    val sections = listOf("A", "B", "C", "D", "E", "F", "G")

    LazyColumn(
        contentPadding = PaddingValues(all = 12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ){
        sections.forEach { section->
            stickyHeader {
                Text(
                    text = "Section $section",
                    modifier = Modifier
                        .background(Color.LightGray)
                        .padding(12.dp),
                )
            }
            items(10){
                Text(
                    modifier = Modifier.padding(12.dp),
                    text = "Item $it from the setcion $section"
                )
            }
        }
    }
}