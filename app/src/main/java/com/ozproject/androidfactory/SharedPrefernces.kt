package com.ozproject.androidfactory

import android.content.Context
import android.content.SharedPreferences

object SharedPrefernces {
    //  lateinit var context: Context
    lateinit var sharedPref: SharedPreferences // context.getSharedPreferences("pref", Context.MODE_PRIVATE)

    fun init(context: Context) {
        sharedPref = context.getSharedPreferences("${BuildConfig.APPLICATION_ID}", Context.MODE_PRIVATE)

    }

    fun setMovieFavourite(id:String, value:Boolean){
        setBoolean(id,value)
    }

    fun getMovieFavourite(id:String):Boolean{
      return  getBoolean(id)
    }


    fun setBoolean(name: String, value: Boolean) {
        sharedPref.edit().apply {
            putBoolean(name, value).apply()
        }

    }

    fun getBoolean(name: String, defaultValue:Boolean = false):Boolean {
     return   sharedPref.getBoolean(name,defaultValue)
    }



}
