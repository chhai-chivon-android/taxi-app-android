package com.gosiewski.taxiappandroid.register

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.gosiewski.taxiappandroid.Application
import com.gosiewski.taxiappandroid.R
import com.gosiewski.taxiappandroid.utils.toast
import kotlinx.android.synthetic.main.activity_register.*
import javax.inject.Inject

class RegisterActivity : AppCompatActivity(), RegisterView {
    @Inject lateinit var presenter: RegisterPresenter

    companion object {
        fun newInstance(context: Context) : Intent {
            return Intent(context, RegisterActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        (application as Application).getComponent(applicationContext).inject(this)
        presenter.bindView(this)

        proceedButton.setOnClickListener({ presenter.register(usernameEditText.text.toString(), passwordEditText.text.toString(), repasswordEditText.text.toString()) })
    }

    override fun showUsernameTooShortError() {
        toast("Username is too short")
    }

    override fun showPasswordTooShortError() {
        toast("Password is too short")
    }

    override fun showRepasswordDoesNotMatchError() {
        toast("Passwords does not match")
    }

    override fun showRegistrationSucceed() {
        toast("User registered!")
    }

    override fun proceedToSplash() {
        finish()
    }
}
