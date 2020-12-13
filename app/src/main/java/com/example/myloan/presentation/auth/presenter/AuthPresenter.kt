package com.example.myloan.presentation.auth.presenter

import com.example.myloan.presentation.auth.view.AuthView
import com.example.myloan.presentation.mvp.MvpPresenter

interface AuthPresenter : MvpPresenter<AuthView> {

    fun signIn(
        username: String,
        password: String
    )

    fun signUp(
        username: String,
        password: String
    )
}