package com.example.jetpack_compose.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Origin(
    @Json(name = "name") val name: String? = null,
    @Json(name = "url") val url: String? = null,
)
