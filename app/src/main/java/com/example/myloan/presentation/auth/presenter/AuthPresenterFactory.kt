package com.example.myloan.presentation.auth.presenter

import android.content.Context
import com.example.myloan.App
import com.example.myloan.data.api.AuthApi
import com.example.myloan.data.datasource.auth.AuthDataSourceImpl
import com.example.myloan.data.repository.AuthRepositoryImpl
import com.example.myloan.domain.usecase.auth.LoginUseCase
import com.example.myloan.domain.usecase.auth.RegisterUseCase

class AuthPresenterFactory {

    companion object {
        fun createPresenter(context: Context): AuthPresenterImpl {
            val authApi = App.getRetrofitProvider(context)
                ?.getRetrofit()
                ?.create(AuthApi::class.java)

            val authDataSource = AuthDataSourceImpl(authApi!!)
            val authRepository = AuthRepositoryImpl(authDataSource)
            val loginUseCase = LoginUseCase(authRepository)
            val registerUseCase = RegisterUseCase(authRepository)

            return AuthPresenterImpl(loginUseCase, registerUseCase)
        }
    }
}