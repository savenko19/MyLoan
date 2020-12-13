package com.example.myloan.presentation.mvp

interface MvpPresenter<V : MvpView> {

    fun onAttachView(mvpView: V)

    fun viewIsReady()

    fun onDetachView()
}