package com.farzin.kotlinandcomposetutorial.ui.custom_ui_component

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun CustomCircularIndicator() {
    var value by remember {
        mutableStateOf(0)
    }

    CircularIndicator(
        indicatorValue = value
    )

    TextField(
        value = value.toString(),
        onValueChange = {
            value = if (it.isNotEmpty()) it.toInt() else 0
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        )
    )
}