package com.inforad.retotecnicoapp.presentation.components

import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.inforad.retotecnicoapp.presentation.theme.ColorButtonPrincipal
import com.inforad.retotecnicoapp.presentation.theme.ColorText

@Composable
fun PrincipalButton(
    modifier: Modifier,
    onClick: () -> Unit,
    text: String,
    color: Color = ColorButtonPrincipal
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = color
        )
    ) {
        Text(
            text = text,
            color = ColorText
        )

    }
}