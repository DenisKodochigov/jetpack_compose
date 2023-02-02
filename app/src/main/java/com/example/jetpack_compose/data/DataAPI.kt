package com.example.jetpack_compose.data

import androidx.compose.runtime.Composable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DataAPI(
    @Json(name = "id") val id: Int? = null,
    @Json(name = "name") val name: String? = null,
    @Json(name = "status") val status: String? = null,
    @Json(name = "species") val species: String ? = null,
    @Json(name = "type") val type: String? = null,
    @Json(name = "gender") val gender: String? = null,
    @Json(name = "origin") val origin: Origin? = null,
    @Json(name = "location") val location: Location? = null,
    @Json(name = "image") val image: String? = null,
    @Json(name = "episode") val episode: List<String> = listOf(),
    @Json(name = "url") val url: String? = null,
    @Json(name = "created") val created: String? = null,
)

