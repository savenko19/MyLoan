package com.example.myloan.data.api

import com.example.myloan.domain.model.loans.Loan
import com.example.myloan.domain.model.loans.LoanConditions
import com.example.myloan.domain.model.loans.LoanRequest
import retrofit2.Call
import retrofit2.http.*

interface LoansApi {

    @POST("loans")
    fun createNewLoan(
        @Header("Authorization") token: String,
        @Body loanRequest: LoanRequest
    ): Call<Loan>

    @GET("loans/{id}")
    fun getLoanData(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ): Call<Loan>

    @GET("loans/all")
    fun getLoansList(@Header("Authorization") token: String): Call<ArrayList<Loan>>

    @GET("loans/conditions")
    fun getLoanConditions(@Header("Authorization") token: String): Call<LoanConditions>
}