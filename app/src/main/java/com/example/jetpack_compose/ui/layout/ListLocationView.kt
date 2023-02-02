package com.example.jetpack_compose.ui.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.example.jetpack_compose.data.LocationAPI
import kotlinx.coroutines.flow.Flow


@Composable
fun ListLocationView(dataPager: Flow<PagingData<LocationAPI>>) {

    val dataItems = dataPager.collectAsLazyPagingItems()
    LazyColumn {
        items(dataItems) {
            it?.let { ItemListLocationView(it) } ?: Text(text = "Ooops")
        }
        dataItems.apply {
            when {
                loadState.refresh is LoadState.Loading -> {
                    item {
                        Box(
                            modifier = Modifier.fillParentMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator()
                        }
                    }
                }
                loadState.append is LoadState.Error -> {
                    val e = dataItems.loadState.append as LoadState.Error
                    item {
                        Column(
                            modifier = Modifier.fillParentMaxSize(),
                            verticalArrangement = Arrangement.Center
                        ) {
                            e.error.localizedMessage?.let { Text(text = it) }
                            Button(onClick = { retry() }) { Text(text = "Retry") }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ItemListLocationView(location: LocationAPI){

    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
            .background(Color.Gray)
    ) {
        Text(text = "Name: " + location.name.toString(), fontWeight = FontWeight.Bold, fontSize = 14.sp)
        Text(text = "Type: " + location.type.toString(), fontWeight = FontWeight.Bold, fontSize = 14.sp)
        Text(text = "Dimension: " + location.dimension.toString(), fontWeight = FontWeight.Bold, fontSize = 14.sp)
        Text(text = "Created: " + location.created.toString(), fontWeight = FontWeight.Bold, fontSize = 14.sp)
    }
}