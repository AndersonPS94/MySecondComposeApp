package com.example.mysecondcomposeapp.components

import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
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
fun MyTopAppBar(modifier: Modifier = Modifier, onNavSelected: () -> Unit) {

    CenterAlignedTopAppBar(title = { Text("Minha aplicação")},
        navigationIcon = { Icon(
            Icons.Default.Menu,
            contentDescription = "",
            tint = Color.White,

            modifier = modifier
                .clickable{
                    onNavSelected()
                }
        )
          },

        actions = {
            Icon(
                Icons.Default.AccountBox,
                contentDescription = ""
            )
            Icon(
                Icons.Default.CheckCircle,
                contentDescription = ""
            )
            Icon(
                Icons.Default.Add,
                contentDescription = "",

            )
    },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Gray,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.Magenta,
            actionIconContentColor = Color.White,
            scrolledContainerColor = Color.Blue
            ),
        )
    }
