package com.example.myloan.presentation.auth.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.myloan.R
import com.example.myloan.presentation.auth.presenter.AuthPresenter
import com.example.myloan.presentation.auth.presenter.AuthPresenterFactory
import com.example.myloan.presentation.main.MainFragment
import com.google.android.material.textfield.TextInputLayout


class AuthFragment : Fragment(), AuthView {

    lateinit var presenter: AuthPresenter

    lateinit var userNameTil: TextInputLayout
    lateinit var passwordTil: TextInputLayout

    lateinit var signInBtn: Button
    lateinit var signUpBtn: Button

    companion object {
        fun newInstance() = AuthFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        presenter = AuthPresenterFactory.createPresenter(requireContext())
        presenter.onAttachView(this)

        return inflater.inflate(R.layout.fragment_auth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }


    private fun initView() {
        userNameTil = view!!.findViewById(R.id.username_til)
        passwordTil = view!!.findViewById(R.id.password_til)

        signInBtn = view!!.findViewById(R.id.sign_in_btn)
        signInBtn.setOnClickListener {
            presenter.signIn(
                userNameTil.editText!!.text.toString(),
                passwordTil.editText!!.text.toString()
            )
        }
        signUpBtn = view!!.findViewById(R.id.sign_up_btn)
        signUpBtn.setOnClickListener {
            presenter.signUp(
                userNameTil.editText!!.text.toString(),
                passwordTil.editText!!.text.toString()
            )
        }
    }

    override fun startApp() {
        Log.e("Test", "Start app")
        fragmentManager!!.beginTransaction()
            .add(R.id.fragment_container, MainFragment.newInstance()).commit()
    }

    override fun saveToken(token: String) {
        context!!.getSharedPreferences("main", Context.MODE_PRIVATE).edit().putString("token", token).apply()
    }
}