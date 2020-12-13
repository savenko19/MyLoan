package com.example.myloan.data.api

import com.example.myloan.domain.model.auth.Auth
import com.example.myloan.domain.model.auth.UserEntity
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {

    @POST("login")
    fun login(@Body auth: Auth): Call<String>

    @POST("registration")
    fun registration(@Body auth: Auth): Call<UserEntity>
}