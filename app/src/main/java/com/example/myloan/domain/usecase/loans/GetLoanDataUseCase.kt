package com.example.myloan.domain.usecase.loans

import com.example.myloan.domain.model.loans.Loan
import com.example.myloan.domain.repository.LoansRepository
import com.example.myloan.network.OnLoadListener

class GetLoanDataUseCase(private val loansRepository: LoansRepository) {

    fun getLoanData(token: String, id: Int, onLoadListener: OnLoadListener<Loan>) {
        loansRepository.getLoanData(token, id, onLoadListener)
    }
}