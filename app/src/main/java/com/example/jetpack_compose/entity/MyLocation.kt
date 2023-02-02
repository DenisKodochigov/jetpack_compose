package com.example.jetpack_compose.entity

import com.example.jetpack_compose.data.Info
import com.example.jetpack_compose.data.LocationAPI

interface MyLocation {
    val info: Info
    val results: List<LocationAPI>
}