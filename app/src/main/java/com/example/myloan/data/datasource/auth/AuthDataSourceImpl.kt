package com.example.myloan.data.datasource.auth

import com.example.myloan.data.api.AuthApi
import com.example.myloan.domain.model.auth.Auth
import com.example.myloan.domain.model.auth.UserEntity
import com.example.myloan.network.OnLoadListener
import com.example.myloan.network.RetrofitCallback

class AuthDataSourceImpl(private val authApi: AuthApi) : AuthDataSource {

    override fun registration(auth: Auth, onLoadListener: OnLoadListener<UserEntity>) {
        authApi.registration(auth).enqueue(RetrofitCallback(onLoadListener))
    }

    override fun login(auth: Auth, onLoadListener: OnLoadListener<String>) {
        authApi.login(auth).enqueue(RetrofitCallback(onLoadListener))
    }
}