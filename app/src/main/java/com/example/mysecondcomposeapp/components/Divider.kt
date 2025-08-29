package com.example.mysecondcomposeapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(showBackground = true)
@Composable
fun MyDivider(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text("Parte de cima")
        HorizontalDivider(
            thickness = 3.dp, color = Color.Red
        )
        Text("Parte de baixo")

        Row (modifier = modifier.height(150.dp)){
            Text("Parte de esquerda")
            VerticalDivider(
                thickness = 6.dp, color = Color.Green

            )
            Text("Parte de direita")
        }
    }
}