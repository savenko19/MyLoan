package com.example.myloan.presentation.history.presenter

import android.util.Log
import com.example.myloan.domain.model.loans.Loan
import com.example.myloan.domain.usecase.loans.GetLoanDataUseCase
import com.example.myloan.domain.usecase.loans.GetLoansListUseCase
import com.example.myloan.network.OnLoadListener
import com.example.myloan.presentation.history.view.HistoryView
import com.example.myloan.presentation.mvp.BasePresenter
import javax.inject.Inject

class HistoryPresenterImpl(
    private val getLoansListUseCase: GetLoansListUseCase,
    private val getLoanDataUseCase: GetLoanDataUseCase
) : BasePresenter<HistoryView>(), HistoryPresenter {


    override fun viewIsReady() {
        getLoansListUseCase.getLoansList(
            view?.getToken()!!,
            object : OnLoadListener<ArrayList<Loan>> {
                override fun onSuccess(result: ArrayList<Loan>) {
                    view?.showLoansHistory(result)
                }

                override fun onFailure(throwable: Throwable, code: Int) {

                }
            })

    }

    override fun getLoanData(id: Int) {
        getLoanDataUseCase.getLoanData(view?.getToken()!!, id, object:OnLoadListener<Loan> {
            override fun onSuccess(result: Loan) {
                Log.e("Test", "GET LOAN DATA SUCCESS")
                view?.showLoanInfo(result)
            }

            override fun onFailure(throwable: Throwable, code: Int) {
                Log.e("Test", "GET LOAN DATA FAILURE: $code")
            }
        })
    }
}