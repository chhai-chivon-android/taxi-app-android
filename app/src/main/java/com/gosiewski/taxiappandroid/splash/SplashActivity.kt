package com.gosiewski.taxiappandroid.splash

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.gosiewski.taxiappandroid.Application
import com.gosiewski.taxiappandroid.R
import com.gosiewski.taxiappandroid.client.ClientMainActivity
import com.gosiewski.taxiappandroid.login.LoginActivity
import com.gosiewski.taxiappandroid.register.RegisterActivity
import com.gosiewski.taxiappandroid.utils.AuthInfoStorage
import kotlinx.android.synthetic.main.activity_splash.*
import javax.inject.Inject

class SplashActivity: AppCompatActivity() {
    @Inject lateinit var authInfoStorage: AuthInfoStorage

    companion object {
        fun newInstance(context: Context): Intent {
            val intent = Intent(context, SplashActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        (application as Application).getComponent(applicationContext).inject(this)

        if (authInfoStorage.isUserLogged) {
            startActivity(ClientMainActivity.newInstance(this))
            finish()
        }

        loginButton.setOnClickListener({ startActivity(LoginActivity.newInstance(this)) })
        registerButton.setOnClickListener({ startActivity(RegisterActivity.newInstance(this)) })
    }
}
