package com.example.productsdetailsdayone.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

  abstract class BaseListRecyclerAdapter<T>(
        val listener :OnItemClickListener<T>,
        private val layoutResId:Int,
        diffCallback: DiffUtil.ItemCallback<T>
) :ListAdapter<T, BaseListRecyclerAdapter<T>.ViewHolder>(diffCallback) {

      private lateinit var binding: ViewDataBinding
    //s1
    inner class ViewHolder(val binding:ViewDataBinding):RecyclerView.ViewHolder(binding.root)


      override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
          binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
             layoutResId,parent,false )
          return ViewHolder(binding)
      }

      override fun onBindViewHolder(holder: ViewHolder, position: Int) {
          val item = getItem(position)
          bindItem(holder.binding,item)
          holder.binding.executePendingBindings()
      }


      protected abstract fun bindItem(binding: ViewDataBinding,item:T)

        interface OnItemClickListener<T>{
          fun onItemClick(item:T)
      }


  }