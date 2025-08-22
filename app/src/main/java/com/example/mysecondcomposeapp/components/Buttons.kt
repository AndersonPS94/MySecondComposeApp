package com.example.mysecondcomposeapp.components

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mysecondcomposeapp.R


@Preview
@Composable
fun MyFAB(modifier: Modifier = Modifier) {
    FloatingActionButton(
        onClick = {},
        shape = CircleShape,
        contentColor = Color.White,
        containerColor = Color.Red,
        elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 12.dp),
        modifier = modifier
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_add_24),
            contentDescription = ""
        )
    }
}

