package com.thanasis.braillesensegr.backend

import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import android.util.Log

fun vibrate(context: Context, duration: Long): Boolean {
    return try {
        val vibrator: Vibrator? = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val vm = context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as? VibratorManager
            vm?.defaultVibrator
        } else {
            @Suppress("DEPRECATION")
            context.getSystemService(Context.VIBRATOR_SERVICE) as? Vibrator
        }

        if (vibrator == null) {
            Log.w("HapticUtils", "No vibrator instance available")
            return false
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            if (!vibrator.hasVibrator()) {
                Log.w("HapticUtils", "Device reports no vibrator hardware")
                return false
            }
            val d = duration.coerceAtLeast(1L)
            val effect = VibrationEffect.createOneShot(d, VibrationEffect.DEFAULT_AMPLITUDE)
            vibrator.vibrate(effect)
        } else {
            @Suppress("DEPRECATION")
            vibrator.vibrate(duration)
        }
        true
    } catch (e: Exception) {
        Log.e("HapticUtils", "safeVibrate failed: ${e.message}")
        false
    }
}