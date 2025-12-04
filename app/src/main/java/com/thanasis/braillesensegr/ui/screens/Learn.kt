package com.thanasis.braillesensegr.ui.screens

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.boundsInWindow
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.thanasis.braillesensegr.R
import com.thanasis.braillesensegr.backend.TitleVoice
import com.thanasis.braillesensegr.ui.components.DotIconButton
import com.thanasis.braillesensegr.ui.components.NavigationFloatingButton
import com.thanasis.braillesensegr.ui.components.NormalText
import com.thanasis.braillesensegr.ui.components.ReturnFloatingButton

class HapticController(private val context: Context) {
    private val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
    var isVibrating: Boolean = false
        private set

    private val VIBRATION_DURATION = 40L

    fun startContinuousVibration() {
        if (isVibrating) return

        Log.d("HapticController", "Starting continuous vibration.")
        isVibrating = true

        val pattern = longArrayOf(0, VIBRATION_DURATION)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibrator.vibrate(VibrationEffect.createWaveform(pattern, 0))
        } else {
            @Suppress("DEPRECATION")
            vibrator.vibrate(pattern, 0) // Loop indefinitely
        }
    }

    fun stopContinuousVibration() {
        if (!isVibrating) return

        Log.d("HapticController", "Stopping continuous vibration.")
        vibrator.cancel()
        isVibrating = false
    }
}

data class BrailleDot(
    val id: Int,
    val isEnabled: Boolean,
    var bounds: Rect = Rect.Zero
)

data class BrailleLetter(
    val name: String,
    val symbol: String,
    val resourceId: Int,
    val dots: List<BrailleDot>
)

val greekBrailleLetters = listOf(
    BrailleLetter(
        name = "(Άλφα)",
        symbol = "α",
        resourceId = R.string.alpha,
        dots = listOf(
            BrailleDot(1, true),  BrailleDot(4, false),
            BrailleDot(2, false), BrailleDot(5, false),
            BrailleDot(3, false), BrailleDot(6, false)
        )
    ),
    BrailleLetter(
        name = "(Βήτα)",
        symbol = "β",
        resourceId = R.string.beta,
        dots = listOf(
            BrailleDot(1, true),  BrailleDot(4, false),
            BrailleDot(2, true),  BrailleDot(5, false),
            BrailleDot(3, false), BrailleDot(6, false)
        )
    ),
    BrailleLetter(
        name = "(Γάμμα)",
        symbol = "γ",
        resourceId = R.string.gamma,
        dots = listOf(
            BrailleDot(1, true),  BrailleDot(4, true),
            BrailleDot(2, true),  BrailleDot(5, true),
            BrailleDot(3, false), BrailleDot(6, false)
        )
    ),
    BrailleLetter(
        name = "(Δέλτα)",
        symbol = "δ",
        resourceId = R.string.delta,
        dots = listOf(
            BrailleDot(1, true),  BrailleDot(4, true),
            BrailleDot(2, false),  BrailleDot(5, true),
            BrailleDot(3, false), BrailleDot(6, false)
        )
    ),
    BrailleLetter(
        name = "(Έψιλον)",
        symbol = "ε",
        resourceId = R.string.epsilon,
        dots = listOf(
            BrailleDot(1, true),  BrailleDot(4, false),
            BrailleDot(2, false),  BrailleDot(5, true),
            BrailleDot(3, false), BrailleDot(6, false)
        )
    ),
    BrailleLetter(
        name = "(Ζήτα)",
        symbol = "ζ",
        resourceId = R.string.zita,
        dots = listOf(
            BrailleDot(1, true),  BrailleDot(4, false),
            BrailleDot(2, false),  BrailleDot(5, true),
            BrailleDot(3, true), BrailleDot(6, true)
        )
    ),
    BrailleLetter(
        name = "(Ήτα)",
        symbol = "η",
        resourceId = R.string.ita,
        dots = listOf(
            BrailleDot(1, false),  BrailleDot(4, true),
            BrailleDot(2, false),  BrailleDot(5, true),
            BrailleDot(3, true), BrailleDot(6, false)
        )
    ),
    BrailleLetter(
        name = "(Θήτα)",
        symbol = "θ",
        resourceId = R.string.theta,
        dots = listOf(
            BrailleDot(1, true),  BrailleDot(4, true),
            BrailleDot(2, false),  BrailleDot(5, true),
            BrailleDot(3, false), BrailleDot(6, true)
        )
    ),
    BrailleLetter(
        name = "(Ιώτα)",
        symbol = "ι",
        resourceId = R.string.iota,
        dots = listOf(
            BrailleDot(1, false),  BrailleDot(4, true),
            BrailleDot(2, true),  BrailleDot(5, false),
            BrailleDot(3, false), BrailleDot(6, false)
        )
    ),
    BrailleLetter(
        name = "(Κάππα)",
        symbol = "κ",
        resourceId = R.string.kappa,
        dots = listOf(
            BrailleDot(1, true),  BrailleDot(4, false),
            BrailleDot(2, false),  BrailleDot(5, false),
            BrailleDot(3, true), BrailleDot(6, false)
        )
    ),
    BrailleLetter(
        name = "(Λάμδα)",
        symbol = "λ",
        resourceId = R.string.lambda,
        dots = listOf(
            BrailleDot(1, true),  BrailleDot(4, false),
            BrailleDot(2, true),  BrailleDot(5, false),
            BrailleDot(3, true), BrailleDot(6, false)
        )
    ),
    BrailleLetter(
        name = "(Μι)",
        symbol = "μ",
        resourceId = R.string.mi,
        dots = listOf(
            BrailleDot(1, true),  BrailleDot(4, true),
            BrailleDot(2, false),  BrailleDot(5, false),
            BrailleDot(3, true), BrailleDot(6, false)
        )
    ),
    BrailleLetter(
        name = "(Νι)",
        symbol = "ν",
        resourceId = R.string.ni,
        dots = listOf(
            BrailleDot(1, true),  BrailleDot(4, true),
            BrailleDot(2, false),  BrailleDot(5, true),
            BrailleDot(3, true), BrailleDot(6, false)
        )
    ),
    BrailleLetter(
        name = "(Ξι)",
        symbol = "ξ",
        resourceId = R.string.ksi,
        dots = listOf(
            BrailleDot(1, true),  BrailleDot(4, true),
            BrailleDot(2, false),  BrailleDot(5, false),
            BrailleDot(3, true), BrailleDot(6, true)
        )
    ),
    BrailleLetter(
        name = "(Όμικρον)",
        symbol = "ο",
        resourceId = R.string.omicron,
        dots = listOf(
            BrailleDot(1, true),  BrailleDot(4, false),
            BrailleDot(2, false),  BrailleDot(5, true),
            BrailleDot(3, true), BrailleDot(6, false)
        )
    ),
    BrailleLetter(
        name = "(Πι)",
        symbol = "π",
        resourceId = R.string.pi,
        dots = listOf(
            BrailleDot(1, true),  BrailleDot(4, true),
            BrailleDot(2, true),  BrailleDot(5, false),
            BrailleDot(3, true), BrailleDot(6, false)
        )
    ),
    BrailleLetter(
        name = "(Ρο)",
        symbol = "ρ",
        resourceId = R.string.ro,
        dots = listOf(
            BrailleDot(1, true),  BrailleDot(4, false),
            BrailleDot(2, true),  BrailleDot(5, true),
            BrailleDot(3, true), BrailleDot(6, false)
        )
    ),
    BrailleLetter(
        name = "(Σίγμα)",
        symbol = "σ",
        resourceId = R.string.sigma,
        dots = listOf(
            BrailleDot(1, false),  BrailleDot(4, true),
            BrailleDot(2, true),  BrailleDot(5, false),
            BrailleDot(3, true), BrailleDot(6, false)
        )
    ),
    BrailleLetter(
        name = "(Ταυ)",
        symbol = "τ",
        resourceId = R.string.taf,
        dots = listOf(
            BrailleDot(1, false),  BrailleDot(4, true),
            BrailleDot(2, true),  BrailleDot(5, true),
            BrailleDot(3, true), BrailleDot(6, false)
        )
    ),
    BrailleLetter(
        name = "(Ύψιλον)",
        symbol = "υ",
        resourceId = R.string.upsilon,
        dots = listOf(
            BrailleDot(1, true),  BrailleDot(4, true),
            BrailleDot(2, false),  BrailleDot(5, true),
            BrailleDot(3, true), BrailleDot(6, true)
        )
    ),
    BrailleLetter(
        name = "(Φι)",
        symbol = "φ",
        resourceId = R.string.fi,
        dots = listOf(
            BrailleDot(1, true),  BrailleDot(4, true),
            BrailleDot(2, true),  BrailleDot(5, false),
            BrailleDot(3, false), BrailleDot(6, false)
        )
    ),
    BrailleLetter(
        name = "(Χι)",
        symbol = "χ",
        resourceId = R.string.xi,
        dots = listOf(
            BrailleDot(1, true),  BrailleDot(4, false),
            BrailleDot(2, true),  BrailleDot(5, true),
            BrailleDot(3, false), BrailleDot(6, false)
        )
    ),
    BrailleLetter(
        name = "(Ψι)",
        symbol = "ψ",
        resourceId = R.string.psi,
        dots = listOf(
            BrailleDot(1, true),  BrailleDot(4, true),
            BrailleDot(2, true),  BrailleDot(5, false),
            BrailleDot(3, true), BrailleDot(6, true)
        )
    ),
    BrailleLetter(
        name = "(Ωμέγα)",
        symbol = "ω",
        resourceId = R.string.omega,
        dots = listOf(
            BrailleDot(1, false),  BrailleDot(4, true),
            BrailleDot(2, true),  BrailleDot(5, true),
            BrailleDot(3, false), BrailleDot(6, false)
        )
    )

)

@Composable
fun BrailleInputSurface(
    context: Context,
    letter: BrailleLetter,
    isEnabled: Boolean,
    duration: Long = 40L
) {
    val hapticController = remember { HapticController(context) }
    val brailleDotsMap = remember { mutableStateMapOf<Int, BrailleDot>() }
    var parentWindowOffset by remember { mutableStateOf(Offset.Zero) }

    LaunchedEffect(letter) {
        brailleDotsMap.clear()
        letter.dots.forEach { brailleDotsMap[it.id] = it }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxHeight()
            .onGloballyPositioned { coordinates ->
                parentWindowOffset = coordinates.boundsInWindow().topLeft
            }
            .pointerInput(Unit) {
                awaitPointerEventScope {
                    while (true) {
                        val event = awaitPointerEvent()
                        val change = event.changes.firstOrNull() ?: continue

                        val currentWindowPosition = parentWindowOffset + change.position

                        val dotUnderFinger = brailleDotsMap.values.find { dot ->
                            dot.bounds.contains(currentWindowPosition)
                        }

                        // Check if the finger is over an ENABLED dot
                        val shouldVibrate = dotUnderFinger != null && dotUnderFinger.isEnabled

                        if (shouldVibrate && !hapticController.isVibrating) {
                            // Start vibration if finger is on an active dot and not already vibrating
                            hapticController.startContinuousVibration()
                        } else if (!shouldVibrate && hapticController.isVibrating) {
                            // Stop vibration if finger slide off the dot, or slide onto a disabled dot
                            hapticController.stopContinuousVibration()
                        }

                        // Stop if the finger is lifted
                        if (event.changes.none { it.pressed }) {
                            hapticController.stopContinuousVibration()
                        }
                    }
                }
            }
    ) {
        TitleVoice(stringResource(id = letter.resourceId), isEnabled)
        NormalText(value = letter.symbol, textAlign = TextAlign.Center, fontSize = 50)

        Spacer(modifier = Modifier.height(20.dp))

        val sortedDots = letter.dots.sortedBy { it.id }
        val leftDots = sortedDots.filter { it.id in 1..3 }.map { it.id }
        val rightDots = sortedDots.filter { it.id in 4..6 }.map { it.id }

        (0..2).forEach { rowIndex ->
            Row {
                brailleDotsMap[leftDots[rowIndex]]?.let { dotData ->
                    DotIconButton(
                        dotData = dotData,
                        onBoundsChanged = { newBounds -> brailleDotsMap[dotData.id] = dotData.copy(bounds = newBounds) }
                    )
                }
                Spacer(modifier = Modifier.width(60.dp))
                brailleDotsMap[rightDots[rowIndex]]?.let { dotData ->
                    DotIconButton(
                        dotData = dotData,
                        onBoundsChanged = { newBounds -> brailleDotsMap[dotData.id] = dotData.copy(bounds = newBounds) }
                    )
                }
            }
            if (rowIndex < 2) {
                Spacer(modifier = Modifier.height(30.dp))
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LearnInit(navHostController: NavHostController, isEnabled: Boolean) {
    val context = LocalContext.current
    var currentIndex by remember { mutableIntStateOf(0) }
    val hapticController = remember { HapticController(context) }

    val currentLetter = greekBrailleLetters.getOrNull(currentIndex)

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

                Column(
                    Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {
                    currentLetter?.let { letter ->
                        BrailleInputSurface(context = context, letter = letter, isEnabled)
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    val isFirst = currentIndex == 0
                    val isLast = currentIndex == greekBrailleLetters.size - 1

                    if (!isFirst) {
                        NavigationFloatingButton(
                            onClick = {
                                hapticController.stopContinuousVibration()
                                currentIndex = maxOf(0, currentIndex - 1)
                            },
                            text = "Προηγούμενο",
                            context = context,
                            fontSize = 19,
                            width = 190,
                            height = 150,
                            padding = 10
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                    } else if (!isLast) {
                        NavigationFloatingButton(
                            onClick = {
                                hapticController.stopContinuousVibration()
                                currentIndex = minOf(greekBrailleLetters.size - 1, currentIndex + 1)
                            },
                            text= "Επόμενο",
                            context = context,
                            fontSize = 30,
                            width = 300,
                            height = 150,
                            padding = 10
                        )
                    }

                    if (!isLast && !isFirst) {
                        NavigationFloatingButton(
                            onClick = {
                                hapticController.stopContinuousVibration()
                                currentIndex = minOf(greekBrailleLetters.size - 1, currentIndex + 1)
                            },
                            text = "Επόμενο",
                            context = context,
                            fontSize = 19,
                            width = 190,
                            height = 150,
                            padding = 10
                        )
                    }

                    if (isLast) {
                        NavigationFloatingButton(
                            onClick = {
                                hapticController.stopContinuousVibration()
                                currentIndex = 0
                            },
                            text = "Ξανά",
                            context = context,
                            fontSize = 19,
                            width = 190,
                            height = 150,
                            padding = 10
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun LearnInitPreview() {
    LearnInit(navHostController = rememberNavController(), isEnabled = false)
}