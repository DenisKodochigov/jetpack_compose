package com.example.jetpack_compose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.jetpack_compose.presentation.ActivityViewModel
import com.example.jetpack_compose.presentation.BackPressApp
import com.example.jetpack_compose.ui.screen.AppState
import com.example.jetpack_compose.ui.screen.CurrentScreen


class MainActivity : AppCompatActivity() {

    private val viewModelMy by viewModels<ActivityViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return ActivityViewModel() as? T ?: throw IllegalStateException()
            }
        }
    }

    @SuppressLint("UnrememberedMutableState")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContent {
            AppState.currentScreen = CurrentScreen.SCREEN1
            val appState = remember { AppState }
            BackPressApp(viewModelMy)
        }
    }
}
