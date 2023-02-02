package com.example.jetpack_compose.data

import com.example.jetpack_compose.entity.MyLocation
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LocationDTO(
    @Json(name = "info") override val info:Info = Info(),
    @Json(name = "results") override val results: List<LocationAPI> = listOf()
): MyLocation
