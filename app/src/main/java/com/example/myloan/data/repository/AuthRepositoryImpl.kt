package com.example.myloan.data.repository

import com.example.myloan.data.datasource.auth.AuthDataSource
import com.example.myloan.domain.model.auth.Auth
import com.example.myloan.domain.model.auth.UserEntity
import com.example.myloan.domain.repository.AuthRepository
import com.example.myloan.network.OnLoadListener

class AuthRepositoryImpl(private val authDataSource: AuthDataSource) : AuthRepository {

    override fun registration(auth: Auth, onLoadListener: OnLoadListener<UserEntity>) {
        authDataSource.registration(auth, onLoadListener)
    }

    override fun login(auth: Auth, onLoadListener: OnLoadListener<String>) {
        authDataSource.login(auth, onLoadListener)
    }
}