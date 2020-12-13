package com.example.myloan.domain.usecase.loans

import com.example.myloan.domain.model.loans.Loan
import com.example.myloan.domain.repository.LoansRepository
import com.example.myloan.network.OnLoadListener

class GetLoansListUseCase(private val loansRepository: LoansRepository) {

    fun getLoansList(token: String, onLoadListener: OnLoadListener<ArrayList<Loan>>) {
        loansRepository.getLoansList(token, onLoadListener)
    }
}