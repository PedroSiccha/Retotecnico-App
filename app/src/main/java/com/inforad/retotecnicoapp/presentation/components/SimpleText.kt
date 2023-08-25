package com.inforad.retotecnicoapp.presentation.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.inforad.retotecnicoapp.presentation.theme.ColorText

@Composable
fun SimpleText(
    modifier: Modifier,
    text: String,
    fontWeight: FontWeight,
    textAlign: TextAlign = TextAlign.Center,
    color: Color = ColorText
) {
    Text(
        modifier = modifier,
        text = text,
        fontWeight = fontWeight,
        color = color,
        textAlign = textAlign
    )
}