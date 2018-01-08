package com.gosiewski.taxiappandroid.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.gosiewski.taxiappandroid.Application
import com.gosiewski.taxiappandroid.R
import com.gosiewski.taxiappandroid.client.ClientMainActivity
import com.gosiewski.taxiappandroid.driver.DriverMainActivity
import com.gosiewski.taxiappandroid.utils.toast
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : AppCompatActivity(), LoginView {
    @Inject lateinit var presenter: LoginPresenter

    companion object {
        fun newInstance(context: Context) : Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        (application as Application).getComponent(applicationContext).inject(this)
        presenter.bindView(this)

        proceedButton.setOnClickListener { presenter.loginAction(usernameEditText.text.toString(),
                passwordEditText.text.toString(), driverSwitch.isActivated) }
    }

    override fun showEmptyUsernameError() {
        baseContext.toast("Username cannot be empty")
    }

    override fun showEmptyPasswordError() {
        baseContext.toast("Password cannot be empty")
    }

    override fun showIncorrectCredentialsError() {
        baseContext.toast("Incorrect credentials")
    }

    override fun showGeneralError() {
        baseContext.toast("Oups, something went wrong!")
    }

    override fun proceedToDriverMainView() {
        startActivity(DriverMainActivity.newInstance(this))
        finish()
    }

    override fun proceedToClientMainView() {
        startActivity(ClientMainActivity.newInstance(this))
        finish()
    }
}
