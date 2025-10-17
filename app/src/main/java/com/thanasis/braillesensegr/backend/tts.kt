package com.thanasis.braillesensegr.backend

import android.content.Context
import android.speech.tts.TextToSpeech
import android.util.Log
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.intl.Locale

@Composable
fun rememberTTS(
    context: Context = LocalContext.current,
    targetLocale: Locale = Locale("el")
): Pair<TextToSpeech?, Boolean> {
    var tts: TextToSpeech? by remember { mutableStateOf(null) }
    var initialized by remember { mutableStateOf(false) }

    DisposableEffect(context) {
        tts = TextToSpeech(context) { status ->
            if (status == TextToSpeech.SUCCESS) {
                val greekVoice = tts?.voices?.firstOrNull { it.locale.language == targetLocale.language }
                if (greekVoice != null) {
                    tts?.voice = greekVoice
                }
                initialized = true
            } else {
                Log.e("TTS", "TTS initialization failed: status=$status")
            }
        }

        onDispose {
            tts?.stop()
            tts?.shutdown()
            tts = null
            initialized = false
        }
    }

    return Pair(tts, initialized)
}

@Composable
fun TitleVoice(text: String) {
    val context = LocalContext.current
    val (tts, initialized) = rememberTTS(context)

    LaunchedEffect(initialized, text) {
        if (initialized && text.isNotBlank()) {
            val utteranceId = "titleVoice-${System.currentTimeMillis()}"
            tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, utteranceId)
        }
    }
}