package com.example.mysecondcomposeapp.components.animations

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateOffsetAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun FullAnimateAsState(modifier: Modifier = Modifier) {
    var isSelected: Boolean by remember { mutableStateOf(false) }
    val animatedColor: Color by animateColorAsState(
        targetValue = if (isSelected) Color.Red else Color.Blue,
        label = "ColorAnimation"
    )

    val animateSize: Dp by animateDpAsState(
      targetValue = if (isSelected) 300.dp else 150.dp,
    )

    val animateOffset: Offset by animateOffsetAsState(
        targetValue = if (isSelected) Offset(0f, 300f)  else Offset(0f, 0f) ,
    )

    val animatedFloat: Float by animateFloatAsState(
        targetValue = if (isSelected) 0.5f else 1f,
        label = "FloatAnimation"
    )

    Column (horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
        .padding(32.dp).fillMaxSize()
    ){
        Button(onClick = {isSelected = !isSelected}) {
            Spacer(modifier = Modifier.height(32.dp))
            Text(text = "Selecionar")
        }
        Text("Float: %.2f".format(animatedFloat))
        Spacer(modifier = Modifier.height(32.dp))

        Box(
            modifier = Modifier
                .offset(animateOffset.x.dp, animateOffset.y.dp)
                .size(animateSize)
                .background(animatedColor.copy(alpha = animatedFloat))) {

        }
    }
}