package com.inforad.retotecnicoapp.presentation.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.inforad.retotecnicoapp.presentation.theme.ColorText

@Composable
fun CustomText(
    modifier: Modifier,
    text: String,
    textCustom: String,
    fontWeight: FontWeight,
    textAlign: TextAlign = TextAlign.Center,
    color: Color = ColorText,
    colorCustom: Color = ColorText,
    fontWeightCustom: FontWeight = FontWeight.Normal
){
    val startIndex = text.indexOf(textCustom)
    val endIndex = startIndex + textCustom.length
    val annotatedTexto = buildAnnotatedString {
        append(text.substring(0, startIndex))
        pushStyle(SpanStyle(color = colorCustom, fontWeight = fontWeightCustom))
        append(textCustom)
        pop()
        append(text.substring(endIndex, text.length))
        toAnnotatedString()
    }


    Text(
        modifier = modifier,
        text = annotatedTexto,
        fontWeight = fontWeight,
        color = color,
        textAlign = textAlign
    )
}