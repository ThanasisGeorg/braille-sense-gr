package com.thanasis.braillesensegr.ui.components

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import android.view.HapticFeedbackConstants
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.thanasis.braillesensegr.BrailleSenseGRApp
import com.thanasis.braillesensegr.backend.vibrate
import com.thanasis.braillesensegr.ui.theme.Purple40
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun ButtonComp(
    title: String,
    value: String,
    width: Int,
    height: Int,
    color: Color,
    context: Context,
    navHostController: NavHostController,
    duration: Long = 500L
) {
    val haptic = LocalHapticFeedback.current
    val view = LocalView.current

    Button(
        onClick = {
            CoroutineScope(Dispatchers.Main).launch {
                val didVibrate = vibrate(context, duration)
                Log.d(TAG, "vibrate returned: $didVibrate")

                if (!didVibrate) {
                    Log.d(TAG, "native vibrator not available -> using Compose HapticFeedback")
                    try {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                    } catch (e: Exception) {
                        Log.e(TAG, "Compose haptic failed: ${e.message}")
                    }

                    try {
                        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)
                        Log.d(TAG, "view.performHapticFeedback called")
                    } catch (e: Exception) {
                        Log.e(TAG, "view.performHapticFeedback failed: ${e.message}")
                    }
                } else {
                    Log.d(TAG, "native vibrator succeeded")
                }
            }

            when (value) {
                "learn" -> navHostController.navigate(BrailleSenseGRApp.AskForTutorial.name)
                "settings" -> navHostController.navigate(BrailleSenseGRApp.Settings.name)
                "proceed" -> navHostController.navigate(BrailleSenseGRApp.Tutorial.name)
                "begin", "skip" -> navHostController.navigate(BrailleSenseGRApp.Learn.name)
            }

        },
        modifier = Modifier
            .size(width.dp, height.dp)
            .heightIn(48.dp)
            .background(
                color = color,
                shape = RoundedCornerShape(30.dp)
            )
            .fillMaxWidth(),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent)
    ) {
        Box(
            modifier = Modifier
                .heightIn(48.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = title,
                modifier = Modifier.padding(10.dp, 0.dp),
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun ButtonComp_(value: String, navHostController: NavHostController) {
    Button(
        onClick = {
            //navHostController.navigate(BrailleSenseGRApp)
        },
        modifier = Modifier
            .size(120.dp, 60.dp)
            .heightIn(48.dp)
            .background(
                color = Purple40,
                shape = RoundedCornerShape(20.dp)
            )
            .fillMaxWidth(),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent)
    ) {
        Box(
            modifier = Modifier
                .heightIn(48.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = value,
                modifier = Modifier.padding(10.dp, 0.dp),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
fun ButtonCompPreview() {
    ButtonComp_(value = "", navHostController = rememberNavController())
}

