package com.thanasis.braillesensegr.ui.screens

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.thanasis.braillesensegr.R
import com.thanasis.braillesensegr.backend.TitleVoice
import com.thanasis.braillesensegr.ui.components.HeadingText

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SettingsInit(navHostController: NavHostController){
    TitleVoice(stringResource(R.string.settingsVoiceText))

    Scaffold {
        Column(
            Modifier
                .fillMaxSize()
                .padding(18.dp, 0.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(100.dp))
            HeadingText("Ρυθμίσεις")
        }
    }
    /*Scaffold {
        Column(
            Modifier
                .fillMaxSize()
                .padding(18.dp, 77.dp)
        ) {
            Spacer(modifier = Modifier.padding(5.dp))
            //CategoryIndicator(category = "theme", textSize = 25)
            HorizontalDivider()
            Spacer(modifier = Modifier.padding(0.dp, 5.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                //CategoryIndicator(category = "dark", textSize = 15)
                Spacer(modifier = Modifier.padding(5.dp, 10.dp))
                /*
                ThemeSwitch(
                    navHostController = navHostController,
                    size = 40.dp,
                    padding = 5.dp,
                    userLoggedIn = userLoggedIn,
                    roomDb = roomDb
                )
                Spacer(modifier = Modifier.padding(5.dp, 0.dp))
                CategoryIndicator(category = "light", textSize = 15)
                */
            }

            Spacer(modifier = Modifier.padding(10.dp))

            //CategoryIndicator(category = "security", textSize = 25)
            HorizontalDivider()
            Spacer(modifier = Modifier.padding(0.dp, 5.dp))
            ButtonComp_("Change password", navHostController)
        }
    }*/
}