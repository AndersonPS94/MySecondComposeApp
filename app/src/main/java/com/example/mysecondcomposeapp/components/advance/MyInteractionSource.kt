package com.example.mysecondcomposeapp.components.advance

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun InteractionSourceExample(modifier: Modifier = Modifier) {
    val interacion: MutableInteractionSource = remember { MutableInteractionSource() }
    val isPressed: Boolean by interacion.collectIsPressedAsState()

    Box(
        modifier = Modifier
            .size(150.dp)
            .shadow(if (isPressed) 12.dp else 4.dp)
            .background(if (isPressed) Color.Red else Color.White)
            .clickable(interactionSource = interacion, indication = null) {

            },
        contentAlignment = Alignment.Center
        ){
        Text(text = if (isPressed) "Pressed" else "Not Pressed")
    }
}
