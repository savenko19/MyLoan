package com.example.myloan.domain.usecase.auth

import com.example.myloan.domain.model.auth.Auth
import com.example.myloan.domain.repository.AuthRepository
import com.example.myloan.network.OnLoadListener

class LoginUseCase(private val authRepository: AuthRepository) {

    fun login(auth: Auth, onLoadListener: OnLoadListener<String>) {
        authRepository.login(auth, onLoadListener)
    }
}