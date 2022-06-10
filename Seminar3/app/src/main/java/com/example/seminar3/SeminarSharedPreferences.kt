package com.example.seminar3

import android.content.Context

object SeminarSharedPreferences {
    private const val STORAGE_KEY = "USER_AUTH"
    private const val AUTO_LOGIN = "AUTO_LOGIN"

    fun getAutoLogin(context: Context): Boolean {
        return context.getSharedPreferences(STORAGE_KEY, Context.MODE_PRIVATE)
            .getBoolean(AUTO_LOGIN, false)
    }

    fun setAutoLogin(context: Context, value: Boolean) {
        context.getSharedPreferences(STORAGE_KEY, Context.MODE_PRIVATE).edit()
            .putBoolean(AUTO_LOGIN, value)
            .apply()
    }

    fun setLogout(context: Context):Boolean {
        context.getSharedPreferences(STORAGE_KEY, Context.MODE_PRIVATE).edit()
            .remove(AUTO_LOGIN)
            .clear()
            .apply()

        return context.getSharedPreferences(STORAGE_KEY, Context.MODE_PRIVATE)
            .getBoolean(AUTO_LOGIN, false)
    }
}