package com.thanasis.braillesensegr.ui.screens

import android.annotation.SuppressLint
import android.content.Context
import android.speech.tts.TextToSpeech
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thanasis.braillesensegr.R
import androidx.navigation.NavHostController
import com.thanasis.braillesensegr.backend.RememberTTS
import com.thanasis.braillesensegr.backend.TitleVoice
import com.thanasis.braillesensegr.ui.components.ButtonComp
import com.thanasis.braillesensegr.ui.components.HeadingText

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeInit(navHostController: NavHostController, context: Context){
    TitleVoice(stringResource(R.string.welcomeVoiceText))
    Scaffold {
        Column(
            Modifier
                .fillMaxSize()
                .padding(18.dp, 0.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(100.dp))
            HeadingText("Καλωσήρθες στο BrailleSense GR")
            Spacer(modifier = Modifier.height(100.dp))
            ButtonComp(stringResource(id = R.string.learn), "home", 500, 250,  context, navHostController)
            Spacer(modifier = Modifier.height(50.dp))
            ButtonComp(stringResource(id = R.string.settings), "settings", 500, 250,  context, navHostController)
        }
    }
}

@Preview
@Composable
fun HomeInitPreview() {
    //HomeInit(navHostController = rememberNavController(), value = "Home")
}