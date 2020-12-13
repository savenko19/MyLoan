package com.example.myloan.domain.model.loans

data class LoanConditions(
    val maxAmount: Int,
    val percent: Double,
    val period: Int
)