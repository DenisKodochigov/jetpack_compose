package com.example.jetpack_compose.ui.layout

import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpack_compose.data.DataAPI
import com.example.jetpack_compose.ui.screen.AppState
import com.example.jetpack_compose.ui.screen.CurrentScreen
import com.example.jetpack_compose.presentation.BackButtonHandler

@Composable
fun ItemListCharacterView(dataAPI: DataAPI) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(6.dp)
            .fillMaxWidth()
            .background(Color.Gray)
            .clickable(true, null, null, onClick = {
                AppState.currentScreen = CurrentScreen.SCREEN2
                AppState.value = dataAPI
            }),

    ){
        GlideImageWithPreview(imageModel = dataAPI.image, Modifier.size(60.dp))
        Column(modifier = Modifier.padding(start = 6.dp)) {
            Text(text = dataAPI.id.toString(), fontWeight = FontWeight.Bold, fontSize = 15.sp)
            Text(text = dataAPI.name!!,maxLines = 1,fontWeight = FontWeight.Bold, fontSize = 15.sp)
            Text(text = dataAPI.gender!!, maxLines = 2, fontSize = 12.sp, overflow = TextOverflow.Ellipsis)
        }
    }
}

@Preview
@Composable
fun ItemPreView() = ItemListCharacterView(
    dataAPI = DataAPI(
        image = null,
        name = "User name",
        gender = "test gender"
    )
)