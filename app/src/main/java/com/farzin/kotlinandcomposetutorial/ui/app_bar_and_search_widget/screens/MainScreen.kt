package com.farzin.kotlinandcomposetutorial.ui.app_bar_and_search_widget.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.ContentAlpha
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.farzin.kotlinandcomposetutorial.ui.app_bar_and_search_widget.util.SearchWidgetState
import com.farzin.kotlinandcomposetutorial.ui.app_bar_and_search_widget.viewmodel.MainViewModel
import com.farzin.kotlinandcomposetutorial.ui.theme.KotlinAndComposeTutorialTheme


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(mainViewModel: MainViewModel) {

    val searchWidgetState by mainViewModel.searchWidgetState
    val searchTextState by mainViewModel.seacrhTextState


    Scaffold(
        topBar = {
            MainAppBar(
                searchWidgetState = searchWidgetState,
                searchTextState = searchTextState,
                onTextChange = {
                    mainViewModel.updateSeacrhTextState(it)
                },
                onCloseClicked = {
                    mainViewModel.updateSeacrhTextState(newValue = "")
                    mainViewModel.updateSeacrhWidgetState(newValue = SearchWidgetState.CLOSED)
                },
                onsearchClicked = {
                    Log.i("SearchText", it)
                },
                onSearchTriggered = {
                    mainViewModel.updateSeacrhWidgetState(newValue = SearchWidgetState.OPPPENED)
                }
            )
        }
    ) {

    }
}


@Composable
fun MainAppBar(
    searchWidgetState: SearchWidgetState,
    searchTextState: String,
    onTextChange: (String) -> Unit,
    onCloseClicked: () -> Unit,
    onsearchClicked: (String) -> Unit,
    onSearchTriggered: () -> Unit
) {
    when(searchWidgetState){
        SearchWidgetState.CLOSED -> {
            DefaultAppBar (
                onsearchClicked = onSearchTriggered
            )
        }
        SearchWidgetState.OPPPENED -> {
            SearchAppBar(
                text = searchTextState,
                onTextChange = onTextChange,
                onCloseClicked = onCloseClicked,
                onSearchClicked = onsearchClicked
            )
        }
    }
    
    
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultAppBar(onsearchClicked: () -> Unit) {
    TopAppBar(
        title = {
            Text(text = "Home")
        },
        actions = {
            IconButton(onClick = { onsearchClicked() }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription ="Search Icon")
            }
        }
    )
}


@Composable
fun SearchAppBar(
    text: String,
    onTextChange: (String) -> Unit,
    onCloseClicked: () -> Unit,
    onSearchClicked: (String) -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        shadowElevation = AppBarDefaults.TopAppBarElevation,
        color = MaterialTheme.colorScheme.primary
    ) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = text,
            onValueChange = {
                onTextChange(it)
            },
            placeholder = {
                Text(
                    modifier = Modifier
                        .alpha(ContentAlpha.medium),
                    text = "Search here..."
                )
            },
            textStyle = TextStyle(
                fontSize = MaterialTheme.typography.titleMedium.fontSize
            ),
            singleLine = true,
            leadingIcon = {
                IconButton(
                    modifier = Modifier.alpha(ContentAlpha.medium),
                    onClick = {}
                ) {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon")
                }
            },
            trailingIcon = {
                IconButton(
                    modifier = Modifier.alpha(ContentAlpha.medium),
                    onClick = {
                        if (text.isNotEmpty()){
                            onTextChange("")
                        }
                        else{
                            onCloseClicked()
                        }
                    }
                ) {
                    Icon(imageVector = Icons.Default.Close, contentDescription = "Close Icon")
                }
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    onSearchClicked(text)
                }
            ),
            colors = TextFieldDefaults.textFieldColors(
               backgroundColor = Color.Transparent,
               cursorColor = Color.White.copy(alpha = ContentAlpha.medium)
            )
        )
    }
}


@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    KotlinAndComposeTutorialTheme {
        DefaultAppBar {

        }
    }

}