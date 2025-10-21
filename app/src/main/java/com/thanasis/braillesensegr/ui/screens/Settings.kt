package com.thanasis.braillesensegr.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.thanasis.braillesensegr.R
import com.thanasis.braillesensegr.ui.components.HeadingText
import com.thanasis.braillesensegr.ui.components.ReturnFloatingButton

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SettingsInit(navHostController: NavHostController){
    //TitleVoice(stringResource(R.string.settingsVoiceText))
    Scaffold {
        Column {
            Spacer(modifier = Modifier.height(40.dp))
            ReturnFloatingButton(
                navHostController = navHostController,
                context = LocalContext.current
            )
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(10.dp, 0.dp)
            ) {
                Spacer(modifier = Modifier.height(10.dp))
                HeadingText(stringResource(R.string.settings))
            }
        }
    }
}

@Preview
@Composable
fun SettingsInitPreview() {
    SettingsInit(navHostController = rememberNavController())
}