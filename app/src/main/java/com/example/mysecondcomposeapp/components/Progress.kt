package com.example.mysecondcomposeapp.components

import com.example.mysecondcomposeapp.R
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition


@Composable
fun Progress(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(Modifier.size(140.dp),
            color = Color.Red,
            strokeWidth = 10.dp,
            trackColor = Color.Blue,
            strokeCap = StrokeCap.Square)

        Spacer(modifier = Modifier.height(24.dp))
        LinearProgressIndicator(color = Color.Red,
            trackColor = Color.Blue,
            strokeCap = StrokeCap.Round,
            modifier = Modifier.height( 10.dp))
    }
}

@Composable
fun ProgressAdvanced(modifier: Modifier = Modifier) {

    var progress: Float by remember { mutableFloatStateOf(0.5f) }
    var isLoading: Boolean by remember { mutableStateOf(false) }
    val animatedProgress: Float by animateFloatAsState(targetValue = progress)
    Column(modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                progress = { animatedProgress },
                Modifier.size(140.dp),
                color = Color.Red,
                strokeWidth = 10.dp,
                trackColor = Color.Blue,
                strokeCap = StrokeCap.Square
            )
        }


        Spacer(modifier = Modifier.height(24.dp))
        LinearProgressIndicator(
            progress = { animatedProgress },
            color = Color.Red,
            trackColor = Color.Blue,
            strokeCap = StrokeCap.Round,
            modifier = Modifier.height(10.dp)
        )

        Row(Modifier.padding(24.dp)) {
            Button(onClick = { progress += 0.1f }) { Text(text = "Incrementar") }
            Spacer(modifier = Modifier.width(24.dp))
            Button(onClick = { progress -= 0.1f }) { Text(text = "Diminuir") }


        }
        Button(onClick = { isLoading = !isLoading }) { Text("Show/hide") }
    }
}

@Composable
fun ProgressPikachu(modifier: Modifier = Modifier) {

    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.pikachu))

    Column(modifier = modifier.fillMaxSize()
        .background(Color.Red),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LottieAnimation(composition = composition, iterations = LottieConstants.IterateForever)
    }
}

