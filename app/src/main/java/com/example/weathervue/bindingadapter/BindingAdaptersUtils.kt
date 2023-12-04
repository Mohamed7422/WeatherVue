package com.example.weathervue.bindingadapter

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


@BindingAdapter("ImageSrc","ErrorSrc")
fun loadImg(view: ImageView,url:String,error:Drawable){
    Glide.with(view.context)
        .load(url).error(error).into(view)
}