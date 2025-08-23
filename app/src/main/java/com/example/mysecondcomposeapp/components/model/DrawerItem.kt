package com.example.mysecondcomposeapp.components.model

import androidx.compose.ui.graphics.vector.ImageVector

data class DrawerItem(
    val title: String,
    val icon: ImageVector,
    val notification: Int
)
