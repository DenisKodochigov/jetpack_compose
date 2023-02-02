package com.example.jetpack_compose.ui.layout

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.example.jetpack_compose.data.DataAPI
import kotlinx.coroutines.flow.Flow

@SuppressLint("FlowOperatorInvokedInComposition")
@Composable
fun ListCharacterView(dataPager: Flow<PagingData<DataAPI>>) {

    val dataItems = dataPager.collectAsLazyPagingItems()
    LazyColumn {
        items(dataItems) {
            it?.let { ItemListCharacterView(dataAPI = it) } ?: Text(text = "Ooops")
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

