package com.example.jetpack_compose.ui.screen
//
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import com.example.jetpack_compose.presentation.ActivityViewModel
import com.example.jetpack_compose.presentation.BackButtonHandler
import com.example.jetpack_compose.ui.layout.ListLocationView
import com.example.jetpack_compose.ui.theme.MyTheme

@Composable
fun ScreenLocation(viewModel: ActivityViewModel) {

    val dataToView by lazy { viewModel.locationPager}
    MyTheme { ListLocationView(dataToView) }

    DisposableEffect(key1 = viewModel){
        viewModel.onStart()
        onDispose { viewModel.onStop() }
    }
    BackButtonHandler { AppState.currentScreen = CurrentScreen.SCREEN2 }
}