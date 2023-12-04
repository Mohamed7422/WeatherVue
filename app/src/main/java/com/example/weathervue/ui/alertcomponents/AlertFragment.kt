package com.example.weathervue.ui.alertcomponents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.weathervue.R
import com.example.weathervue.data.model.entities.AlertEntity
import com.example.weathervue.databinding.FragmentAlertBinding


class AlertFragment : Fragment() , AlertRecyclerAdapter.OnAlertItemClickListener {

    lateinit var recyclerView: RecyclerView
    lateinit var alertRecyclerAdapter: AlertRecyclerAdapter
    lateinit var binding: FragmentAlertBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_alert,container,false)
        recyclerView = binding.alarmRV
        alertRecyclerAdapter  =  AlertRecyclerAdapter(this)


        recyclerView.adapter = alertRecyclerAdapter


        val list = mutableListOf<AlertEntity>(AlertEntity(
            id = "5",
            start = 5.5.toLong(),
            end = 10.0.toLong(),
            "Hi",
            5.5,10.2
        ),AlertEntity(
            id = "5",
            start = 5.5.toLong(),
            end = 10.0.toLong(),
            "Hi",
            5.5,10.2
        ),AlertEntity(
            id = "5",
            start = 5.5.toLong(),
            end = 10.0.toLong(),
            "Hi",
            5.5,10.2
        ),AlertEntity(
            id = "5",
            start = 5.5.toLong(),
            end = 10.0.toLong(),
            "Hi",
            5.5,10.2
        ),AlertEntity(
            id = "5",
            start = 5.5.toLong(),
            end = 10.0.toLong(),
            "Hi",
            5.5,10.2
        ),AlertEntity(
            id = "5",
            start = 5.5.toLong(),
            end = 10.0.toLong(),
            "Hi",
            5.5,10.2
        ),AlertEntity(
            id = "5",
            start = 5.5.toLong(),
            end = 10.0.toLong(),
            "Hi",
            5.5,10.2
        ))
        alertRecyclerAdapter.submitList(list)

        return binding.root
    }

    override fun onItemClick(item: AlertEntity) {
      //
    }


}