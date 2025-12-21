package com.thanasis.braillesensegr

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.thanasis.braillesensegr.ui.screens.AskForTutorialInit
import com.thanasis.braillesensegr.ui.screens.HomeInit
import com.thanasis.braillesensegr.ui.screens.LearnInit
import com.thanasis.braillesensegr.ui.screens.SettingsInit
import com.thanasis.braillesensegr.ui.screens.TutorialInit

enum class BrailleSenseGRApp(val title: Int) {
    Home(title = R.string.app_name),
    AskForTutorial(title = R.string.tutorial),
    Tutorial(title = R.string.tutorial),
    Learn(title = R.string.learn),
    Settings(title = R.string.settings)
}

@Composable
fun MainApp(navHostController: NavHostController) {
    var isEnabled by rememberSaveable { mutableStateOf(true) }
    Surface(color = MaterialTheme.colorScheme.background) {
        NavHost(navController = navHostController, startDestination = BrailleSenseGRApp.Home.name) {
            composable(BrailleSenseGRApp.Home.name) {
                HomeInit(navHostController, context = LocalContext.current, isEnabled)
            }
            composable(BrailleSenseGRApp.AskForTutorial.name) {
                AskForTutorialInit(navHostController, context = LocalContext.current, isEnabled)
            }
            composable(BrailleSenseGRApp.Tutorial.name) {
                TutorialInit(navHostController, context = LocalContext.current, isEnabled)
            }
            composable(BrailleSenseGRApp.Learn.name) {
                LearnInit(navHostController, isEnabled)
            }
            composable(BrailleSenseGRApp.Settings.name) {
                SettingsInit(navHostController, isEnabled) { isEnabled = it }
            }
        }
    }
}