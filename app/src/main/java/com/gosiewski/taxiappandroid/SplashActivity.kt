package com.gosiewski.taxiappandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        loginButton.setOnClickListener({ startActivity(LoginActivity.newInstance(this)) })
        registerButton.setOnClickListener({ startActivity(RegisterActivity.newInstance(this)) })
    }
}
