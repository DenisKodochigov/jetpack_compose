package com.example.jetpack_compose.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import com.example.jetpack_compose.presentation.ActivityViewModel
import com.example.jetpack_compose.presentation.BackButtonHandler
import com.example.jetpack_compose.ui.layout.CharacterView
import com.example.jetpack_compose.ui.theme.MyTheme

@Composable
fun ScreenItemListCharacter(viewModel: ActivityViewModel) {

    MyTheme { CharacterView(AppState.value) }

    DisposableEffect(key1 = viewModel){
        viewModel.onStart()
        onDispose { viewModel.onStop() }
    }
    BackButtonHandler { AppState.currentScreen = CurrentScreen.SCREEN1 }
}