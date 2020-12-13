package com.example.myloan.domain.repository

import com.example.myloan.domain.model.auth.Auth
import com.example.myloan.domain.model.auth.UserEntity
import com.example.myloan.network.OnLoadListener

interface AuthRepository {
    fun registration(auth: Auth, onLoadListener: OnLoadListener<UserEntity>)

    fun login(auth: Auth, onLoadListener: OnLoadListener<String>)
}