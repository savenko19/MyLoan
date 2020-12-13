package com.example.myloan.network

interface OnLoadListener<T> {

    fun onSuccess(result: T)

    fun onFailure(throwable: Throwable, code: Int)
}