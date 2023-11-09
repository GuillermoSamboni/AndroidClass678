package com.gsamdev.primeraaplicacion.data

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesManager(private var context: Context) {

    private val nameDatabase = "ME_DATABASE"

    private val sharedPreferences: SharedPreferences by lazy {
        context.getSharedPreferences(nameDatabase, Context.MODE_PRIVATE)
    }

    fun savePref(key: String, value: Any) {
        val editor = sharedPreferences.edit()
        when (value) {
            is String -> editor.putString(key, value)
            is Int -> editor.putInt(key, value)
            is Boolean -> editor.putBoolean(key, value)
            is Float -> editor.putFloat(key, value)
            is Long -> editor.putLong(key, value)
            else -> throw IllegalArgumentException("El valor no es valido")
        }
        editor.apply()
    }

    fun getPref(key: String, defaultValue: Any): Any {
        val sharedPreferences = context.getSharedPreferences(nameDatabase, Context.MODE_PRIVATE)
        return when (defaultValue) {
            is String -> sharedPreferences.getString(key, defaultValue)
            is Int -> sharedPreferences.getInt(key, defaultValue)
            is Boolean -> sharedPreferences.getBoolean(key, defaultValue)
            is Float -> sharedPreferences.getFloat(key, defaultValue)
            is Long -> sharedPreferences.getLong(key, defaultValue)
            else -> throw IllegalArgumentException("No se encontro en la base datos")
        }!!
    }

    fun removeSharedPref(key: String) {
        val editor = sharedPreferences.edit()
        editor.remove(key)
        editor.apply()
    }

}