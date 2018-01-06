package com.gosiewski.taxiappandroid

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class RegisterActivity : AppCompatActivity() {

    companion object {
        fun newInstance(context: Context) : Intent {
            return Intent(context, RegisterActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }
}
