package com.example.myloan.domain.usecase.auth

import com.example.myloan.domain.model.auth.Auth
import com.example.myloan.domain.model.auth.UserEntity
import com.example.myloan.domain.repository.AuthRepository
import com.example.myloan.network.OnLoadListener

class RegisterUseCase(private val authRepository: AuthRepository) {

    fun registration(auth: Auth, onLoadListener: OnLoadListener<UserEntity>) {
        authRepository.registration(auth, onLoadListener)
    }
}