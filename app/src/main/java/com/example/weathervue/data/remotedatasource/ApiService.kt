package com.example.weathervue.data.remotedatasource

import com.example.weathervue.data.model.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    //https://api.openweathermap.org/data/3.0/onecall?exclude=minutely&appid=513823d1fb7d0530e1fba7239176e10d&units=metric&lat=33.44&lon=-94.04

    @GET("onecall?exclude=minutely&units=metric")
    suspend fun getWeather(
        @Query("appId") appKey:String,
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("long") lang: String
            ):Response<WeatherResponse>
}