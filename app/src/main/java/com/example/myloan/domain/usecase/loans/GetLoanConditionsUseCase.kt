package com.example.myloan.domain.usecase.loans

import com.example.myloan.domain.model.loans.LoanConditions
import com.example.myloan.domain.repository.LoansRepository
import com.example.myloan.network.OnLoadListener

class GetLoanConditionsUseCase(private val loansRepository: LoansRepository) {

    fun getLoanConditions(token: String, onLoadListener: OnLoadListener<LoanConditions>) {
        loansRepository.getLoanConditions(token, onLoadListener)
    }
}