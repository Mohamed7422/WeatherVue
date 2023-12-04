package com.example.weathervue.data.model.entities

import java.util.UUID

data class AlertEntity(
    var id: String = UUID.randomUUID().toString(),
    val start: Long,
    val end: Long,
    val kind: String,
    val lon: Double,
    val lat: Double,
)
