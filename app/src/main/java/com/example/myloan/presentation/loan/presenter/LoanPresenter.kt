package com.example.myloan.presentation.loan.presenter

import com.example.myloan.presentation.loan.view.LoanView
import com.example.myloan.presentation.mvp.MvpPresenter

interface LoanPresenter : MvpPresenter<LoanView> {

    fun createNewLoan(
        amount: Int,
        firstName: String,
        lastName: String,
        percent: Double,
        period: Int,
        phoneNumber: String
    )
}