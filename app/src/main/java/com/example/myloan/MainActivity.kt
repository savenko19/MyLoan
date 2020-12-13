package com.example.myloan

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myloan.presentation.auth.view.AuthFragment
import com.example.myloan.presentation.main.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onResume() {
        super.onResume()
        Log.e("Test", "TOKEN: ${getSharedPreferences("main", MODE_PRIVATE).getString("token", null)}")
        if (getSharedPreferences("main", MODE_PRIVATE).getString("token", null) == null) {
            Log.e("Test", "============AUTH===============")
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, AuthFragment.newInstance())
                .commit()
        } else {
            Log.e("Test", "============MAIN===============")
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, MainFragment.newInstance())
                .commit()
        }
    }
}