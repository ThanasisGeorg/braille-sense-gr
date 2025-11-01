package com.thanasis.braillesensegr.ui.screens

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.getString
import androidx.core.text.HtmlCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.thanasis.braillesensegr.R
import com.thanasis.braillesensegr.backend.TitleVoice
import com.thanasis.braillesensegr.ui.components.ButtonComp
import com.thanasis.braillesensegr.ui.components.HeadingText
import com.thanasis.braillesensegr.ui.components.NormalText
import com.thanasis.braillesensegr.ui.components.ReturnFloatingButton
import com.thanasis.braillesensegr.ui.theme.CelticBlue

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TutorialInit(navHostController: NavHostController, context: Context) {
    var text: String
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
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(10.dp)
                        .height(530.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    HeadingText("Εισαγωγή", 20, TextAlign.Start)
                    text = HtmlCompat.fromHtml(
                        getString(LocalContext.current, R.string.eisagogi),
                        HtmlCompat.FROM_HTML_MODE_LEGACY
                    ).toString()
                    NormalText(
                        value = text,
                        textAlign = TextAlign.Start,
                        fontSize = 18
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    HeadingText("Προσανατολισμός οθόνης", 20, TextAlign.Start)
                    text = HtmlCompat.fromHtml(
                        getString(LocalContext.current, R.string.prosanatolismosOthonhs),
                        HtmlCompat.FROM_HTML_MODE_LEGACY
                    ).toString()
                    NormalText(
                        value = text,
                        textAlign = TextAlign.Start,
                        fontSize = 18
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    HeadingText("Τοποθέτηση δακτύλων", 20, TextAlign.Start)
                    text = HtmlCompat.fromHtml(
                        getString(LocalContext.current, R.string.topothetisiDaxtilon),
                        HtmlCompat.FROM_HTML_MODE_LEGACY
                    ).toString()
                    NormalText(
                        value = text,
                        textAlign = TextAlign.Start,
                        fontSize = 18
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    HeadingText("Πλοήγηση μεταξύ γραμμάτων", 20, TextAlign.Start)
                    text = HtmlCompat.fromHtml(
                        getString(LocalContext.current, R.string.plohgisiMetaksiGrammatwn),
                        HtmlCompat.FROM_HTML_MODE_LEGACY
                    ).toString()
                    NormalText(
                        value = text,
                        textAlign = TextAlign.Start,
                        fontSize = 18
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    HeadingText("Πως να αισθανθείς τη διάταξη", 20, TextAlign.Start)
                    text = HtmlCompat.fromHtml(
                        getString(LocalContext.current, R.string.aisthisiDiataksis),
                        HtmlCompat.FROM_HTML_MODE_LEGACY
                    ).toString()
                    NormalText(
                        value = text,
                        textAlign = TextAlign.Start,
                        fontSize = 18
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    text = HtmlCompat.fromHtml(
                        getString(LocalContext.current, R.string.epistrofh),
                        HtmlCompat.FROM_HTML_MODE_LEGACY
                    ).toString()
                    NormalText(
                        value = text,
                        textAlign = TextAlign.Start,
                        fontSize = 18
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    HeadingText("Πάτησε στο κάτω μέρος της οθόνης για να ξεκινήσεις την εκμάθηση", 24, TextAlign.Center)
                }
                ButtonComp(
                    stringResource(id = R.string.begin),
                    "begin",
                    400,
                    170,
                    CelticBlue,
                    context,
                    navHostController
                )
            }
        }
    }
}

@Preview
@Composable
fun TutorialPreview() {
    TutorialInit(navHostController = rememberNavController(), context = LocalContext.current)
}