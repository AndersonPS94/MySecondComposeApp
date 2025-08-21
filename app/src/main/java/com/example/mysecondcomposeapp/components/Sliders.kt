package com.example.mysecondcomposeapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.RangeSliderState
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderColors
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.SliderState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MySlider(modifier: Modifier = Modifier) {
    var myvalue: Float by remember { mutableFloatStateOf(0f) }
    Column(modifier = modifier.padding(horizontal = 30.dp)) {
        Slider(
            value = myvalue,
            enabled = true,
            onValueChange = { myvalue = it },
            colors = SliderDefaults.colors(
                thumbColor = Color.Red,
                disabledThumbColor = Color.DarkGray,
                activeTrackColor = Color.Red,
                activeTickColor = Color.Blue,
                disabledActiveTrackColor = Color.Gray,
                disabledActiveTickColor = Color.DarkGray,
                inactiveTrackColor = Color.Blue,
                inactiveTickColor = Color.Green,
                disabledInactiveTrackColor = Color.LightGray,
                disabledInactiveTickColor = Color.DarkGray,
            )
        )
        Text(text = myvalue.toString())
    }

}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MySliderAdvance(modifier: Modifier = Modifier) {
    var example: String by remember { mutableStateOf(":(") }
    val state: SliderState = remember {
        SliderState(
            value = 5f,
            valueRange = 0f..10f,
            steps = 9,
            onValueChangeFinished = {
                example = "Feliz"
            }

        )
    }


    val colors: SliderColors = SliderDefaults.colors(
        thumbColor = Color.Red,
        disabledThumbColor = Color.DarkGray,
        activeTrackColor = Color.Red,
        activeTickColor = Color.Blue,
        disabledActiveTrackColor = Color.Gray,
        disabledActiveTickColor = Color.DarkGray,
        inactiveTrackColor = Color.Blue,
        inactiveTickColor = Color.Green,
        disabledInactiveTrackColor = Color.LightGray,
        disabledInactiveTickColor = Color.DarkGray,
    )


    Column(modifier = modifier.padding(horizontal = 32.dp)) {
        Slider(state, colors = colors)
        Text(text = state.value.toString())
       }
    }


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyRangeSlider(modifier: Modifier = Modifier) {
    var state: RangeSliderState = remember { RangeSliderState(
        activeRangeStart = 3f,
        activeRangeEnd = 6f,
        valueRange = 0f..10f,
        steps = 8,

    ) }
    Column (modifier = modifier.padding(horizontal = 30.dp)) {
        RangeSlider(state = state)

    }
}