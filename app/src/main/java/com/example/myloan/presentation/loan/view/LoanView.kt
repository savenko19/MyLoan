package com.example.myloan.presentation.loan.view

import com.example.myloan.domain.model.loans.Loan
import com.example.myloan.presentation.mvp.MvpView

interface LoanView : MvpView {

    fun showLoanConditions(
        maxAmount: Int,
        percent: Double,
        period: Int
    )

    fun getToken(): String?

    fun showLoanInfo(loan: Loan)
}