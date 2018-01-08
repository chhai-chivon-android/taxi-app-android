package com.gosiewski.taxiappandroid.register

import com.gosiewski.taxiappandroid.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class RegisterPresenter @Inject constructor(private val registerDataSource: RegisterDataSource)
    : BasePresenter<RegisterView>() {

        fun register(username: String, password: String, repassword: String) {
            when {
                username.length < 3 -> view?.showUsernameTooShortError()
                password.length < 8 -> view?.showPasswordTooShortError()
                password != repassword -> view?.showRepasswordDoesNotMatchError()
                else -> {
                    registerDataSource.register(username, password)
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe({
                                view?.showRegistrationSucceed()
                                view?.proceedToSplash()
                            }, {error -> error.printStackTrace()})
                }
            }
        }
}