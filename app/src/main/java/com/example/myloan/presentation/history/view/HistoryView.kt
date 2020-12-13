package com.example.myloan.presentation.history.view

import com.example.myloan.domain.model.loans.Loan
import com.example.myloan.presentation.mvp.MvpView

interface HistoryView : MvpView {

    fun showLoansHistory(loans: ArrayList<Loan>)

    fun showLoanInfo(loan: Loan)

    fun getToken(): String?
}