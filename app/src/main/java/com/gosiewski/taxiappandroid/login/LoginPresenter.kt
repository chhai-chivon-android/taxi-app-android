package com.gosiewski.taxiappandroid.login

import com.gosiewski.taxiappandroid.BasePresenter
import com.gosiewski.taxiappandroid.utils.AuthInfoStorage
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class LoginPresenter @Inject constructor(private val loginDataSource: LoginDataSource,
                                         private val authInfoStorage: AuthInfoStorage)
    : BasePresenter<LoginView>() {

    fun loginAction(username: String, password: String) {
        when {
            username.isEmpty() -> view?.showEmptyUsernameError()
            password.isEmpty() -> view?.showEmptyPasswordError()
            username.length < 3 -> view?.showIncorrectCredentialsError()
            password.length < 8 -> view?.showIncorrectCredentialsError()
            else -> {
                loginDataSource.login(username, password)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                {token: AuthToken ->
                                    authInfoStorage.token = token.access_token

                                    view?.proceedToClientMainView()
                                },
                                {error: Throwable ->
                                    error.printStackTrace()
                                    view?.showGeneralError()
                                })
            }
        }
    }
}