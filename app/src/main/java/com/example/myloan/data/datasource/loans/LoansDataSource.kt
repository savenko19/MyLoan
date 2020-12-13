package com.example.myloan.data.datasource.loans

import com.example.myloan.domain.model.loans.Loan
import com.example.myloan.domain.model.loans.LoanConditions
import com.example.myloan.domain.model.loans.LoanRequest
import com.example.myloan.network.OnLoadListener

interface LoansDataSource {

    fun createNewLoan(token: String, loanRequest: LoanRequest, onLoadListener: OnLoadListener<Loan>)

    fun getLoansList(token: String, onLoadListener: OnLoadListener<ArrayList<Loan>>)

    fun getLoanConditions(token: String, onLoadListener: OnLoadListener<LoanConditions>)

    fun getLoanData(token: String, id: Int, onLoadListener: OnLoadListener<Loan>)
}