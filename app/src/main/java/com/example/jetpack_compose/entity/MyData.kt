package com.example.jetpack_compose.entity

import com.example.jetpack_compose.data.Info
import com.example.jetpack_compose.data.DataAPI

interface Mydata {
    val info: Info
    val results: List<DataAPI>
}