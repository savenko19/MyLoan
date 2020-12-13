package com.example.myloan.presentation.auth.view

import android.content.Context
import com.example.myloan.presentation.mvp.MvpView

interface AuthView : MvpView {

    fun startApp()

    fun saveToken(token: String)
}