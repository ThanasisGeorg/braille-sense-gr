package com.thanasis.braillesensegr.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.thanasis.braillesensegr.ui.theme.Purple40

@Composable
fun NormalText(value: String, textAlign: TextAlign, fontSize: Int) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = fontSize.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        textAlign = textAlign
    )
}
@Composable
fun HeadingText(value: String) {
    Text(
        text = value,
        modifier = Modifier
            //.fillMaxWidth()
            .heightIn(),
        style = TextStyle(
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        ),
        textAlign = TextAlign.Center
    )
}

@Composable
fun TextField(labelValue: String, onTextSelected: (String) -> Unit, errorStatus: Boolean = true) {
    val textValue = remember {
        mutableStateOf("")
    }
    
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        label = {Text(text = labelValue)},
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        singleLine = true,
        maxLines = 1,
        value = textValue.value,
        onValueChange = {
            textValue.value = it
            onTextSelected(it)
        },
        isError = !errorStatus
    )
}

@Composable
fun TextField(labelValue: String, textValue: String, onTextSelected: (String) -> Unit, errorStatus: Boolean = true) {
    val newValue = remember {
        mutableStateOf(textValue)
    }

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        label = {Text(text = labelValue)},
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        singleLine = true,
        maxLines = 1,
        value = newValue.value,
        onValueChange = {
            newValue.value = it
            onTextSelected(it)
        },
        isError = !errorStatus
    )
}
@Composable
fun CheckBox(onCheckedChange: (Boolean) -> Unit, navHostController: NavHostController) {
    val initialText = "By continuing you accept our "
    val privacyPolicyText = "Privacy Policy "
    val andText = "and "
    val termsAndConditionsText = "Term of Use"
    val checkedState = remember {
        mutableStateOf(false)
    }

    Column {
        Row(modifier = Modifier
            .fillMaxWidth()
            .heightIn(56.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = checkedState.value,
                onCheckedChange = {
                    checkedState.value = !checkedState.value
                    onCheckedChange.invoke(it)
                }
            )

            Text(
                text = initialText,
                fontSize = 13.sp
            )
            Text(
                text = privacyPolicyText,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clickable {
                        //navHostController.navigate(BrailleSenseGRApp.PrivacyPolicy.name)
                    }
            )
            Text(
                text = andText,
                fontSize = 13.sp
            )
            Spacer(modifier = Modifier.padding(5.dp, 0.dp))
            //ClickableTextComp(navHostController)
        }
        Text(
            text = termsAndConditionsText,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .clickable {
                    //navHostController.navigate(BrailleSenseGRApp.TermsOfUse.name)
                }
        )
    }
}

@Composable
fun ClickableTextComp(navHostController: NavHostController) {
    val initialText = "By continuing you accept our "
    val privacyPolicyText = "Privacy Policy "
    val andText = "and "
    val termsAndConditionsText = "Term of Use"

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = Purple40)) {
            pushStringAnnotation(tag = privacyPolicyText, annotation = privacyPolicyText)
            append(privacyPolicyText)
        }
        append(andText)
        withStyle(style = SpanStyle(color = Purple40)) {
            pushStringAnnotation(tag = termsAndConditionsText, annotation = termsAndConditionsText)
            append(termsAndConditionsText)
        }
    }

    ClickableText(
        text = annotatedString,
        onClick = {
            offset ->
            annotatedString
                .getStringAnnotations(offset, offset)
                .firstOrNull()?.also { span ->
                    if (span.item == termsAndConditionsText) {
                        //navHostController.navigate(BrailleSenseGRApp.TermsOfUse.name)
                    } else if (span.item == privacyPolicyText) {
                        //navHostController.navigate(BrailleSenseGRApp.PrivacyPolicy.name)
                    }
                }
        }
    )
}

@Composable
fun ClickableLoginTextComp(loginAttempt: Boolean = true, onTextSelected: (String) -> Unit) {
    val initialText = if (loginAttempt) "Already have an account? " else "Don't have an account yet? "
    val loginText = if (loginAttempt) "Login" else "Register"

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = Purple40)) {
            pushStringAnnotation(tag = loginText, annotation = loginText)
            append(loginText)
        }
    }

    ClickableText(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 21.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center
        ),
        text = annotatedString,
        onClick = { offset -> annotatedString.getStringAnnotations(offset, offset)
        .firstOrNull()?.also { span ->
            if (span.item == loginText) {
                onTextSelected(span.item)
            }
        }
    })
}

@Composable
fun UnderLinedText(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        color = Color.Gray,
        textAlign = TextAlign.Center,
        textDecoration = TextDecoration.Underline
    )
}

/*@Composable
fun CategoryIndicator(category: String, textSize: Int) {
    when (category) {
        "theme" -> {
            Text(
                text = stringResource(R.string.theme),
                fontSize = textSize.sp
            )
        }
        "dark" -> {
            Text(
                text = stringResource(R.string.dark),
                fontSize = textSize.sp
            )
        }
        "light" -> {
            Text(
                text = stringResource(R.string.light),
                fontSize = textSize.sp
            )
        }
        "security" -> {
            Text(
                text = stringResource(R.string.security),
                fontSize = textSize.sp
            )
        }
        "language" -> {
            Text(
                text = stringResource(R.string.language),
                fontSize = textSize.sp
            )
        }
    }

}*/