package com.gosiewski.taxiappandroid.driver

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.gosiewski.taxiappandroid.R

class DriverMainActivity : AppCompatActivity(), DriverMainView {

    companion object {
        fun newInstance(context: Context) : Intent {
            return Intent(context, DriverMainActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_driver_main)
    }
}
