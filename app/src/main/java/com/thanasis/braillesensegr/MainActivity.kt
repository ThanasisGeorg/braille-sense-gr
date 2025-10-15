package com.thanasis.braillesensegr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import com.thanasis.braillesensegr.ui.theme.ThemeManager

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val currentTheme = ThemeManager.getCurrentTheme()
            val darkTheme = isSystemInDarkTheme()
            val navHostController = rememberNavController()
            MaterialTheme {
                MainApp(
                    navHostController,
                    context = LocalContext.current
                )
            }
        }
    }
}