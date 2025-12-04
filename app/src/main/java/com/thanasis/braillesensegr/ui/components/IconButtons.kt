package com.thanasis.braillesensegr.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.boundsInWindow
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.dp
import com.thanasis.braillesensegr.ui.screens.BrailleDot

@Composable
fun DotIconButton(
    dotData: BrailleDot,
    onBoundsChanged: (Rect) -> Unit
) {
    IconButton(
        enabled = dotData.isEnabled,
        onClick = {},
        modifier = Modifier
            .size(115.dp)
            .onGloballyPositioned { coordinates ->
                val newBounds = coordinates.boundsInWindow()
                if (newBounds != dotData.bounds) {
                    onBoundsChanged(newBounds)
                }
            },
        colors = IconButtonColors(
            Color.Black,
            Color.Black,
            Color.LightGray,
            Color.LightGray
        )
    ) {
    }
}

