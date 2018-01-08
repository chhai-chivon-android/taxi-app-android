package com.gosiewski.taxiappandroid.utils

interface AuthInfoStorage {
    var token: String
    val isUserLogged: Boolean
    fun clear()
}