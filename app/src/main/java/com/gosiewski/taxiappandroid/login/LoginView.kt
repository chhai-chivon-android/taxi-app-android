package com.gosiewski.taxiappandroid.login

interface LoginView {
    fun showGeneralError()
    fun showEmptyUsernameError()
    fun showEmptyPasswordError()
    fun showIncorrectCredentialsError()

    fun proceedToDriverMainView()
    fun proceedToClientMainView()
}