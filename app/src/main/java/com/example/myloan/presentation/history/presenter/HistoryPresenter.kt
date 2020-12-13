package com.example.myloan.presentation.history.presenter

import com.example.myloan.presentation.history.view.HistoryView
import com.example.myloan.presentation.mvp.MvpPresenter

interface HistoryPresenter : MvpPresenter<HistoryView> {

    fun getLoanData(id: Int)
}