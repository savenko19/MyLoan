package com.example.myloan.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.IllegalStateException

class RetrofitCallback<T>(private val onLoadListener: OnLoadListener<T>) : Callback<T> {

    override fun onResponse(call: Call<T>, response: Response<T>) {
        val code: Int = response.code()
        if (response.isSuccessful) {
            val body: T? = response.body()

            if (body != null) {
                onLoadListener.onSuccess(body)
            } else {
                onLoadListener.onFailure(IllegalStateException(), code)
            }
        } else {
            onLoadListener.onFailure(IllegalStateException(), code)
        }
    }

    override fun onFailure(call: Call<T>, t: Throwable) {

    }
}