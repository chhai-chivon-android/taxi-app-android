package com.gosiewski.taxiappandroid.splash

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.gosiewski.taxiappandroid.R
import com.gosiewski.taxiappandroid.login.LoginActivity
import com.gosiewski.taxiappandroid.register.RegisterActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        loginButton.setOnClickListener({ startActivity(LoginActivity.newInstance(this)) })
        registerButton.setOnClickListener({ startActivity(RegisterActivity.newInstance(this)) })
    }
}
