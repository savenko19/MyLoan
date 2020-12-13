package com.example.myloan.data.datasource.loans

import com.example.myloan.data.api.LoansApi
import com.example.myloan.domain.model.loans.Loan
import com.example.myloan.domain.model.loans.LoanConditions
import com.example.myloan.domain.model.loans.LoanRequest
import com.example.myloan.network.OnLoadListener
import com.example.myloan.network.RetrofitCallback
import retrofit2.http.Header

class LoansDataSourceImpl(private val loansApi: LoansApi) : LoansDataSource {

    override fun createNewLoan(
        token: String,
        loanRequest: LoanRequest,
        onLoadListener: OnLoadListener<Loan>
    ) {
        loansApi.createNewLoan(token, loanRequest).enqueue(RetrofitCallback(onLoadListener))
    }

    override fun getLoansList(token: String, onLoadListener: OnLoadListener<ArrayList<Loan>>) {
        loansApi.getLoansList(token).enqueue(RetrofitCallback(onLoadListener))
    }

    override fun getLoanConditions(token: String, onLoadListener: OnLoadListener<LoanConditions>) {
        loansApi.getLoanConditions(token).enqueue(RetrofitCallback(onLoadListener))
    }

    override fun getLoanData(token: String, id: Int, onLoadListener: OnLoadListener<Loan>) {
        loansApi.getLoanData(token, id).enqueue(RetrofitCallback(onLoadListener))
    }
}