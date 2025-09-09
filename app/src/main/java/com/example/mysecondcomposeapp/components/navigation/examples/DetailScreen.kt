package com.example.mysecondcomposeapp.components.navigation.examples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.example.mysecondcomposeapp.components.navigation.examples.model.SettingModel

@Composable
fun DetailScreen(id:String, navigateToSettings: (SettingModel) -> Unit) {
    var settingModel = SettingModel(id = "teste", darkMode = true)
    Column(Modifier
        .fillMaxSize()
        .background(Color.Green),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.weight(1f))
        Text(text = "Detail: $id", fontSize = 30.sp)
        Spacer(Modifier.weight(1f))
        Button(onClick = {navigateToSettings(settingModel) }) {
            Text(text = "Ajustes")
        }
        Spacer(Modifier.weight(1f))
    }
}