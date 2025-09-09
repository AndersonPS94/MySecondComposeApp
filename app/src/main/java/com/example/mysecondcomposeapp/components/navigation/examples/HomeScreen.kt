package com.example.mysecondcomposeapp.components.navigation.examples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(navigateBack: () -> Unit, navigateToDetail: (String, Boolean) -> Unit) {

   var text by remember { mutableStateOf("") }
    Column(Modifier.fillMaxSize().background(Color.Yellow), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(Modifier.weight(1f))
        Text(text = "Home Screen", fontSize = 30.sp)
        Spacer(Modifier.weight(1f))
        Row {
            TextField(value = text, onValueChange = {text = it}, Modifier.weight(1f))
            Button(onClick = { navigateToDetail(text, true)}) {
                Text(text = "Detail")
            }
        }

        Spacer(Modifier.weight(0.2f))
        Button(onClick = {navigateBack() }) {
            Text(text = "Voltar")
        }
        Spacer(Modifier.weight(1f))

    }
}