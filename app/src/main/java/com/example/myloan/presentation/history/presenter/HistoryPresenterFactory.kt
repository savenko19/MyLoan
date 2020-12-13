package com.example.myloan.presentation.history.presenter

import android.content.Context
import com.example.myloan.App
import com.example.myloan.data.api.LoansApi
import com.example.myloan.data.datasource.loans.LoansDataSourceImpl
import com.example.myloan.data.repository.LoansRepositoryImpl
import com.example.myloan.domain.usecase.loans.GetLoanDataUseCase
import com.example.myloan.domain.usecase.loans.GetLoansListUseCase

class HistoryPresenterFactory {

    companion object {
        fun createPresenter(context: Context) : HistoryPresenterImpl {
            val loanApi = App.getRetrofitProvider(context)
                ?.getRetrofit()
                ?.create(LoansApi::class.java)

            val loansDataSource = LoansDataSourceImpl(loanApi!!)
            val loanRepository = LoansRepositoryImpl(loansDataSource)
            val getLoansListUseCase = GetLoansListUseCase(loanRepository)
            val getLoanDataUseCase = GetLoanDataUseCase(loanRepository)

            return HistoryPresenterImpl(getLoansListUseCase, getLoanDataUseCase)
        }
    }
}