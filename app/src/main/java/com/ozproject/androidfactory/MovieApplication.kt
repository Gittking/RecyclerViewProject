package com.ozproject.androidfactory

import android.app.Application
import android.content.Intent
import android.os.Handler

class MovieApplication:Application() {


    companion object {
       lateinit var application: MovieApplication
    }


    override fun onCreate() {
        super.onCreate()


        application  = this
        SharedPrefernces.init(this)
    }


}