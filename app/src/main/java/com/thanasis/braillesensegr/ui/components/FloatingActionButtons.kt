package com.thanasis.braillesensegr.ui.components

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import android.view.HapticFeedbackConstants
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.thanasis.braillesensegr.BrailleSenseGRApp
import com.thanasis.braillesensegr.R
import com.thanasis.braillesensegr.backend.vibrate
import com.thanasis.braillesensegr.ui.theme.CelticBlue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.w3c.dom.Text

@Composable
fun ReturnFloatingButton(
    navHostController: NavHostController,
    context: Context,
    duration: Long = 150L
) {
    val haptic = LocalHapticFeedback.current
    val view = LocalView.current

    FloatingActionButton(
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

            navHostController.navigate(BrailleSenseGRApp.Home.name)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        containerColor = CelticBlue,
    ) {
        Text(
            text = "Επιστροφή",
            color = Color.White,
            style = TextStyle(
                fontSize = 20.sp
            )
        )
    }
}

@Composable
fun NextFloatingButton(
    onNext: () -> Unit,
    context: Context,
    fontSize: Int,
    width: Int,
    height: Int,
    padding: Int,
    duration: Long = 500L
) {
    val haptic = LocalHapticFeedback.current
    val view = LocalView.current

    ExtendedFloatingActionButton(
        text = {
            Text(
                text = "Επόμενο",
                color = Color.White,
                style = TextStyle(
                    fontSize = fontSize.sp
                )
            )
        },
        icon = {
            /*Icon(
                Icons.AutoMirrored.Filled.KeyboardArrowRight,
                "Floating action button.",
                tint = Color.White,
                modifier = Modifier.size(40.dp)
            )*/
        },
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
            onNext()
        },
        modifier = Modifier
            .size(width.dp, height.dp)
            .padding(padding.dp),
        containerColor = CelticBlue
    )
}

@Composable
fun PreviousFloatingButton(
    onPrevious: () -> Unit,
    context: Context,
    fontSize: Int,
    width: Int,
    height: Int,
    padding: Int,
    duration: Long = 500L
) {
    val haptic = LocalHapticFeedback.current
    val view = LocalView.current

    ExtendedFloatingActionButton(
        text = {
            Text(
                text = "Προηγούμενο",
                color = Color.White,
                style = TextStyle(
                    fontSize = fontSize.sp
                )
            )
        },
        icon = {
            /*Icon(
                Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                "Floating action button.",
                tint = Color.White,
                modifier = Modifier.size(40.dp)
            )*/
        },
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
            onPrevious()
        },
        modifier = Modifier
            .size(width.dp, height.dp)
            .padding(padding.dp),
        containerColor = CelticBlue
    )
}

@Preview
@Composable
fun FloatingButtonPreview() {
    NextFloatingButton(
        onNext = {},
        context = LocalContext.current,
        fontSize = 30,
        width = 300,
        height = 150,
        padding = 10
    )
}