package com.example.weathervue.ui.favouriteomponents


import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.example.productsdetailsdayone.base.BaseListRecyclerAdapter
import com.example.weathervue.R
import com.example.weathervue.data.model.entities.SingleFavouriteWeather
import com.example.weathervue.databinding.FavouriteItemBinding

class FavouriteRecyclerAdapter(listener :OnItemClickListener<SingleFavouriteWeather>) :
    BaseListRecyclerAdapter<SingleFavouriteWeather>(
    listener,R.layout.favourite_item,DiffUtils) {

    object DiffUtils: DiffUtil.ItemCallback<SingleFavouriteWeather>(){
        override fun areItemsTheSame(oldItem: SingleFavouriteWeather, newItem: SingleFavouriteWeather): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: SingleFavouriteWeather, newItem: SingleFavouriteWeather): Boolean {
            return oldItem == newItem
        }
    }

    override fun bindItem(binding: ViewDataBinding, item: SingleFavouriteWeather) {
        if (binding is FavouriteItemBinding){
           binding.singleFavouriteModel = item
            binding.favouriteItemClickAction = listener as OnFavouriteItemClickListener
        }
    }

    interface OnFavouriteItemClickListener : OnItemClickListener<SingleFavouriteWeather>{
         override fun onItemClick(item: SingleFavouriteWeather)
    }



}