package com.inforad.retotecnicoapp.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
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