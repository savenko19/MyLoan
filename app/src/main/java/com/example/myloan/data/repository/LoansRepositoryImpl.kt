package com.example.myloan.data.repository

import com.example.myloan.data.datasource.loans.LoansDataSource
import com.example.myloan.domain.model.auth.Auth
import com.example.myloan.domain.model.auth.UserEntity
import com.example.myloan.domain.model.loans.Loan
import com.example.myloan.domain.model.loans.LoanConditions
import com.example.myloan.domain.model.loans.LoanRequest
import com.example.myloan.domain.repository.AuthRepository
import com.example.myloan.domain.repository.LoansRepository
import com.example.myloan.network.OnLoadListener

class LoansRepositoryImpl(private var loansDataSource: LoansDataSource) : LoansRepository {

    override fun getLoanConditions(token: String, onLoadListener: OnLoadListener<LoanConditions>) {
        loansDataSource.getLoanConditions(token, onLoadListener)
    }

    override fun createNewLoan(
        token: String,
        loanRequest: LoanRequest,
        onLoadListener: OnLoadListener<Loan>
    ) {
        loansDataSource.createNewLoan(token, loanRequest, onLoadListener)
    }

    override fun getLoansList(token: String, onLoadListener: OnLoadListener<ArrayList<Loan>>) {
        loansDataSource.getLoansList(token, onLoadListener)
    }

    override fun getLoanData(token: String, id: Int, onLoadListener: OnLoadListener<Loan>) {
        loansDataSource.getLoanData(token, id, onLoadListener)
    }
}