package com.example.myloan.presentation.mvp

abstract class BasePresenter<T : MvpView> : MvpPresenter<T> {

    var view : T? = null

    override fun onAttachView(mvpView: T) {
        view = mvpView
    }

    override fun onDetachView() {
        view = null
    }
}