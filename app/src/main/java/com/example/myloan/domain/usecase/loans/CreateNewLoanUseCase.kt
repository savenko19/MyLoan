package com.example.myloan.domain.usecase.loans

import com.example.myloan.domain.model.loans.Loan
import com.example.myloan.domain.model.loans.LoanRequest
import com.example.myloan.domain.repository.LoansRepository
import com.example.myloan.network.OnLoadListener

class CreateNewLoanUseCase(private val loansRepository: LoansRepository) {
    fun createNewLoan(token: String, loanRequest: LoanRequest, onLoadListener: OnLoadListener<Loan>) {
        loansRepository.createNewLoan(token, loanRequest, onLoadListener)
    }
}