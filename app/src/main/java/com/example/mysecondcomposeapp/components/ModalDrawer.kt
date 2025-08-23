package com.example.mysecondcomposeapp.components

import android.graphics.drawable.Icon
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Badge
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mysecondcomposeapp.components.model.DrawerItem
import kotlinx.coroutines.launch

@Composable
fun MyModalDrawer(drawerState: DrawerState, content: @Composable (() -> Unit)) {
    val scope = rememberCoroutineScope()
    val myItems = listOf(
        DrawerItem(
            title = "Home",
            icon = Icons.Default.Home,
            notification = 0
        ),
        DrawerItem(
            title = "Profile",
            icon = Icons.Default.Person,
            notification = 1
        ),
        DrawerItem(
            title = "PlayList",
            icon = Icons.Default.PlayArrow,
            notification = 2
        ),
        DrawerItem(
            title = "Configurações",
            icon = Icons.Default.Build,
            notification = 0
        ),
        DrawerItem(
            title = "Sobre",
            icon = Icons.Default.Info,
            notification = 0
        ),
        DrawerItem(
            title = "Ajuda",
            icon = Icons.Default.Warning,
            notification = 0
        ),
        )

    var selectedIndex by remember { mutableIntStateOf(0) }
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet (
                drawerShape = RoundedCornerShape(topEnd = 20.dp, bottomEnd = 20.dp),
                drawerContainerColor = Color.White,
                drawerContentColor = Color.Red,
                drawerTonalElevation = 10.dp
            ){
                Spacer(modifier = Modifier.height(24.dp))
                myItems.forEachIndexed { index, item ->
                    NavigationDrawerItem(
                        label = { Text(text = item.title) },
                        selected = selectedIndex == index,
                        onClick = {
                            scope.launch {
                                selectedIndex = index
                                drawerState.close()
                            }
                        },
                        icon = { Icon(imageVector = item.icon, contentDescription = "") },
                        badge = {
                            if (item.notification > 0) {
                                Badge(
                                    containerColor = if(selectedIndex == index) Color.White else Color.Red,
                                    contentColor = if(selectedIndex == index) Color.Red else Color.White
                                ) { Text(text = item.notification.toString()) }
                            }
                        },
                        colors = NavigationDrawerItemDefaults.colors(
                            selectedContainerColor = Color.Red,
                            selectedTextColor = Color.White,
                            selectedIconColor = Color.White,
                            unselectedContainerColor = Color.White,
                            unselectedTextColor = Color.Red,
                            unselectedIconColor = Color.Red
                        )
                    )
                }
            }
        },
        scrimColor = Color.Red.copy(alpha = 0.5f),
    ) {
        content(

        )
    }
}

@Preview(showBackground = true)
@Composable
fun MyModalDrawerPreview() {
    MyModalDrawer(drawerState = DrawerState(DrawerValue.Open)) {
        Text(text = "Conteúdo")


    }
}