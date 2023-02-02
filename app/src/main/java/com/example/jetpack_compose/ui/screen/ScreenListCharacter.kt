package com.example.jetpack_compose.ui.screen

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalLifecycleOwner
import com.example.jetpack_compose.presentation.ActivityViewModel
import com.example.jetpack_compose.ui.layout.ListCharacterView
import com.example.jetpack_compose.ui.theme.MyTheme
import com.example.jetpack_compose.presentation.BackButtonHandler

@Composable
fun ScreenListCharacter(viewModel:ActivityViewModel) {
    val activity = (LocalLifecycleOwner.current as ComponentActivity)
    val dataToView by lazy { viewModel.dataPager}

    MyTheme { ListCharacterView(dataToView)}

    DisposableEffect(key1 = viewModel){
        viewModel.onStart()
        onDispose { viewModel.onStop() }
    }
    BackButtonHandler { activity.finish()}
}