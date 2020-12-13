package com.example.myloan.presentation.loan.view

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import com.example.myloan.R
import com.example.myloan.domain.model.loans.Loan
import com.example.myloan.presentation.loan.presenter.LoanPresenter
import com.example.myloan.presentation.loan.presenter.LoanPresenterFactory
import com.google.android.material.textfield.TextInputLayout


class LoanFragment : Fragment(), LoanView {

    lateinit var presenter: LoanPresenter

    private lateinit var amountLoanTil: TextInputLayout
    private lateinit var firstNameTil: TextInputLayout
    private lateinit var lastNameTil: TextInputLayout
    private lateinit var phoneNumberTil: TextInputLayout

    private lateinit var maxAmountTv: TextView
    private lateinit var percentTv: TextView
    private lateinit var periodTv: TextView

    private lateinit var createLoanBtn: Button

    companion object {

        fun newInstance() = LoanFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        presenter = LoanPresenterFactory.createPresenter(requireContext())
        presenter.onAttachView(this)
        return inflater.inflate(R.layout.fragment_loan, container, false)
    }

    override fun onResume() {
        super.onResume()
        presenter.viewIsReady()
    }

    private fun initView() {

        //Personal data
        firstNameTil = view!!.findViewById(R.id.first_name_til)
        lastNameTil = view!!.findViewById(R.id.last_name_til)
        phoneNumberTil = view!!.findViewById(R.id.phone_number_til)

        //Loan data
        amountLoanTil = view!!.findViewById(R.id.loan_amount_til)
        amountLoanTil.editText!!.addTextChangedListener { object:TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                    createLoanBtn.isEnabled = true

            }

            override fun afterTextChanged(p0: Editable?) {

            }
        } }

        //Loan conditions
        maxAmountTv = view!!.findViewById(R.id.max_amount_tv)
        percentTv = view!!.findViewById(R.id.percent_tv)
        periodTv = view!!.findViewById(R.id.period_tv)

        createLoanBtn = view!!.findViewById(R.id.create_loan_btn)
        createLoanBtn.setOnClickListener {
            //Create new loan
            presenter.createNewLoan(
                Integer.parseInt(amountLoanTil.editText!!.text.toString()),
                firstNameTil.editText!!.text.toString(),
                lastNameTil.editText!!.text.toString(),
                (percentTv.text.toString()).toDouble(),
                (periodTv.text.toString()).toInt(),
                phoneNumberTil.editText!!.text.toString()
            )
        }
    }

    override fun showLoanConditions(maxAmount: Int, percent: Double, period: Int) {
        maxAmountTv.text = "$maxAmount"
        percentTv.text = "$percent"
        periodTv.text = "$period"
    }

    override fun getToken() = context!!.getSharedPreferences("main", Context.MODE_PRIVATE).getString("token", null)

    override fun showLoanInfo(loan: Loan) {
        val loanDialogBuilder = AlertDialog.Builder(requireContext())

        val loanDialogView = layoutInflater.inflate(R.layout.loan_item_dialog_layout, null)
        loanDialogBuilder.setView(loanDialogView)

        val amountTv: TextView = loanDialogView.findViewById(R.id.loan_amount_tv)
        val percentTv: TextView = loanDialogView.findViewById(R.id.percent_tv)
        val periodTv: TextView = loanDialogView.findViewById(R.id.period_tv)

        val firstNameTv: TextView = loanDialogView.findViewById(R.id.first_name_tv)
        val lastNameTv: TextView = loanDialogView.findViewById(R.id.last_name_tv)
        val phoneTv: TextView = loanDialogView.findViewById(R.id.phone_number_tv)

        val statusTv: TextView = loanDialogView.findViewById(R.id.status_tv)
        val idTv: TextView = loanDialogView.findViewById(R.id.loan_id_tv)
        val dateTv: TextView = loanDialogView.findViewById(R.id.date_tv)

        amountTv.text = "${getString(R.string.amount)} ${loan.amount}"
        percentTv.text = "${getString(R.string.percent)} ${loan.percent}"
        periodTv.text = "${getString(R.string.amount)} ${loan.period}"

        firstNameTv.text = "${loan.firstName}"
        lastNameTv.text = "${loan.lastName}"
        phoneTv.text = "${getString(R.string.phone_number)} ${loan.phoneNumber}"

        when (loan.state) {
            "APPROVED" -> statusTv.text = "${getString(R.string.approved)}"
            "REGISTERED" -> statusTv.text = "${getString(R.string.registered)}"
            "REJECTED" -> statusTv.text = "${getString(R.string.rejected)}"
        }

        idTv.text = "№${loan.id}"
        dateTv.text = "${loan.date}"

        val loanDialog = loanDialogBuilder.create()
        loanDialog.show()
    }
}