package com.gsamdev.primeraaplicacion.data

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesManager(private var context: Context) {

    private val nameDatabase = "ME_DATABASE"

    private val sharedPreferences: SharedPreferences by lazy {
        context.getSharedPreferences(nameDatabase, Context.MODE_PRIVATE)
    }

    fun saveUser(user: String) {
        val editor = sharedPreferences.edit()
        editor.putString("keyUserPref", user)
        editor.apply()
    }

    fun saveBoolean() {
        val editor = sharedPreferences.edit()
        editor.putBoolean("meBoolean", true)
        editor.apply()
    }

    fun getUser(): String {
        return sharedPreferences.getString("keyUserPref", "Empty").toString()
    }

    fun getBoolean(): Boolean {
        return sharedPreferences.getBoolean("meBoolean", false)
    }


}