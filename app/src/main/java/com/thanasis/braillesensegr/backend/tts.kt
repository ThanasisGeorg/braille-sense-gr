package com.thanasis.braillesensegr.backend

import android.content.Context
import android.speech.tts.TextToSpeech
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext

@Composable
fun RememberTTS(
    context: Context = LocalContext.current
): TextToSpeech? {
    var tts: TextToSpeech? by remember { mutableStateOf(null) }

    DisposableEffect(Unit) {
        tts = TextToSpeech(context) { status ->
            if (status == TextToSpeech.SUCCESS) {
                val greekVoice = tts?.voices?.firstOrNull { it.locale.language == "el" }
                if (greekVoice != null) {
                    tts?.voice = greekVoice
                } else {
                    Log.e("TTS", "Greek voice not found, using default")
                }
            } else {
                Log.e("TTS", "TTS initialization failed")
            }
        }

        onDispose {
            tts?.stop()
            tts?.shutdown()
        }
    }

    return tts
}

@Composable
fun TitleVoice(text: String) {
    val context = LocalContext.current
    val tts = RememberTTS(context)

    LaunchedEffect(tts) {
        tts?.speak(
            text,
            TextToSpeech.QUEUE_FLUSH,
            null,
            "welcomeMessage"
        )
    }
}