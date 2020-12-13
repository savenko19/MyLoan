package com.example.myloan.presentation.auth.presenter

import android.util.Log
import com.example.myloan.domain.model.auth.Auth
import com.example.myloan.domain.model.auth.UserEntity
import com.example.myloan.domain.usecase.auth.LoginUseCase
import com.example.myloan.domain.usecase.auth.RegisterUseCase
import com.example.myloan.network.OnLoadListener
import com.example.myloan.presentation.auth.view.AuthView
import com.example.myloan.presentation.mvp.BasePresenter

class AuthPresenterImpl(
    private val loginUseCase: LoginUseCase,
    private val registerUseCase: RegisterUseCase
) : BasePresenter<AuthView>(), AuthPresenter {

    override fun viewIsReady() {

    }

    override fun signIn(username: String, password: String) {
        val auth = Auth(username, password)

        loginUseCase.login(auth, object : OnLoadListener<String> {
            override fun onSuccess(result: String) {
                Log.e("Test", "SUCCESS LOGIN: $result")
                view?.saveToken(result)
                view?.startApp()
            }

            override fun onFailure(throwable: Throwable, code: Int) {
                Log.e("Test", "FAILURE REGISTRATION: ${throwable.localizedMessage}")
            }
        })
    }

    override fun signUp(username: String, password: String) {
        val auth = Auth(username, password)

        registerUseCase.registration(auth, object : OnLoadListener<UserEntity> {
            override fun onSuccess(result: UserEntity) {
                Log.e("Test", "SUCCESS REGISTRATION: ${result.role}")
                loginUseCase.login(auth, object:OnLoadListener<String>{

                    override fun onSuccess(result: String) {
                        Log.e("Test", "SUCCESS LOGIN: $result")
                        view?.saveToken(result)
                        view?.startApp()
                    }

                    override fun onFailure(throwable: Throwable, code: Int) {
                        Log.e("Test", "FAILURE LOGIN: $code")
                    }
                })
            }

            override fun onFailure(throwable: Throwable, code: Int) {
                Log.e("Test", "FAILURE REGISTRATION: $code")
            }
        })
    }
}