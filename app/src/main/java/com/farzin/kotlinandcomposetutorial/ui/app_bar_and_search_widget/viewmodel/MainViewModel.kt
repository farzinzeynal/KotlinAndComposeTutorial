package com.farzin.kotlinandcomposetutorial.ui.app_bar_and_search_widget.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.farzin.kotlinandcomposetutorial.ui.app_bar_and_search_widget.util.SearchWidgetState

class MainViewModel : ViewModel() {

    private val _seacrhWidgetState: MutableState<SearchWidgetState> =
        mutableStateOf(value = SearchWidgetState.CLOSED)
    val searchWidgetState: State<SearchWidgetState> = _seacrhWidgetState

    private val _seacrhTextState: MutableState<String> =
        mutableStateOf(value = "")
    val seacrhTextState: State<String> = _seacrhTextState


    fun updateSeacrhWidgetState(newValue: SearchWidgetState) {
        _seacrhWidgetState.value = newValue
    }

    fun updateSeacrhTextState(newValue: String) {
        _seacrhTextState.value = newValue
    }
}