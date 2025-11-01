package com.thanasis.braillesensegr.ui.screens

import android.annotation.SuppressLint
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.thanasis.braillesensegr.ui.components.NextFloatingButton
import com.thanasis.braillesensegr.ui.components.NormalText
import com.thanasis.braillesensegr.ui.components.PreviousFloatingButton
import com.thanasis.braillesensegr.ui.components.ReturnFloatingButton

val letters = listOf(
    "(Άλφα)",
    "(Βήτα)",
    "(Γάμμα)",
    "(Δέλτα)",
    "(Έψιλον)",
    "(Ζήτα)",
    "(Ήτα)",
    "(Θήτα)",
    "(Ιώτα)",
    "(Κάππα)",
    "(Λάμδα)",
    "(Μι)",
    "(Νι)",
    "(Ξι)",
    "(Όμικρον)",
    "(Πι)",
    "(Ρο)",
    "(Σίγμα)",
    "(Ταυ)",
    "(Ύψιλον)",
    "(Φι)",
    "(Χι)",
    "(Ψι)",
    "(Ωμέγα)"
)

@Composable
fun Alpha() {
    val context = LocalContext.current

    TitleVoice(stringResource(id = R.string.alpha))
    NormalText(
        value = "α",
        textAlign = TextAlign.Center,
        fontSize = 50
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxHeight()
    ) {
        Row {
            DotIconButton(context = context, isEnabled = true)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = false)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            DotIconButton(context = context, isEnabled = false)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = false)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            DotIconButton(context = context, isEnabled = false)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = false)
        }
    }
}

@Composable
fun Beta() {
    val context = LocalContext.current

    TitleVoice(stringResource(id = R.string.beta))
    NormalText(
        value = "β",
        textAlign = TextAlign.Center,
        fontSize = 50
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxHeight()
    ) {
        Row {
            DotIconButton(context = context, isEnabled = true)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = false)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            DotIconButton(context = context, isEnabled = true)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = false)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            DotIconButton(context = context, isEnabled = false)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = false)
        }
    }
}

@Composable
fun Gamma() {
    val context = LocalContext.current

    TitleVoice(stringResource(id = R.string.gamma))
    NormalText(
        value = "γ",
        textAlign = TextAlign.Center,
        fontSize = 50
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxHeight()
    ) {
        Row {
            DotIconButton(context = context, isEnabled = true)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = true)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            DotIconButton(context = context, isEnabled = true)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = true)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            DotIconButton(context = context, isEnabled = false)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = false)
        }
    }
}

@Composable
fun Delta() {
    val context = LocalContext.current

    TitleVoice(stringResource(id = R.string.delta))
    NormalText(
        value = "δ",
        textAlign = TextAlign.Center,
        fontSize = 50
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxHeight()
    ) {
        Row {
            DotIconButton(context = context, isEnabled = true)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = true)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            DotIconButton(context = context, isEnabled = false)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = true)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            DotIconButton(context = context, isEnabled = false)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = false)
        }
    }
}

@Composable
fun Epsilon() {
    val context = LocalContext.current

    TitleVoice(stringResource(id = R.string.epsilon))
    NormalText(
        value = "ε",
        textAlign = TextAlign.Center,
        fontSize = 50
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxHeight()
    ) {
        Row {
            DotIconButton(context = context, isEnabled = true)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = false)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            DotIconButton(context = context, isEnabled = false)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = true)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            DotIconButton(context = context, isEnabled = false)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = false)
        }
    }
}

@Composable
fun Zita() {
    val context = LocalContext.current

    TitleVoice(stringResource(id = R.string.zita))
    NormalText(
        value = "ζ",
        textAlign = TextAlign.Center,
        fontSize = 50
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxHeight()
    ) {
        Row {
            DotIconButton(context = context, isEnabled = true)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = false)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            DotIconButton(context = context, isEnabled = false)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = true)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            DotIconButton(context = context, isEnabled = true)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = true)
        }
    }
}

@Composable
fun Ita() {
    val context = LocalContext.current

    TitleVoice(stringResource(id = R.string.ita))
    NormalText(
        value = "η",
        textAlign = TextAlign.Center,
        fontSize = 50
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxHeight()
    ) {
        Row {
            DotIconButton(context = context, isEnabled = false)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = true)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            DotIconButton(context = context, isEnabled = false)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = true)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            DotIconButton(context = context, isEnabled = true)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = false)
        }
    }
}

@Composable
fun Theta() {
    val context = LocalContext.current

    TitleVoice(stringResource(id = R.string.theta))
    NormalText(
        value = "θ",
        textAlign = TextAlign.Center,
        fontSize = 50
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxHeight()
    ) {
        Row {
            DotIconButton(context = context, isEnabled = true)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = true)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            DotIconButton(context = context, isEnabled = false)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = true)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            DotIconButton(context = context, isEnabled = false)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = true)
        }
    }
}

@Composable
fun Iota() {
    val context = LocalContext.current

    TitleVoice(stringResource(id = R.string.iota))
    NormalText(
        value = "ι",
        textAlign = TextAlign.Center,
        fontSize = 50
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxHeight()
    ) {
        Row {
            DotIconButton(context = context, isEnabled = false)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = true)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            DotIconButton(context = context, isEnabled = true)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = false)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            DotIconButton(context = context, isEnabled = false)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = false)
        }
    }
}

@Composable
fun Kappa() {
    val context = LocalContext.current

    TitleVoice(stringResource(id = R.string.kappa))
    NormalText(
        value = "κ",
        textAlign = TextAlign.Center,
        fontSize = 50
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxHeight()
    ) {
        Row {
            DotIconButton(context = context, isEnabled = true)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = false)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            DotIconButton(context = context, isEnabled = false)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = false)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            DotIconButton(context = context, isEnabled = true)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = false)
        }
    }
}

@Composable
fun Lambda() {
    val context = LocalContext.current

    TitleVoice(stringResource(id = R.string.lambda))
    NormalText(
        value = "λ",
        textAlign = TextAlign.Center,
        fontSize = 50
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxHeight()
    ) {
        Row {
            DotIconButton(context = context, isEnabled = true)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = false)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            DotIconButton(context = context, isEnabled = true)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = false)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            DotIconButton(context = context, isEnabled = true)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = false)
        }
    }
}

@Composable
fun Mi() {
    val context = LocalContext.current

    TitleVoice(stringResource(id = R.string.mi))
    NormalText(
        value = "μ",
        textAlign = TextAlign.Center,
        fontSize = 50
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxHeight()
    ) {
        Row {
            DotIconButton(context = context, isEnabled = true)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = true)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            DotIconButton(context = context, isEnabled = false)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = false)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            DotIconButton(context = context, isEnabled = true)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = false)
        }
    }
}

@Composable
fun Ni() {
    val context = LocalContext.current

    TitleVoice(stringResource(id = R.string.ni))
    NormalText(
        value = "ν",
        textAlign = TextAlign.Center,
        fontSize = 50
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxHeight()
    ) {
        Row {
            DotIconButton(context = context, isEnabled = true)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = true)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            DotIconButton(context = context, isEnabled = false)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = true)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            DotIconButton(context = context, isEnabled = true)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = false)
        }
    }
}

@Composable
fun Ksi() {
    val context = LocalContext.current

    TitleVoice(stringResource(id = R.string.ksi))
    NormalText(
        value = "ξ",
        textAlign = TextAlign.Center,
        fontSize = 50
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxHeight()
    ) {
        Row {
            DotIconButton(context = context, isEnabled = true)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = true)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            DotIconButton(context = context, isEnabled = false)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = false)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            DotIconButton(context = context, isEnabled = true)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = true)
        }
    }
}

@Composable
fun Omicron() {
    val context = LocalContext.current

    TitleVoice(stringResource(id = R.string.omicron))
    NormalText(
        value = "ο",
        textAlign = TextAlign.Center,
        fontSize = 50
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxHeight()
    ) {
        Row {
            DotIconButton(context = context, isEnabled = true)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = false)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            DotIconButton(context = context, isEnabled = false)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = true)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            DotIconButton(context = context, isEnabled = true)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = false)
        }
    }
}

@Composable
fun Pi() {
    val context = LocalContext.current

    TitleVoice(stringResource(id = R.string.pi))
    NormalText(
        value = "π",
        textAlign = TextAlign.Center,
        fontSize = 50
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxHeight()
    ) {
        Row {
            DotIconButton(context = context, isEnabled = true)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = true)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            DotIconButton(context = context, isEnabled = true)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = false)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            DotIconButton(context = context, isEnabled = true)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = false)
        }
    }
}

@Composable
fun Ro() {
    val context = LocalContext.current

    TitleVoice(stringResource(id = R.string.ro))
    NormalText(
        value = "ρ",
        textAlign = TextAlign.Center,
        fontSize = 50
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxHeight()
    ) {
        Row {
            DotIconButton(context = context, isEnabled = true)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = false)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            DotIconButton(context = context, isEnabled = true)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = true)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            DotIconButton(context = context, isEnabled = true)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = false)
        }
    }
}

@Composable
fun Sigma() {
    val context = LocalContext.current

    TitleVoice(stringResource(id = R.string.sigma))
    NormalText(
        value = "σ",
        textAlign = TextAlign.Center,
        fontSize = 50
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxHeight()
    ) {
        Row {
            DotIconButton(context = context, isEnabled = false)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = true)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            DotIconButton(context = context, isEnabled = true)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = false)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            DotIconButton(context = context, isEnabled = true)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = false)
        }
    }
}

@Composable
fun Taf() {
    val context = LocalContext.current

    TitleVoice(stringResource(id = R.string.taf))
    NormalText(
        value = "τ",
        textAlign = TextAlign.Center,
        fontSize = 50
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxHeight()
    ) {
        Row {
            DotIconButton(context = context, isEnabled = false)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = true)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            DotIconButton(context = context, isEnabled = true)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = true)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            DotIconButton(context = context, isEnabled = true)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = false)
        }
    }
}

@Composable
fun Upsilon() {
    val context = LocalContext.current

    TitleVoice(stringResource(id = R.string.upsilon))
    NormalText(
        value = "υ",
        textAlign = TextAlign.Center,
        fontSize = 50
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxHeight()
    ) {
        Row {
            DotIconButton(context = context, isEnabled = true)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = true)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            DotIconButton(context = context, isEnabled = false)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = true)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            DotIconButton(context = context, isEnabled = true)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = true)
        }
    }
}

@Composable
fun Fi() {
    val context = LocalContext.current

    TitleVoice(stringResource(id = R.string.fi))
    NormalText(
        value = "φ",
        textAlign = TextAlign.Center,
        fontSize = 50
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxHeight()
    ) {
        Row {
            DotIconButton(context = context, isEnabled = true)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = true)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            DotIconButton(context = context, isEnabled = true)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = false)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            DotIconButton(context = context, isEnabled = false)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = false)
        }
    }
}

@Composable
fun Xi() {
    val context = LocalContext.current

    TitleVoice(stringResource(id = R.string.xi))
    NormalText(
        value = "χ",
        textAlign = TextAlign.Center,
        fontSize = 50
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxHeight()
    ) {
        Row {
            DotIconButton(context = context, isEnabled = true)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = false)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            DotIconButton(context = context, isEnabled = true)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = true)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            DotIconButton(context = context, isEnabled = false)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = false)
        }
    }
}

@Composable
fun Psi() {
    val context = LocalContext.current

    TitleVoice(stringResource(id = R.string.psi))
    NormalText(
        value = "ψ",
        textAlign = TextAlign.Center,
        fontSize = 50
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxHeight()
    ) {
        Row {
            DotIconButton(context = context, isEnabled = true)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = true)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            DotIconButton(context = context, isEnabled = true)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = false)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            DotIconButton(context = context, isEnabled = true)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = true)
        }
    }
}

@Composable
fun Omega() {
    val context = LocalContext.current

    TitleVoice(stringResource(id = R.string.omega))
    NormalText(
        value = "ω",
        textAlign = TextAlign.Center,
        fontSize = 50
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxHeight()
    ) {
        Row {
            DotIconButton(context = context, isEnabled = false)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = true)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            DotIconButton(context = context, isEnabled = true)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = true)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            DotIconButton(context = context, isEnabled = false)
            Spacer(modifier = Modifier.width(50.dp))
            DotIconButton(context = context, isEnabled = false)
        }
    }
}

@Composable
fun DrawGreekBrailleLetter(currentIndex: Int) {
    when (letters[currentIndex]) {
        "(Άλφα)" -> {
            Alpha()
        }
        "(Βήτα)" -> {
            Beta()
        }
        "(Γάμμα)" -> {
            Gamma()
        }
        "(Δέλτα)" -> {
            Delta()
        }
        "(Έψιλον)" -> {
            Epsilon()
        }
        "(Ζήτα)" -> {
            Zita()
        }
        "(Ήτα)" -> {
            Ita()
        }
        "(Θήτα)" -> {
            Theta()
        }
        "(Ιώτα)" -> {
            Iota()
        }
        "(Κάππα)" -> {
            Kappa()
        }
        "(Λάμδα)" -> {
            Lambda()
        }
        "(Μι)" -> {
            Mi()
        }
        "(Νι)" -> {
            Ni()
        }
        "(Ξι)" -> {
            Ksi()
        }
        "(Όμικρον)" -> {
            Omicron()
        }
        "(Πι)" -> {
            Pi()
        }
        "(Ρο)" -> {
            Ro()
        }
        "(Σίγμα)" -> {
            Sigma()
        }
        "(Ταυ)" -> {
            Taf()
        }
        "(Ύψιλον)" -> {
            Upsilon()
        }
        "(Φι)" -> {
            Fi()
        }
        "(Χι)" -> {
            Xi()
        }
        "(Ψι)" -> {
            Psi()
        }
        "(Ωμέγα)" -> {
            Omega()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LearnInit(navHostController: NavHostController) {
    val context = LocalContext.current
    var currentIndex by remember { mutableIntStateOf(0) }

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
                        .height(580.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {
                    DrawGreekBrailleLetter(currentIndex)
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    if (currentIndex == 0) {
                        NextFloatingButton(
                            onNext = {
                                currentIndex = (currentIndex + 1) % letters.size
                            },
                            context = context,
                            fontSize = 30,
                            width = 300,
                            height = 150,
                            padding = 10
                        )
                    } else {
                        PreviousFloatingButton(
                            onPrevious = {
                                Log.d("TAG", "CurrentIndex: $currentIndex")
                                currentIndex = (currentIndex - 1) % letters.size
                            },
                            context = context,
                            fontSize = 19,
                            width = 190,
                            height = 150,
                            padding = 10
                        )
                        NextFloatingButton(
                            onNext = {
                                Log.d("TAG", "CurrentIndex: $currentIndex")
                                currentIndex = (currentIndex + 1) % letters.size
                            },
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

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LearnInit_(navHostController: NavHostController) {
    val context = LocalContext.current
    var currentIndex by remember { mutableIntStateOf(0) }

    //TitleVoice(stringResource(R.string.learnVoiceText))
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
                        .height(570.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {
                    DrawGreekBrailleLetter(currentIndex)
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    if (currentIndex == 0) {
                        NextFloatingButton(
                            onNext = {
                                currentIndex = (currentIndex + 1) % letters.size
                            },
                            context = context,
                            fontSize = 30,
                            width = 300,
                            height = 150,
                            padding = 10
                        )
                    } else {
                        PreviousFloatingButton(
                            onPrevious = {
                                Log.d("TAG", "CurrentIndex: $currentIndex")
                                currentIndex = (currentIndex - 1) % letters.size
                            },
                            context = context,
                            fontSize = 19,
                            width = 190,
                            height = 150,
                            padding = 10
                        )
                        NextFloatingButton(
                            onNext = {
                                Log.d("TAG", "CurrentIndex: $currentIndex")
                                currentIndex = (currentIndex + 1) % letters.size
                            },
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
    LearnInit_(navHostController = rememberNavController())
}