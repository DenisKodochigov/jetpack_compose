package com.example.jetpack_compose.data

import androidx.paging.PagingSource
import androidx.paging.PagingState

class DataSource: PagingSource<Int, DataAPI>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, DataAPI> {
        return try {
            val nextPage = params.key ?: 1
            val dataResponse = RetrofitAPI.getDataFormApiPaging(nextPage)

            LoadResult.Page(
                data = dataResponse.results,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = if (dataResponse.results.isEmpty()) null else nextPage + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
    override fun getRefreshKey(state: PagingState<Int, DataAPI>) = 1
}