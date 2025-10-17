package com.thanasis.braillesensegr.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import com.thanasis.braillesensegr.ui.components.NextFloatingButton
import com.thanasis.braillesensegr.ui.components.NormalText
import com.thanasis.braillesensegr.ui.components.ReturnFloatingButton
import com.thanasis.braillesensegr.ui.components.ReturnIconButton

val letters = listOf(
    "(Άλφα)",
    "(Βήτα)",
    "(Γάμμα)",
    "(Δέλτα)",
    "(Έψιλον)",
    "(Ζήτα)",
    "(Ήτα)",
    "(Θήτα)",
    "(Ιώτα)",
    "(Κάππα)",
    "(Λάμδα)",
    "(Μι)",
    "(Νι)",
    "(Ξι)",
    "(Όμικρον)",
    "(Πι)",
    "(Ρο)",
    "(Σίγμα)",
    "(Ταφ)",
    "(Ύψιλον)",
    "(Φι)",
    "(Χι)",
    "(Ψι)",
    "(Ωμέγα)"
)

@Composable
fun DrawGreekBrailleLetter(currentIndex: Int) {
    when(letters[currentIndex]) {
        "(Άλφα)" -> {
            Text(text = letters[currentIndex])
        }
        "(Βήτα)" -> {
            Text(text = letters[currentIndex])
        }
        "(Γάμμα)" -> {
            Text(text = letters[currentIndex])
        }
        "(Δέλτα)" -> {
            Text(text = letters[currentIndex])
        }
        "(Έψιλον)" -> {
            Text(text = letters[currentIndex])
        }
        "(Ζήτα)" -> {
            Text(text = letters[currentIndex])
        }
        "(Ήτα)" -> {
            Text(text = letters[currentIndex])
        }
        "(Θήτα)" -> {
            Text(text = letters[currentIndex])
        }
        "(Ιώτα)" -> {
            Text(text = letters[currentIndex])
        }
        "(Κάππα)" -> {
            Text(text = letters[currentIndex])
        }
        "(Λάμδα)" -> {
            Text(text = letters[currentIndex])
        }
        "(Μι)" -> {
            Text(text = letters[currentIndex])
        }
        "(Νι)" -> {
            Text(text = letters[currentIndex])
        }
        "(Ξι)" -> {
            Text(text = letters[currentIndex])
        }
        "(Όμικρον)" -> {
            Text(text = letters[currentIndex])
        }
        "(Πι)" -> {
            Text(text = letters[currentIndex])
        }
        "(Ρο)" -> {
            Text(text = letters[currentIndex])
        }
        "(Σίγμα)" -> {
            Text(text = letters[currentIndex])
        }
        "(Ταφ)" -> {
            Text(text = letters[currentIndex])
        }
        "(Ύψιλον)" -> {
            Text(text = letters[currentIndex])
        }
        "(Φι)" -> {
            Text(text = letters[currentIndex])
        }
        "(Χι)" -> {
            Text(text = letters[currentIndex])
        }
        "(Ψι)" -> {
            Text(text = letters[currentIndex])
        }
        "(Ωμέγα)" -> {
            Text(text = letters[currentIndex])
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LearnInit(navHostController: NavHostController) {
    val context = LocalContext.current
    var currentIndex by remember { mutableStateOf(0) }

    //TitleVoice(stringResource(R.string.learnVoiceText))
    Scaffold {
        Column {
            Spacer(modifier = Modifier.height(40.dp))
            ReturnFloatingButton(
                navHostController = navHostController,
                context = context
            )
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(10.dp, 0.dp)
            ) {
                Spacer(modifier = Modifier.height(10.dp))
                HeadingText(stringResource(R.string.learn))
                //Spacer(modifier = Modifier.height(50.dp))
                Column(
                    Modifier
                        .fillMaxWidth()
                        .height(450.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    DrawGreekBrailleLetter(currentIndex)
                }
                NormalText(
                    value = letters[currentIndex],
                    textAlign = TextAlign.Center,
                    fontSize = 50
                )
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    NextFloatingButton(
                        onNext = {
                            currentIndex = (currentIndex + 1) % letters.size
                        },
                        context = context
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun LearnInitPreview() {
    LearnInit(navHostController = rememberNavController())
}