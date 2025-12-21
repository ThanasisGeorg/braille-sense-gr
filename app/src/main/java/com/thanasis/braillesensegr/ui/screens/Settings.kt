package com.thanasis.braillesensegr.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.thanasis.braillesensegr.R
import com.thanasis.braillesensegr.backend.TitleVoice
import com.thanasis.braillesensegr.ui.components.HeadingText
import com.thanasis.braillesensegr.ui.components.NormalText
import com.thanasis.braillesensegr.ui.components.ReturnFloatingButton
import com.thanasis.braillesensegr.ui.components.TTSwitch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SettingsInit(
    navHostController: NavHostController,
    isEnabled: Boolean,
    onCheckedChanged: (Boolean) -> Unit
) {
    TitleVoice(stringResource(R.string.settingsVoiceText), isEnabled)
    Scaffold {
        Column() {
            Spacer(modifier = Modifier.height(40.dp))
            ReturnFloatingButton(
                navHostController = navHostController,
                context = LocalContext.current
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp, 0.dp)
            ) {
                Spacer(modifier = Modifier.height(10.dp))
                HeadingText(stringResource(R.string.settings), 40, TextAlign.Center)
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Spacer(modifier = Modifier.height(5.dp))
                    TTSwitch(
                        isEnabled = isEnabled,
                        onCheckedChanged = onCheckedChanged
                    )
                    NormalText(
                        if (isEnabled)
                            "Η λειτουργία Κείμενο σε Ομιλία είναι ενεργοποιημένη"
                        else
                            "Η λειτουργία Κείμενο σε Ομιλία είναι απενεργοποιημένη",
                        TextAlign.Center,
                        30
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun SettingsInitPreview() {
    SettingsInit(navHostController = rememberNavController(), isEnabled = true, onCheckedChanged = {})
}