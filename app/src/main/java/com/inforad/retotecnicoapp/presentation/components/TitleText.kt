package com.inforad.retotecnicoapp.presentation.components


import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.inforad.retotecnicoapp.presentation.theme.ColorText
import androidx.compose.ui.Modifier

@Composable
fun TitleText(
    modifier: Modifier,
    text: String,
    fontWeight: FontWeight,
    fontFamily: FontFamily = FontFamily.Default,
    color: Color = ColorText
) {
    Text(
        modifier = modifier,
        text = text,
        fontWeight = fontWeight,
        color = color
    )
}