package com.example.jetpack_compose.data

import com.example.jetpack_compose.entity.Mydata
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MyDataDTO(
    @Json(name = "info") override val info:Info = Info(),
    @Json(name = "results") override val results: List<DataAPI> = listOf()
): Mydata
