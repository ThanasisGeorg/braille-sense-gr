package com.thanasis.braillesensegr.ui.screens

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
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
import com.thanasis.braillesensegr.ui.components.ButtonComp
import com.thanasis.braillesensegr.ui.components.NormalText
import com.thanasis.braillesensegr.ui.components.ReturnFloatingButton
import com.thanasis.braillesensegr.ui.theme.CelticBlue
import com.thanasis.braillesensegr.ui.theme.Gray_

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AskForTutorialInit(navHostController: NavHostController, context: Context) {
    TitleVoice(stringResource(R.string.askForTutorialVoiceText))
    Scaffold {
        Column {
            Spacer(modifier = Modifier.height(40.dp))
            ReturnFloatingButton(
                navHostController = navHostController,
                context = context
            )
            Column(
                modifier = Modifier.padding(10.dp)
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                NormalText(
                    value = stringResource(id = R.string.infoAboutTutorial),
                    textAlign = TextAlign.Center,
                    fontSize = 25
                )
                Spacer(modifier = Modifier.height(50.dp))
                ButtonComp(
                    stringResource(id = R.string.proceed),
                    "proceed",
                    500,
                    250,
                    CelticBlue,
                    context,
                    navHostController
                )
                Spacer(modifier = Modifier.height(30.dp))
                ButtonComp(
                    stringResource(id = R.string.skip),
                    "skip",
                    500,
                    250,
                    Gray_,
                    context,
                    navHostController
                )
            }
        }
    }
}

@Preview
@Composable
fun AskForTutorialPreview() {
    AskForTutorialInit(navHostController = rememberNavController(), context = LocalContext.current)
}