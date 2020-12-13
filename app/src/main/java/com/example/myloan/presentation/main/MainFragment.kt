package com.example.myloan.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.myloan.R
import com.example.myloan.presentation.history.view.HistoryFragment
import com.example.myloan.presentation.history.view.HistoryView
import com.example.myloan.presentation.loan.view.LoanFragment
import com.example.myloan.presentation.settings.view.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainFragment : Fragment() {

    lateinit var fragmentTitleTv: TextView
    lateinit var bottomMenu: BottomNavigationView

    companion object {

        fun newInstance() = MainFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView() {
        fragmentTitleTv = view!!.findViewById(R.id.fragment_title)

        fragmentTitleTv.text = getString(R.string.loans_history_title)
        this.childFragmentManager.beginTransaction()
            .add(R.id.fragment_container, HistoryFragment.newInstance())
            .commit()

        bottomMenu = view!!.findViewById(R.id.bottom_menu)
        bottomMenu.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.history_action -> {
                    fragmentTitleTv.text = getString(R.string.loans_history_title)
                    this.childFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, HistoryFragment.newInstance())
                        .commit()
                    true
                }

                R.id.loan_action -> {
                    fragmentTitleTv.text = getString(R.string.loan_title)
                    this.childFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, LoanFragment.newInstance())
                        .commit()
                    true
                }

                R.id.settings_action -> {
                    fragmentTitleTv.text = getString(R.string.settings)
                    this.childFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, SettingsFragment.newInstance())
                        .commit()
                    true
                }

                else -> false
            }
        }
    }
}