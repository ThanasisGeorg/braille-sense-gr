package com.thanasis.braillesensegr.ui.screens

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
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
import com.thanasis.braillesensegr.ui.components.ButtonComp
import com.thanasis.braillesensegr.ui.components.NormalText
import com.thanasis.braillesensegr.ui.components.ReturnFloatingButton
import com.thanasis.braillesensegr.ui.theme.CelticBlue

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TutorialInit(navHostController: NavHostController, context: Context) {
    TitleVoice(stringResource(R.string.tutorialVoiceText))
    Scaffold {
        Column {
            Spacer(modifier = Modifier.height(40.dp))
            ReturnFloatingButton(
                navHostController = navHostController,
                context = context
            )
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxHeight(),
            ) {
                NormalText(
                    stringResource(id = R.string.tutorial1),
                    textAlign = TextAlign.Start,
                    fontSize = 18
                )
                Spacer(modifier = Modifier.height(10.dp))
                NormalText(
                    stringResource(id = R.string.tutorial2),
                    textAlign = TextAlign.Start,
                    fontSize = 18
                )
                Spacer(modifier = Modifier.height(10.dp))
                NormalText(
                    stringResource(id = R.string.tutorial3),
                    textAlign = TextAlign.Start,
                    fontSize = 18
                )
                Row(
                    modifier = Modifier.fillMaxHeight(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    ButtonComp(
                        stringResource(id = R.string.begin),
                        "begin",
                        400,
                        100,
                        CelticBlue,
                        context,
                        navHostController
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun TutorialPreview() {
    TutorialInit(navHostController = rememberNavController(), context = LocalContext.current)
}