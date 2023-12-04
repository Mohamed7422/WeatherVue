package com.example.weathervue.ui.alertcomponents


import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.example.productsdetailsdayone.base.BaseListRecyclerAdapter
import com.example.weathervue.R
import com.example.weathervue.data.model.entities.AlertEntity

class AlertRecyclerAdapter(listener:OnItemClickListener<AlertEntity>)
    : BaseListRecyclerAdapter<AlertEntity>(listener, R.layout.alert_item, DiffUtils) {

    object DiffUtils: DiffUtil.ItemCallback<AlertEntity>() {
        override fun areItemsTheSame(oldItem: AlertEntity, newItem: AlertEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: AlertEntity, newItem: AlertEntity): Boolean {
            return oldItem == newItem
        }
    }

    override fun bindItem(binding: ViewDataBinding, item: AlertEntity) {
//        if (binding is )
    }

    interface OnAlertItemClickListener:OnItemClickListener<AlertEntity>{
        override fun onItemClick(item: AlertEntity)
    }


}
