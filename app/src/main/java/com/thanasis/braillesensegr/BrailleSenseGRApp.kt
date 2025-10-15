package com.thanasis.braillesensegr

import android.content.Context
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.thanasis.braillesensegr.ui.screens.HomeInit
import com.thanasis.braillesensegr.ui.screens.LearnInit
import com.thanasis.braillesensegr.ui.screens.SettingsInit

enum class BrailleSenseGRApp(val title: Int) {
    Home(title = R.string.app_name),
    Learn(title = R.string.learn),
    Settings(title = R.string.settings)
}

@Composable
fun MainApp(navHostController: NavHostController, context: Context) {
    Surface(color = MaterialTheme.colorScheme.background) {
        NavHost(navController = navHostController, startDestination = BrailleSenseGRApp.Home.name) {
            composable(BrailleSenseGRApp.Home.name) {
                HomeInit(navHostController, context = LocalContext.current)
            }
            composable(BrailleSenseGRApp.Learn.name) {
                LearnInit(navHostController)
            }
            composable(BrailleSenseGRApp.Settings.name) {
                SettingsInit(navHostController)
            }
        }
    }
}