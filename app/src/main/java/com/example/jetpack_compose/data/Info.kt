package com.example.jetpack_compose.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Info(
    @Json(name = "count") val count: Int? = null,
    @Json(name = "pages") val pages: Int? = null,
    @Json(name = "next") val next: String? = null,
    @Json(name = "prev") val prev: String? = null
)
