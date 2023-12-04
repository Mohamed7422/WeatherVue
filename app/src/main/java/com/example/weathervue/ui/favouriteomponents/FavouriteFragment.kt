package com.example.weathervue.ui.favouriteomponents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.weathervue.R
import com.example.weathervue.data.model.Current
import com.example.weathervue.data.model.entities.SingleFavouriteWeather
import com.example.weathervue.databinding.FragmentFavouriteBinding
import com.example.weathervue.utils.LogUtil


class FavouriteFragment : Fragment(),FavouriteRecyclerAdapter.OnFavouriteItemClickListener {
    lateinit var recyclerView: RecyclerView
    lateinit var favouriteRecyclerAdapter: FavouriteRecyclerAdapter
    lateinit var binding: FragmentFavouriteBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(layoutInflater,R.layout.fragment_favourite,container,false)
        // Inflate the layout for this fragment
        recyclerView = binding.favouriteRV
        favouriteRecyclerAdapter = FavouriteRecyclerAdapter(this)
        recyclerView.adapter = favouriteRecyclerAdapter
//        val list = mutableListOf(SingleFavouriteWeather("","",, listOf(), listOf(),0.0,0.0,"",0))
        val singleFavouriteWeather = SingleFavouriteWeather(
            currentTime = "someTime",
            current = Current(
                clouds = 0,
                dew_point = 0.0,
                dt = 0,
                feels_like = 0.0,
                humidity = 0,
                pressure = 0,
                sunrise = 0,
                sunset = 0,
                temp = 0.0,
                uvi = 0.0,
                visibility = 0,
                weather = emptyList(),  // Passing an empty list for Weather
                wind_deg = 0,
                wind_gust = 0.0,
                wind_speed = 0.0
            ),
            daily = emptyList(),
            hourly = emptyList(),
            lat = 0.0,
            lon = 0.0,
            timezone = "UTC",
            timezone_offset = 0
        )

        val list = mutableListOf(singleFavouriteWeather,singleFavouriteWeather,singleFavouriteWeather,singleFavouriteWeather,
            singleFavouriteWeather,singleFavouriteWeather,singleFavouriteWeather)

        favouriteRecyclerAdapter.submitList(list)



        binding.addFloatingBtn.setOnClickListener {
            LogUtil.shouToastMsg(this.context,"Hi From FloatingBtn")
        }
        return binding.root
    }

    override fun onItemClick(item: SingleFavouriteWeather) {
         Toast.makeText(this.requireContext(),"Hola",Toast.LENGTH_SHORT).show()
    }




}