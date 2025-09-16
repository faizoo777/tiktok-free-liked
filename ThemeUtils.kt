package com.farooqking.app

import android.content.Context
import androidx.appcompat.app.AppCompatDelegate

object ThemeUtils {
    private const val PREFS = "fk_prefs"
    private const val KEY_DARK = "fk_dark"
    private const val KEY_LIGHT_ON = "fk_light_on"

    fun applySavedTheme(context: Context) {
        val prefs = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        val dark = prefs.getBoolean(KEY_DARK, false)
        applyTheme(dark)
    }

    fun applyTheme(dark: Boolean) {
        AppCompatDelegate.setDefaultNightMode(if (dark) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO)
    }

    fun saveTheme(context: Context, dark: Boolean) {
        val prefs = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        prefs.edit().putBoolean(KEY_DARK, dark).apply()
    }

    fun saveLightState(context: Context, on: Boolean) {
        val prefs = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        prefs.edit().putBoolean(KEY_LIGHT_ON, on).apply()
    }

    fun isDarkTheme(context: Context): Boolean {
        val prefs = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        return prefs.getBoolean(KEY_DARK, false)
    }

    fun isLightOn(context: Context): Boolean {
        val prefs = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        return prefs.getBoolean(KEY_LIGHT_ON, true)
    }
}
