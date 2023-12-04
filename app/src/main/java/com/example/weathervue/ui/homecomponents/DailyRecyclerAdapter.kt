package com.example.weathervue.ui.homecomponents

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.weathervue.R
import com.example.weathervue.data.model.Daily
import com.example.weathervue.data.model.Hourly
import com.example.weathervue.databinding.DailyItemBinding
import com.example.weathervue.databinding.FragmentHomeBinding
import com.example.weathervue.databinding.HourStateItemBinding

class DailyRecyclerAdapter : ListAdapter<Daily
        ,DailyRecyclerAdapter.ItemViewHolder>(DiffUtils) {


   object DiffUtils: DiffUtil.ItemCallback<Daily>(){
           override fun areItemsTheSame(oldItem: Daily, newItem: Daily): Boolean {
              return oldItem === newItem
           }

           override fun areContentsTheSame(oldItem: Daily, newItem: Daily): Boolean {
               return oldItem == newItem
           }
       }



inner class ItemViewHolder( val binding: DailyItemBinding): ViewHolder(binding.root)
     private lateinit var binding: DailyItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context)
            , R.layout.daily_item,parent
            ,false)
        return ItemViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        val daily = getItem(position)

    }


}