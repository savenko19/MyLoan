package com.example.myloan

import android.app.Application
import android.content.Context
import com.example.myloan.network.RetrofitProvider

class App : Application() {

    private var retrofitProvider: RetrofitProvider? = null

    companion object {
        private fun getApp(context: Context) = context.applicationContext as App
        fun getRetrofitProvider(context: Context) = getApp(context).retrofitProvider
    }

    override fun onCreate() {
        super.onCreate()
        retrofitProvider = RetrofitProvider()
    }
}