package com.example.myloan.presentation.settings.view

import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.myloan.R

class SettingsFragment : Fragment() {

    lateinit var logOutBtn: Button

    companion object {

        fun newInstance() = SettingsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView() {
        logOutBtn = view!!.findViewById(R.id.log_out_btn)
        logOutBtn.setOnClickListener {
            context!!.getSharedPreferences("main", MODE_PRIVATE).edit().putString("token", null).apply()
            activity!!.recreate()
        }
    }
}