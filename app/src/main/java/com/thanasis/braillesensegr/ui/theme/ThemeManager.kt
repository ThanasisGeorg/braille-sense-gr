package com.thanasis.braillesensegr.ui.theme

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

object ThemeManager {
    private var currentTheme: MutableState<MyTheme> = mutableStateOf(MyTheme.Light)

    fun getCurrentTheme(): MyTheme {
        return currentTheme.value
    }

    fun setTheme(theme: MyTheme) {
        currentTheme.value = theme
        Log.d("ThemeManager", "Current theme set to: $theme")
    }
}

sealed class MyTheme {
    data object Light : MyTheme()
    data object Dark : MyTheme()
}