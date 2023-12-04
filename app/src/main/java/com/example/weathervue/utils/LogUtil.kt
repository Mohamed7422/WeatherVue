package com.example.weathervue.utils

import android.content.Context
import android.widget.Toast


object LogUtil{
      fun shouToastMsg(context: Context?, msg:String) {
        Toast.makeText(context,msg , Toast.LENGTH_SHORT).show()
    }
}
