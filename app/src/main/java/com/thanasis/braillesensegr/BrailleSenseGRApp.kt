package com.thanasis.braillesensegr

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
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
    Surface(color = MaterialTheme.colorScheme.background) {
        NavHost(navController = navHostController, startDestination = BrailleSenseGRApp.Home.name) {
            composable(BrailleSenseGRApp.Home.name) {
                HomeInit(navHostController, context = LocalContext.current)
            }
            composable(BrailleSenseGRApp.AskForTutorial.name) {
                AskForTutorialInit(navHostController, context = LocalContext.current)
            }
            composable(BrailleSenseGRApp.Tutorial.name) {
                TutorialInit(navHostController, context = LocalContext.current)
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