package com.example.myloan.presentation.history.view

import android.app.AlertDialog
import android.content.Context
import android.icu.number.IntegerWidth
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myloan.R
import com.example.myloan.domain.model.loans.Loan
import com.example.myloan.presentation.history.adapter.LoansHistoryAdapter
import com.example.myloan.presentation.history.presenter.HistoryPresenter
import com.example.myloan.presentation.history.presenter.HistoryPresenterFactory
import javax.inject.Inject

class HistoryFragment : Fragment(), LoansHistoryAdapter.OnLoanItemClickListener, HistoryView {

    @Inject
    lateinit var presenter: HistoryPresenter
    lateinit var adapter: LoansHistoryAdapter
    lateinit var loansRecycler: RecyclerView

    companion object {

        fun newInstance() = HistoryFragment()
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
        presenter = HistoryPresenterFactory.createPresenter(requireContext())
        presenter.onAttachView(this)
        return inflater.inflate(R.layout.fragment_history, container, false)
    }

    override fun onResume() {
        super.onResume()
        presenter.viewIsReady()
    }

    private fun initView() {
        loansRecycler = view!!.findViewById(R.id.loans_recycler)

    }

    override fun showLoansHistory(loans: ArrayList<Loan>) {
        adapter = LoansHistoryAdapter(loans, this)

        loansRecycler.adapter = adapter
    }

    override fun getToken() =
        context!!.getSharedPreferences("main", Context.MODE_PRIVATE).getString("token", null)

    override fun onLoanClick(loan: Loan) {
        presenter.getLoanData(loan.id)
    }

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