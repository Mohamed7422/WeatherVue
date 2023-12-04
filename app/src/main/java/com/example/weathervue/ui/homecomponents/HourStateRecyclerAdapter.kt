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
import com.example.weathervue.data.model.Hourly
import com.example.weathervue.databinding.FragmentHomeBinding
import com.example.weathervue.databinding.HourStateItemBinding

class HourStateRecyclerAdapter : ListAdapter<Hourly
        ,HourStateRecyclerAdapter.ItemViewHolder>(DiffUtils) {


   object DiffUtils: DiffUtil.ItemCallback<Hourly>(){
           override fun areItemsTheSame(oldItem: Hourly, newItem: Hourly): Boolean {
              return oldItem === newItem
           }

           override fun areContentsTheSame(oldItem: Hourly, newItem: Hourly): Boolean {
               return oldItem == newItem
           }
       }



inner class ItemViewHolder( val binding: HourStateItemBinding): ViewHolder(binding.root)
     private lateinit var binding: HourStateItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context)
            , R.layout.hour_state_item,parent
            ,false)
        return ItemViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        val hourly = getItem(position)
        holder.binding.hourStateModel = hourly
    }


}