package com.example.weathervue.ui.homecomponents

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.weathervue.R
import com.example.weathervue.data.model.Daily
import com.example.weathervue.data.model.FeelsLike
import com.example.weathervue.data.model.Hourly
import com.example.weathervue.data.model.Rain
import com.example.weathervue.data.model.Temp
import com.example.weathervue.data.model.Weather
import com.example.weathervue.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding

    lateinit var hourlyRV:RecyclerView
    lateinit var hourlyAdapter: HourStateRecyclerAdapter

    lateinit var dailyRV:RecyclerView
    lateinit var dailyAdapter: DailyRecyclerAdapter



    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(layoutInflater,R.layout.fragment_home,container,false)
        // Inflate the layout for this fragment
        hourlyRV = binding.hoursRV
        hourlyAdapter = HourStateRecyclerAdapter()

        dailyRV = binding.dailyRV
        dailyAdapter = DailyRecyclerAdapter()

        hourlyRV.adapter = hourlyAdapter
        dailyRV.adapter = dailyAdapter

        val hourlyList = listOf(
            Hourly(
                clouds = 10,
                dew_point = 15.0,
                dt = 1637658000,
                feels_like = 20.0,
                humidity = 70,
                pop = 0.2,
                pressure = 1015,
                rain = Rain(1.5),
                temp = 25.0,
                uvi = 8.0,
                visibility = 10000,
                weather = listOf(Weather("Clear sky", "01d", 800, "Clear")),
                wind_deg = 180,
                wind_gust = 30.0,
                wind_speed = 5.0
            ),
            Hourly(
                clouds = 15,
                dew_point = 18.0,
                dt = 1637661600,
                feels_like = 22.0,
                humidity = 75,
                pop = 0.1,
                pressure = 1014,
                rain = Rain(0.5),
                temp = 27.0,
                uvi = 7.5,
                visibility = 9500,
                weather = listOf(Weather("Scattered clouds", "02d", 801, "Clouds")),
                wind_deg = 200,
                wind_gust = 35.0,
                wind_speed = 6.0
            ),
            Hourly(
                clouds = 20,
                dew_point = 20.0,
                dt = 1637665200,
                feels_like = 24.0,
                humidity = 80,
                pop = 0.0,
                pressure = 1013,
                rain = null,
                temp = 29.0,
                uvi = 7.0,
                visibility = 9000,
                weather = listOf(Weather("Light rain", "10d", 500, "Rain")),
                wind_deg = 220,
                wind_gust = 40.0,
                wind_speed = 7.0
            ),Hourly(
                clouds = 10,
                dew_point = 15.0,
                dt = 1637658000,
                feels_like = 20.0,
                humidity = 70,
                pop = 0.2,
                pressure = 1015,
                rain = Rain(1.5),
                temp = 25.0,
                uvi = 8.0,
                visibility = 10000,
                weather = listOf(Weather("Clear sky", "01d", 800, "Clear")),
                wind_deg = 180,
                wind_gust = 30.0,
                wind_speed = 5.0
            ),Hourly(
                clouds = 10,
                dew_point = 15.0,
                dt = 1637658000,
                feels_like = 20.0,
                humidity = 70,
                pop = 0.2,
                pressure = 1015,
                rain = Rain(1.5),
                temp = 25.0,
                uvi = 8.0,
                visibility = 10000,
                weather = listOf(Weather("Clear sky", "01d", 800, "Clear")),
                wind_deg = 180,
                wind_gust = 30.0,
                wind_speed = 5.0
            ),Hourly(
                clouds = 10,
                dew_point = 15.0,
                dt = 1637658000,
                feels_like = 20.0,
                humidity = 70,
                pop = 0.2,
                pressure = 1015,
                rain = Rain(1.5),
                temp = 25.0,
                uvi = 8.0,
                visibility = 10000,
                weather = listOf(Weather("Clear sky", "01d", 800, "Clear")),
                wind_deg = 180,
                wind_gust = 30.0,
                wind_speed = 5.0
            ),Hourly(
                clouds = 10,
                dew_point = 15.0,
                dt = 1637658000,
                feels_like = 20.0,
                humidity = 70,
                pop = 0.2,
                pressure = 1015,
                rain = Rain(1.5),
                temp = 25.0,
                uvi = 8.0,
                visibility = 10000,
                weather = listOf(Weather("Clear sky", "01d", 800, "Clear")),
                wind_deg = 180,
                wind_gust = 30.0,
                wind_speed = 5.0
            ),Hourly(
                clouds = 10,
                dew_point = 15.0,
                dt = 1637658000,
                feels_like = 20.0,
                humidity = 70,
                pop = 0.2,
                pressure = 1015,
                rain = Rain(1.5),
                temp = 25.0,
                uvi = 8.0,
                visibility = 10000,
                weather = listOf(Weather("Clear sky", "01d", 800, "Clear")),
                wind_deg = 180,
                wind_gust = 30.0,
                wind_speed = 5.0
            ),Hourly(
                clouds = 10,
                dew_point = 15.0,
                dt = 1637658000,
                feels_like = 20.0,
                humidity = 70,
                pop = 0.2,
                pressure = 1015,
                rain = Rain(1.5),
                temp = 25.0,
                uvi = 8.0,
                visibility = 10000,
                weather = listOf(Weather("Clear sky", "01d", 800, "Clear")),
                wind_deg = 180,
                wind_gust = 30.0,
                wind_speed = 5.0
            ),Hourly(
                clouds = 10,
                dew_point = 15.0,
                dt = 1637658000,
                feels_like = 20.0,
                humidity = 70,
                pop = 0.2,
                pressure = 1015,
                rain = Rain(1.5),
                temp = 25.0,
                uvi = 8.0,
                visibility = 10000,
                weather = listOf(Weather("Clear sky", "01d", 800, "Clear")),
                wind_deg = 180,
                wind_gust = 30.0,
                wind_speed = 5.0
            ),Hourly(
                clouds = 10,
                dew_point = 15.0,
                dt = 1637658000,
                feels_like = 20.0,
                humidity = 70,
                pop = 0.2,
                pressure = 1015,
                rain = Rain(1.5),
                temp = 25.0,
                uvi = 8.0,
                visibility = 10000,
                weather = listOf(Weather("Clear sky", "01d", 800, "Clear")),
                wind_deg = 180,
                wind_gust = 30.0,
                wind_speed = 5.0
            )
            // Add more Hourly instances as needed
        )
        val dailyList = listOf(
            Daily(
                clouds = 20,
                dew_point = 12.0,
                dt = 1637658000,
                feels_like = FeelsLike(25.0, 22.0, 15.0, 18.0),
                humidity = 60,
                moon_phase = 0.5,
                moonrise = 1637658000,
                moonset = 1637691600,
                pop = 0.1,
                pressure = 1015,
                rain = 1.5,
                summary = "Partly cloudy",
                sunrise = 1637658000,
                sunset = 1637691600,
                temp = Temp(20.0, 15.0, 25.0, 18.0, 22.0, 15.0),
                uvi = 7.5,
                weather = listOf(Weather("Partly cloudy", "02d", 802, "Clouds")),
                wind_deg = 180,
                wind_gust = 30.0,
                wind_speed = 5.0
            ),
            Daily(
                clouds = 15,
                dew_point = 14.0,
                dt = 1637744400,
                feels_like = FeelsLike(28.0, 24.0, 18.0, 20.0),
                humidity = 65,
                moon_phase = 0.8,
                moonrise = 1637744400,
                moonset = 1637784000,
                pop = 0.2,
                pressure = 1010,
                rain = 0.5,
                summary = "Showers",
                sunrise = 1637744400,
                sunset = 1637784000,
                temp = Temp(24.0, 18.0, 28.0, 20.0, 24.0, 18.0),
                uvi = 8.0,
                weather = listOf(Weather("Showers", "10d", 501, "Rain")),
                wind_deg = 200,
                wind_gust = 35.0,
                wind_speed = 6.0
            ),
            Daily(
                clouds = 15,
                dew_point = 14.0,
                dt = 1637744400,
                feels_like = FeelsLike(28.0, 24.0, 18.0, 20.0),
                humidity = 65,
                moon_phase = 0.8,
                moonrise = 1637744400,
                moonset = 1637784000,
                pop = 0.2,
                pressure = 1010,
                rain = 0.5,
                summary = "Showers",
                sunrise = 1637744400,
                sunset = 1637784000,
                temp = Temp(24.0, 18.0, 28.0, 20.0, 24.0, 18.0),
                uvi = 8.0,
                weather = listOf(Weather("Showers", "10d", 501, "Rain")),
                wind_deg = 200,
                wind_gust = 35.0,
                wind_speed = 6.0
            ), Daily(
                clouds = 15,
                dew_point = 14.0,
                dt = 1637744400,
                feels_like = FeelsLike(28.0, 24.0, 18.0, 20.0),
                humidity = 65,
                moon_phase = 0.8,
                moonrise = 1637744400,
                moonset = 1637784000,
                pop = 0.2,
                pressure = 1010,
                rain = 0.5,
                summary = "Showers",
                sunrise = 1637744400,
                sunset = 1637784000,
                temp = Temp(24.0, 18.0, 28.0, 20.0, 24.0, 18.0),
                uvi = 8.0,
                weather = listOf(Weather("Showers", "10d", 501, "Rain")),
                wind_deg = 200,
                wind_gust = 35.0,
                wind_speed = 6.0
            ), Daily(
                clouds = 15,
                dew_point = 14.0,
                dt = 1637744400,
                feels_like = FeelsLike(28.0, 24.0, 18.0, 20.0),
                humidity = 65,
                moon_phase = 0.8,
                moonrise = 1637744400,
                moonset = 1637784000,
                pop = 0.2,
                pressure = 1010,
                rain = 0.5,
                summary = "Showers",
                sunrise = 1637744400,
                sunset = 1637784000,
                temp = Temp(24.0, 18.0, 28.0, 20.0, 24.0, 18.0),
                uvi = 8.0,
                weather = listOf(Weather("Showers", "10d", 501, "Rain")),
                wind_deg = 200,
                wind_gust = 35.0,
                wind_speed = 6.0
            ), Daily(
                clouds = 15,
                dew_point = 14.0,
                dt = 1637744400,
                feels_like = FeelsLike(28.0, 24.0, 18.0, 20.0),
                humidity = 65,
                moon_phase = 0.8,
                moonrise = 1637744400,
                moonset = 1637784000,
                pop = 0.2,
                pressure = 1010,
                rain = 0.5,
                summary = "Showers",
                sunrise = 1637744400,
                sunset = 1637784000,
                temp = Temp(24.0, 18.0, 28.0, 20.0, 24.0, 18.0),
                uvi = 8.0,
                weather = listOf(Weather("Showers", "10d", 501, "Rain")),
                wind_deg = 200,
                wind_gust = 35.0,
                wind_speed = 6.0
            ), Daily(
                clouds = 15,
                dew_point = 14.0,
                dt = 1637744400,
                feels_like = FeelsLike(28.0, 24.0, 18.0, 20.0),
                humidity = 65,
                moon_phase = 0.8,
                moonrise = 1637744400,
                moonset = 1637784000,
                pop = 0.2,
                pressure = 1010,
                rain = 0.5,
                summary = "Showers",
                sunrise = 1637744400,
                sunset = 1637784000,
                temp = Temp(24.0, 18.0, 28.0, 20.0, 24.0, 18.0),
                uvi = 8.0,
                weather = listOf(Weather("Showers", "10d", 501, "Rain")),
                wind_deg = 200,
                wind_gust = 35.0,
                wind_speed = 6.0
            ), Daily(
                clouds = 15,
                dew_point = 14.0,
                dt = 1637744400,
                feels_like = FeelsLike(28.0, 24.0, 18.0, 20.0),
                humidity = 65,
                moon_phase = 0.8,
                moonrise = 1637744400,
                moonset = 1637784000,
                pop = 0.2,
                pressure = 1010,
                rain = 0.5,
                summary = "Showers",
                sunrise = 1637744400,
                sunset = 1637784000,
                temp = Temp(24.0, 18.0, 28.0, 20.0, 24.0, 18.0),
                uvi = 8.0,
                weather = listOf(Weather("Showers", "10d", 501, "Rain")),
                wind_deg = 200,
                wind_gust = 35.0,
                wind_speed = 6.0
            ), Daily(
                clouds = 15,
                dew_point = 14.0,
                dt = 1637744400,
                feels_like = FeelsLike(28.0, 24.0, 18.0, 20.0),
                humidity = 65,
                moon_phase = 0.8,
                moonrise = 1637744400,
                moonset = 1637784000,
                pop = 0.2,
                pressure = 1010,
                rain = 0.5,
                summary = "Showers",
                sunrise = 1637744400,
                sunset = 1637784000,
                temp = Temp(24.0, 18.0, 28.0, 20.0, 24.0, 18.0),
                uvi = 8.0,
                weather = listOf(Weather("Showers", "10d", 501, "Rain")),
                wind_deg = 200,
                wind_gust = 35.0,
                wind_speed = 6.0
            ), Daily(
                clouds = 15,
                dew_point = 14.0,
                dt = 1637744400,
                feels_like = FeelsLike(28.0, 24.0, 18.0, 20.0),
                humidity = 65,
                moon_phase = 0.8,
                moonrise = 1637744400,
                moonset = 1637784000,
                pop = 0.2,
                pressure = 1010,
                rain = 0.5,
                summary = "Showers",
                sunrise = 1637744400,
                sunset = 1637784000,
                temp = Temp(24.0, 18.0, 28.0, 20.0, 24.0, 18.0),
                uvi = 8.0,
                weather = listOf(Weather("Showers", "10d", 501, "Rain")),
                wind_deg = 200,
                wind_gust = 35.0,
                wind_speed = 6.0
            )
            // Add more Daily instances as needed
        )

        hourlyAdapter.submitList(hourlyList)
        dailyAdapter.submitList(dailyList)
        return binding.root
    }


}