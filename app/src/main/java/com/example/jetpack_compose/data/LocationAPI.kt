package com.example.jetpack_compose.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LocationAPI(
    @Json(name = "id") val id: Int? = null,
    @Json(name = "name") val name: String? = null,
    @Json(name = "type") val type: String? = null,
    @Json(name = "dimension") val dimension: String? = null,
    @Json(name = "residents") val residents: List<String> = listOf(),
    @Json(name = "url") val url: String? = null,
    @Json(name = "created") val created: String? = null,
)

