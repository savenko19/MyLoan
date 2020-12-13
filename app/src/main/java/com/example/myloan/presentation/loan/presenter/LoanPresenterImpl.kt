package com.example.myloan.presentation.loan.presenter

import android.util.Log
import com.example.myloan.domain.model.loans.Loan
import com.example.myloan.domain.model.loans.LoanConditions
import com.example.myloan.domain.model.loans.LoanRequest
import com.example.myloan.domain.usecase.loans.CreateNewLoanUseCase
import com.example.myloan.domain.usecase.loans.GetLoanConditionsUseCase
import com.example.myloan.network.OnLoadListener
import com.example.myloan.presentation.loan.view.LoanView
import com.example.myloan.presentation.mvp.BasePresenter

class LoanPresenterImpl(
    private val getLoanConditionsUseCase: GetLoanConditionsUseCase,
    private val createNewLoanUseCase: CreateNewLoanUseCase
) :
    BasePresenter<LoanView>(), LoanPresenter {

    override fun viewIsReady() {
        getLoanConditionsUseCase.getLoanConditions(
            view?.getToken()!!,
            object : OnLoadListener<LoanConditions> {
                override fun onSuccess(result: LoanConditions) {
                    Log.e("Test", "LOAN COND SUCCESS")
                    view?.showLoanConditions(
                        result.maxAmount,
                        result.percent,
                        result.period
                    )
                }

                override fun onFailure(throwable: Throwable, code: Int) {
                    Log.e("Test", "LOAN COND FAILURE")
                }
            })

    }

    override fun createNewLoan(
        amount: Int,
        firstName: String,
        lastName: String,
        percent: Double,
        period: Int,
        phoneNumber: String
    ) {
        val loanRequest = LoanRequest(
            amount,
            firstName,
            lastName,
            percent,
            period,
            phoneNumber
        )

        createNewLoanUseCase.createNewLoan(view?.getToken()!!, loanRequest, object: OnLoadListener<Loan> {
            override fun onSuccess(result: Loan) {
                Log.e("Test", "SUCCESS CREATE LOAN")
                view?.showLoanInfo(result)
            }

            override fun onFailure(throwable: Throwable, code: Int) {
                Log.e("Test", "FAILURE CREATE LOAN: ${throwable.localizedMessage}")

            }
        })
    }
}