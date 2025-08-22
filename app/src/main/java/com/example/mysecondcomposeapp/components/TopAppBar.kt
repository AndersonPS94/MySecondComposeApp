package com.example.mysecondcomposeapp.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.mysecondcomposeapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(modifier: Modifier = Modifier) {

    TopAppBar(title = { Text("Minha aplicação")},
        navigationIcon = { Icon(
            painter = painterResource(R.drawable.ic_personita_24),
            contentDescription = ""
        )
          },

        actions = {
            Icon(
                painter = painterResource(R.drawable.ic_personita_24),
                contentDescription = ""
            )
            Icon(
                painter = painterResource(R.drawable.ic_personita_24),
                contentDescription = ""
            )
            Icon(
                painter = painterResource(R.drawable.ic_personita_24),
                contentDescription = "",
                tint = Color.Yellow
            )
    },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Gray,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.Magenta,
            actionIconContentColor = Color.Red,
            scrolledContainerColor = Color.Blue
            ),
        )
    }
