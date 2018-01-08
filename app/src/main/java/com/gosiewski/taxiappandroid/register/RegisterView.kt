package com.gosiewski.taxiappandroid.register

interface RegisterView {
    fun showUsernameTooShortError()
    fun showPasswordTooShortError()
    fun showRepasswordDoesNotMatchError()
    fun showRegistrationSucceed()
    fun proceedToSplash()
}