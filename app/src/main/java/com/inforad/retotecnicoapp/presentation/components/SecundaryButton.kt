package com.inforad.retotecnicoapp.presentation.components

import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.inforad.retotecnicoapp.presentation.theme.ColorButtonSecundary

@Composable
fun SecundaryButton(
    modifier: Modifier,
    onClick: () -> Unit,
    text: String,
    color: Color = ColorButtonSecundary
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            color
        )
    ) {
        Text(
            text = text
        )

    }
}