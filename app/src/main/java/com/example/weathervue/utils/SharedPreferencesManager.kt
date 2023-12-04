package com.example.weathervue.utils

import android.content.Context
import android.content.SharedPreferences

  class SharedPreferencesManager(private val context: Context,private val fileName: String) {

    private val sharedPreferences:SharedPreferences =
        context.getSharedPreferences(fileName,Context.MODE_PRIVATE)

    private val editor:SharedPreferences.Editor = sharedPreferences.edit()


    internal fun saveData(key:String,value: Any){
        when(value){
            is String -> editor.putString(key, value)
            is Int -> editor.putInt(key, value)
            is Long -> editor.putLong(key, value)
            is Float -> editor.putFloat(key, value)
            is Boolean -> editor.putBoolean(key, value)
            else -> throw IllegalArgumentException("Unsupported data type")
        }
        editor.apply()

    }

    internal inline fun <reified T:Any> getData(key:String,defaultValue:T):T{
          val storedValue : Any = when(T::class){
             String::class -> sharedPreferences.getString(key,defaultValue as String) as T
             Int::class ->  sharedPreferences.getInt(key,defaultValue as Int) as T
             Long::class -> sharedPreferences.getLong(key, defaultValue as Long) as T
              Float::class -> sharedPreferences.getFloat(key, defaultValue as Float) as T
              Boolean::class -> sharedPreferences.getBoolean(key, defaultValue as Boolean) as T
               else -> throw IllegalArgumentException("Unsupported data type")
           }
        return storedValue as T
    }

}