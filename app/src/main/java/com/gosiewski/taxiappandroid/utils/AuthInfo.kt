package com.gosiewski.taxiappandroid.utils

import android.content.Context


class AuthInfo(private val context: Context) : AuthInfoStorage {

    override var token: String
        get() = context.getSharedPreferences(AUTH_SHARED_PREFERENCES_KEY, Context.MODE_PRIVATE)
                .getString(AUTH_TOKEN, null)
        set(token) {
            context.getSharedPreferences(AUTH_SHARED_PREFERENCES_KEY, Context.MODE_PRIVATE)
                    .edit()
                    .putString(AUTH_TOKEN, token)
                    .apply()
        }

    override val isUserLogged: Boolean
        get() = context.getSharedPreferences(AUTH_SHARED_PREFERENCES_KEY, Context.MODE_PRIVATE)
                .getString(AUTH_TOKEN, null) != null

    override fun clear() {
        context.getSharedPreferences(AUTH_SHARED_PREFERENCES_KEY, Context.MODE_PRIVATE)
                .edit()
                .clear()
                .apply()
    }

    companion object {
        private val AUTH_SHARED_PREFERENCES_KEY = "authInfo.auth"
        private val AUTH_TOKEN = "token"
    }
}