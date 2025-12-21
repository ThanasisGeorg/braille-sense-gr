package com.thanasis.braillesensegr.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thanasis.braillesensegr.ui.theme.CelticBlue

@Composable
fun TTSwitch(isEnabled: Boolean, onCheckedChanged: (Boolean) -> Unit) {
    val customColors = SwitchDefaults.colors(
        // Unchecked state Colors
        uncheckedTrackColor = Color.LightGray.copy(alpha = 0.5f),
        uncheckedThumbColor = Color.DarkGray,
        uncheckedBorderColor = Color.Transparent,

        // Checked state Colors
        checkedThumbColor = Color.White,
        checkedTrackColor = CelticBlue,
        checkedBorderColor = CelticBlue
    )

    Switch(
        checked = isEnabled,
        onCheckedChange = onCheckedChanged,
        modifier = Modifier
            .graphicsLayer {
                scaleX = 6f
                scaleY = 6f
            }
            .pointerInput(Unit) {},
        colors = customColors
    )
}

@Preview
@Composable
fun TTSwitchPreview() {
    TTSwitch(isEnabled = true, onCheckedChanged = {})
}