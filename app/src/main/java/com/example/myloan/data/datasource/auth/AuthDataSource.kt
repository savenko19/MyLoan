package com.example.myloan.data.datasource.auth

import com.example.myloan.domain.model.auth.Auth
import com.example.myloan.domain.model.auth.UserEntity
import com.example.myloan.network.OnLoadListener

interface AuthDataSource {

    fun registration(auth: Auth, onLoadListener: OnLoadListener<UserEntity>)

    fun login(auth: Auth, onLoadListener: OnLoadListener<String>)

}