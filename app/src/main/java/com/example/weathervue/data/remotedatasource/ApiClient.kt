package com.example.weathervue.data.remotedatasource

import com.example.weathervue.utils.APP_KEY
import com.example.weathervue.utils.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//singleton
object ApiHelper {

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

}

object ApiClient{
     val apiClient:ApiService by lazy {
         ApiHelper.retrofit.create(ApiService::class.java)
     }
}