package com.inforad.retotecnicoapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.inforad.retotecnicoapp.R
import com.inforad.retotecnicoapp.presentation.theme.ColorButtonSecundary

@Composable
fun SecundaryButton(
    modifier: Modifier,
    onClick: () -> Unit,
    text: String,
    color: Color = ColorButtonSecundary,
    imagen: Int = R.drawable.fondoreto
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            color
        )
    ) {
        Row(horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically) {
            Image(
                modifier = Modifier
                    .size(32.dp) // Ajusta el tamaño de la imagen según tus necesidades
                    .padding(4.dp), // Añade un pequeño espacio alrededor de la imagen
                painter = painterResource(id = imagen),
                contentDescription = "Imagen de Boton",
                alignment = Alignment.CenterStart,
            )
            Spacer(modifier = Modifier.width(8.dp)) // Espacio entre la imagen y el texto
            Text(
                text = text
            )
        }

    }
}