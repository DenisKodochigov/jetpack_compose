package com.example.jetpack_compose.ui.layout

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpack_compose.data.DataAPI
import com.example.jetpack_compose.data.Location
import com.example.jetpack_compose.data.Origin
import com.example.jetpack_compose.ui.screen.AppState
import com.example.jetpack_compose.ui.screen.CurrentScreen

@Composable
fun CharacterView(dataAPI: DataAPI){
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .verticalScroll(ScrollState(1), true, null, false)
            .padding(6.dp)
            .background(Color.Gray)
    ) {
        GlideImageWithPreview(imageModel = dataAPI.image, Modifier.fillMaxWidth(), contentScale = ContentScale.FillWidth)
        Text(text = dataAPI.name.toString(), fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Text(text = "ID: " + dataAPI.id.toString(), fontSize = 10.sp)
        Text(text = "Live status: ", fontSize = 10.sp, modifier = Modifier.padding(top = 6.dp))
        Text(text = dataAPI.status.toString(), fontSize = 14.sp)
        Text(text = "Species and gender: ", fontSize = 10.sp, modifier = Modifier.padding(top = 6.dp))
        Text(text = dataAPI.species.toString() + "(" +dataAPI.gender.toString()+")",  fontSize = 12.sp)
        Text(text = "Lsat know location: ", fontSize = 10.sp, modifier = Modifier.padding(top = 6.dp))
        Text(text = dataAPI.location?.name.toString(), fontSize = 12.sp,
                modifier= Modifier.background(Color.White)
                    .clickable(true, null, null, onClick = {
            AppState.currentScreen = CurrentScreen.SCREEN3
        }))
        Text(text = "Origin: " + dataAPI.origin?.name.toString(), fontSize = 12.sp)
        Text(text = "Type: " + dataAPI.type.toString(), fontSize = 12.sp)
        Text(text = "Created: " + dataAPI.created.toString(), fontWeight = FontWeight.Bold, fontSize = 10.sp)
        Text(text = "Episode: ", fontWeight = FontWeight.Bold, fontSize = 14.sp)
        Text(text = dataAPI.episode[0], fontSize = 12.sp,)
    }
}


@Preview
@Composable
fun CharacterPreView() = CharacterView(
    dataAPI = DataAPI(
        image = "https://rickandmortyapi.com/api/character/avatar/3.jpeg",
        name = "User name",
        gender = "test gender",
        id = 1,
        created = "1970.01.01",
        status = "Status",
        species = "Species",
        type="TYpe",
        origin = Origin(name = "Name origin", url = "https://origin.com"),
        location = Location(name = "Name location", url = "https://location.com"),
        episode = listOf("episode1","episode2","episode3")
    )
)