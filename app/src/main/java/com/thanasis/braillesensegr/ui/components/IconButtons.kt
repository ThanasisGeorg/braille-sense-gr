package com.thanasis.braillesensegr.ui.components

import android.content.ContentValues.TAG
import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import android.util.Log
import android.view.HapticFeedbackConstants
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.thanasis.braillesensegr.R
import com.thanasis.braillesensegr.backend.vibrate
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeoutOrNull

fun vibrateOnce(context: Context, durationMs: Long = 40L) {
    try {
        val vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val vm = context.getSystemService(VibratorManager::class.java)
            vm?.defaultVibrator
        } else {
            @Suppress("DEPRECATION")
            context.getSystemService(Context.VIBRATOR_SERVICE) as? Vibrator
        }

        vibrator?.vibrate(
            VibrationEffect.createOneShot(
                durationMs,
                VibrationEffect.DEFAULT_AMPLITUDE
            )
        )

    } catch (e: Exception) {
        Log.e("Vibrate", "Failed to vibrate", e)
    }
}



@Composable
fun DotIconButton(context: Context, isEnabled: Boolean, duration: Long = 40L) {
    var isHovered by remember { mutableStateOf(false) }
    val haptic = LocalHapticFeedback.current
    val view = LocalView.current

    IconButton(
        enabled = isEnabled,
        colors = IconButtonColors(Color.Black, Color.Black, Color.LightGray, Color.LightGray),
        onClick = {  },
        modifier = Modifier
            .size(115.dp)
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        Log.d(TAG, "onPress: down")
                        val didDwell = withTimeoutOrNull(300L) {
                            delay(300L)
                            true
                        } ?: false

                        if (didDwell) {
                            vibrateOnce(context, 40L)
                            /*CoroutineScope(Dispatchers.Main).launch {
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
                            }*/
                            haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        }

                        try {
                            tryAwaitRelease()
                        } finally {
                            Log.d(TAG, "released")
                        }
                    }
                )
            }
    ) {

    }
}
