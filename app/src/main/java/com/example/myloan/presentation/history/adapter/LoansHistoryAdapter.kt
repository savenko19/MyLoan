package com.example.myloan.presentation.history.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myloan.R
import com.example.myloan.domain.model.loans.Loan

class LoansHistoryAdapter(
    private val loans: ArrayList<Loan>,
    private val onLoanItemClickListener: OnLoanItemClickListener
) : RecyclerView.Adapter<LoansHistoryAdapter.ViewHolder>() {

    interface OnLoanItemClickListener {
        fun onLoanClick(loan: Loan)
    }

    inner class ViewHolder(
        itemView: View,
        private val onLoanItemClickListener: OnLoanItemClickListener
    ) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private val amountTv: TextView = itemView.findViewById(R.id.amount_loan_tv)
        private val dateTv: TextView = itemView.findViewById(R.id.loan_date_tv)
        private val idTv: TextView = itemView.findViewById(R.id.loan_id_tv)
        private val statusIc: FrameLayout = itemView.findViewById(R.id.loan_status_ic)

        fun bind(loan: Loan) {
            amountTv.text = loan.amount.toString()
            idTv.text = "№${loan.id}"
            dateTv.text = loan.date

            when (loan.state) {
                "APPROVED" -> statusIc.background = itemView.context.getDrawable(R.drawable.approved_status_bg)
                "REGISTERED" -> statusIc.background = itemView.context.getDrawable(R.drawable.registered_status_bg)
                "REJECTED" -> statusIc.background = itemView.context.getDrawable(R.drawable.rejected_status_bg)
            }

            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            onLoanItemClickListener.onLoanClick(loans[adapterPosition])
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.loan_item_layout, parent, false),
        onLoanItemClickListener
    )

    override fun onBindViewHolder(holder: LoansHistoryAdapter.ViewHolder, position: Int) {
        holder.bind(loans[position])
    }

    override fun getItemCount() = loans.size
}