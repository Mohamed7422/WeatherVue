package com.example.weathervue.data.model.entities

import com.example.weathervue.data.model.Current
import com.example.weathervue.data.model.Daily
import com.example.weathervue.data.model.Hourly
import java.util.UUID

data class SingleFavouriteWeather(
    var id: String = UUID.randomUUID().toString(),
    val currentTime :String,
    val current: Current,
    val daily: List<Daily>,
    val hourly: List<Hourly>,
    val lat: Double,
    val lon: Double,
    val timezone: String,
    val timezone_offset: Int
)
