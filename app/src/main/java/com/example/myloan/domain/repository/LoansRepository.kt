package com.example.myloan.domain.repository

import com.example.myloan.domain.model.loans.Loan
import com.example.myloan.domain.model.loans.LoanConditions
import com.example.myloan.domain.model.loans.LoanRequest
import com.example.myloan.network.OnLoadListener

interface LoansRepository {

    fun getLoanConditions(token: String, onLoadListener: OnLoadListener<LoanConditions>)

    fun createNewLoan(token: String, loanRequest: LoanRequest, onLoadListener: OnLoadListener<Loan>)

    fun getLoansList(token: String, onLoadListener: OnLoadListener<ArrayList<Loan>>)

    fun getLoanData(token: String, id: Int, onLoadListener: OnLoadListener<Loan>)
}