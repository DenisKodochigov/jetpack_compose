package com.example.jetpack_compose.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.jetpack_compose.data.DataAPI

object AppState {
    var currentScreen by mutableStateOf(CurrentScreen.SCREEN1)
    var value = DataAPI()
}