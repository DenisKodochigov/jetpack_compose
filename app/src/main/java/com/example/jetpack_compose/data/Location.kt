package com.example.jetpack_compose.data

import androidx.compose.runtime.Composable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Location(
    @Json(name = "name") val name: String? = null,
    @Json(name = "url") val url: String? = null,
)

