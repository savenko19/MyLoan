package com.example.myloan.presentation.loan.presenter

import android.content.Context
import com.example.myloan.App
import com.example.myloan.data.api.LoansApi
import com.example.myloan.data.datasource.loans.LoansDataSourceImpl
import com.example.myloan.data.repository.AuthRepositoryImpl
import com.example.myloan.data.repository.LoansRepositoryImpl
import com.example.myloan.domain.usecase.auth.LoginUseCase
import com.example.myloan.domain.usecase.auth.RegisterUseCase
import com.example.myloan.domain.usecase.loans.CreateNewLoanUseCase
import com.example.myloan.domain.usecase.loans.GetLoanConditionsUseCase
import com.example.myloan.presentation.auth.presenter.AuthPresenterImpl

class LoanPresenterFactory {
    companion object {

        fun createPresenter(context: Context): LoanPresenterImpl {
            val loanApi = App.getRetrofitProvider(context)
                ?.getRetrofit()
                ?.create(LoansApi::class.java)

            val loansDataSource = LoansDataSourceImpl(loanApi!!)
            val loanRepository = LoansRepositoryImpl(loansDataSource)
            val getLoanConditionsUseCase = GetLoanConditionsUseCase(loanRepository)
            val createNewLoanUseCase = CreateNewLoanUseCase(loanRepository)

            return LoanPresenterImpl(getLoanConditionsUseCase, createNewLoanUseCase)
        }
    }
}