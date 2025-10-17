package com.thanasis.braillesensegr.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.thanasis.braillesensegr.R

@Composable
fun ReturnIconButton() {
    IconButton(
        onClick = {  }
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = "Selected icon button"
        )
    }
}